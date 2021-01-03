package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.contacts.generic.ExamStatus
import com.kenvix.bookmgr.contacts.generic.UserId
import com.kenvix.bookmgr.contacts.server.ExamPO
import com.kenvix.bookmgr.contacts.server.PersonId
import com.kenvix.bookmgr.contacts.server.SnapPO
import com.kenvix.bookmgr.http.middleware.FastCheckUserToken
import com.kenvix.bookmgr.http.utils.*
import com.kenvix.bookmgr.model.mongo.ExamDocument
import com.kenvix.bookmgr.model.mongo.PersonDocument
import com.kenvix.bookmgr.model.mongo.SnapDocument
import com.kenvix.utils.exception.CommonBusinessException
import com.kenvix.utils.exception.InvalidResultException
import com.kenvix.utils.exception.NotFoundException
import com.kenvix.web.utils.*
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.Parameters
import io.ktor.locations.*
import io.ktor.request.receiveParameters
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.pipeline.PipelineContext
import java.time.Instant

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
object ExamTeacherController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get<ExamineIDLocation> { getExam(it) }
            get("/examine") { listExams() }
            post("/examine") { createExam() }
            patch<ExamineIDLocation> { partEditExam(it) }
            put<ExamineIDLocation> { fullEditExam(it) }
            delete<ExamineIDLocation> { deleteExam(it) }
        }
    }

    /**
     * 创建考试（此时不允许提交题目）
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.createExam() {
        val callerUser = middleware(FastCheckUserToken)
        val postParameters: Parameters = call.receiveParameters()
        val person = callerUser.getPerson().assertNotNull()
        val exam = ExamPO(
                creatorUid = callerUser.uid,
                teachers = getUserIdToMongoKeyListFromUserIdsString(postParameters.getAll("teachers")).toMutableMap(),
                students = getUserIdToMongoKeyListFromUserIdsString(postParameters.getAll("students")).toMutableMap(),
                examBeginAt = postParameters["examBeginAt"]?.toLong()?.run { Instant.ofEpochMilli(this) }
                        ?: Instant.now(),
                examName = postParameters["examName"].toString(),
                examDescription = postParameters["examDescription"] ?:"这个考试无描述",
                examEndAt = postParameters["examEndAt"]?.toLong()?.run { Instant.ofEpochMilli(this) } ?: Instant.now(),
                fullScore = postParameters["fullScore"]?.toInt() ?: 100,
                status = postParameters["status"]?.toInt() ?: ExamStatus.DraftOrHidden
        )
        val students = exam.students.mapNotNull { PersonDocument.findOneById(it.value) }
        val teachers = exam.teachers.mapNotNull { PersonDocument.findOneById(it.value) }
        if (students.count() != exam.students.count() || teachers.count() != exam.teachers.count())
            throw InvalidResultException("某些学生或老师不存在")

        ExamDocument.insertOne(exam)
        SnapDocument.insertOne(SnapPO(_id = exam.snaps, exam = exam._id))

        person.adminExams.add(exam._id)

        teachers.forEach {
            it.adminExams.add(exam._id)
            PersonDocument.updateOne(it)
        }

        students.forEach {
            it.exams.add(exam._id)
            PersonDocument.updateOne(it)
        }

        PersonDocument.updateOne(person)

        respondJson(exam.toExamTeacherDTO(), "创建考试成功")
    }

    private suspend fun PipelineContext<Unit, ApplicationCall>.fullEditExam(id: ExamineIDLocation) {
        val callerUser = middleware(FastCheckUserToken)
        val postParameters: Parameters = call.receiveParameters()
        val exam = ExamDocument.findOneById(id.mongoId).assertExist()
        exam.checkTeacherAccess(callerUser.uid)

        // val person = callerUser.getPerson().assertNotNull()
        val oldTeachers = exam.teachers
        val oldStudents = exam.students

        exam.apply {
            teachers = getUserIdToMongoKeyListFromUserIdsString(postParameters.getAll("teachers")).toMutableMap()
            students = getUserIdToMongoKeyListFromUserIdsString(postParameters.getAll("students")).toMutableMap()
            examBeginAt = postParameters["examBeginAt"]?.toLong()?.run { Instant.ofEpochMilli(this) } ?: Instant.now()
            examEndAt = postParameters["examEndAt"]?.toLong()?.run { Instant.ofEpochMilli(this) } ?: Instant.now()
            fullScore = postParameters["fullScore"]?.toInt() ?: 100
            status = postParameters["status"]?.toInt() ?: ExamStatus.DraftOrHidden
        }

        // 交集 <Cloned , Immutable>
        val diffStudents: Map<UserId, PersonId> = HashMap(oldStudents).apply { keys.retainAll(exam.students.keys) }
        val diffTeachers: Map<UserId, PersonId> = HashMap(oldTeachers).apply { keys.retainAll(exam.teachers.keys) }

        // 旧-新差集 : DELETE
        oldStudents.keys.removeAll(diffStudents.keys)
        oldTeachers.keys.removeAll(diffTeachers.keys)
        oldStudents.mapNotNull { PersonDocument.findOneById(it.value) }.forEach {
            it.exams.remove(exam._id)
            PersonDocument.updateOne(it)
        }
        oldTeachers.mapNotNull { PersonDocument.findOneById(it.value) }.forEach {
            it.adminExams.remove(exam._id)
            PersonDocument.updateOne(it)
        }

        // 新-旧差集 : ADD
        HashMap(exam.students)
                .apply { keys.removeAll(diffStudents.keys) }
                .mapNotNull { PersonDocument.findOneById(it.value) }
                .forEach {
                    it.exams.add(exam._id)
                    PersonDocument.updateOne(it)
                }

        HashMap(exam.teachers)
                .apply { keys.removeAll(diffStudents.keys) }
                .mapNotNull { PersonDocument.findOneById(it.value) }
                .forEach {
                    it.adminExams.add(exam._id)
                    PersonDocument.updateOne(it)
                }

        ExamDocument.updateOne(exam)

        respondJson(exam.toExamTeacherDTO(), "修改考试成功")
    }

    private suspend fun PipelineContext<Unit, ApplicationCall>.partEditExam(id: ExamineIDLocation) {
        val callerUser = middleware(FastCheckUserToken)
        val postParameters: Parameters = call.receiveParameters()
        val exam = ExamDocument.findOneById(id.mongoId).assertExist()
        exam.checkTeacherAccess(callerUser.uid)

        val person = callerUser.getPerson().assertNotNull()

        postParameters.getAll("action")?.forEach { action ->
            when (action) {
                "setExamPublished" -> {
                    exam.status = exam.status.flaggedOf(ExamStatus.ExamPublished)
                }
                "unsetExamPublished" -> {
                    exam.status = exam.status.unflaggedOf(ExamStatus.ExamPublished)
                }
                "setAnswerPublished" -> {
                    exam.status = exam.status.flaggedOf(ExamStatus.AnswerPublished)
                }
                "unsetAnswerPublished" -> {
                    exam.status = exam.status.unflaggedOf(ExamStatus.AnswerPublished)
                }
                "setExaminable" -> {
                    exam.status = exam.status.flaggedOf(ExamStatus.Examinable)
                }
                "unsetExaminable" -> {
                    exam.status = exam.status.unflaggedOf(ExamStatus.Examinable)
                }
            }
        }
        respondJson(null)
    }

    private suspend fun PipelineContext<Unit, ApplicationCall>.listExams() {
        val callerUser = middleware(FastCheckUserToken)
        respondJson(PersonDocument.findOneByMongoKey(callerUser.mongoKey)?.adminExams)
    }

    private suspend fun PipelineContext<Unit, ApplicationCall>.getExam(id: ExamineIDLocation) {
        middleware(FastCheckUserToken)
        respondJson(ExamDocument.findOneById(id.mongoId))
    }

    private suspend fun PipelineContext<Unit, ApplicationCall>.deleteExam(id: ExamineIDLocation) {
        val user = middleware(FastCheckUserToken)
        val examDocument = ExamDocument.findOneById(id.mongoId) ?: throw NotFoundException("考试不存在")
        if (examDocument.creatorUid != user.uid) {
            throw CommonBusinessException("只有创建者才可以删除考试", 1001)
        }

        deleteExamFromUsers(examDocument.students, id.id)
        deleteExamFromUsers(examDocument.teachers, id.id)

        SnapDocument.deleteOneById(examDocument.snaps)
        ExamDocument.deleteOneById(id.mongoId)
        
        respondJson(null)
    }

    private suspend fun deleteExamFromUsers(ids: MutableMap<UserId, PersonId>, examId: String) {
        for (i in ids) {
            val teachers = PersonDocument.findOneById(i.value) ?: continue
            val newList = teachers.adminExams.filter { originId -> originId.toString() != examId }.toMutableList()
            teachers.exams = newList
            PersonDocument.updateOneById(i.value, teachers)
        }
    }
}