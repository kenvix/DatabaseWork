package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.contacts.generic.*
import com.kenvix.bookmgr.contacts.server.ExamPO
import com.kenvix.bookmgr.contacts.server.PersonId
import com.kenvix.bookmgr.contacts.server.QuestionPO
import com.kenvix.bookmgr.contacts.server.SnapPO
import com.kenvix.bookmgr.model.mongo.PersonDocument
import com.kenvix.bookmgr.model.mongo.SnapDocument
import com.kenvix.web.utils.hasFlag
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import kotlinx.coroutines.runBlocking
import org.apache.http.auth.AuthenticationException
import org.bson.types.ObjectId
import org.litote.kmongo.id.toId
import java.time.Instant

@KtorExperimentalLocationsAPI
@Location("/examine/{id}")
class ExamineIDLocation(val id: String) {
    val mongoId by lazy(LazyThreadSafetyMode.NONE) { ObjectId(id).toId<ExamPO>() }
}

fun QuestionPO.toQuestionDTO(hideAnswer: Boolean = false): QuestionDTO {
    if (hideAnswer) {
        return QuestionDTO(_id.toString(), creatorUid, content, "", fullScore, type, mapOf(), studentScores)
    }
    return QuestionDTO(_id.toString(), creatorUid, content, teacherAnswer, fullScore, type, studentAnswers, studentScores)
}

fun ExamPO.toExamStudentDTO(questions: List<QuestionDTO>? = null): ExamStudentDTO {
    val map = hashMapOf<ClientQuestionId, QuestionDTO>()
    questions?.forEach {
        map[it._id] = it
    }
    return ExamStudentDTO(_id.toString(), status, examName, examDescription, examBeginAt.epochSecond, examEndAt.epochSecond, fullScore, map, fullScore)
}

fun ExamPO.toExamTeacherDTO(questions: List<QuestionDTO>? = null): ExamTeacherDTO {

    lateinit var teachersMap: MutableMap<UserId, PersonDTO>
    lateinit var studentsMap: MutableMap<UserId, PersonDTO>
    val questionsMap = mutableMapOf<ClientQuestionId, QuestionDTO>()
    runBlocking {
        teachersMap = personIDsToPersonDTOs(teachers)
        studentsMap = personIDsToPersonDTOs(students)
        questions?.forEach {
            questionsMap[it._id] = it
        }
    }

    return ExamTeacherDTO(_id.toString(), creatorUid, createdAt.epochSecond, status, examName, examDescription, examBeginAt.epochSecond, examEndAt.epochSecond, fullScore, teachersMap, studentsMap, questionsMap, studentTotalScores)
}

fun toExamTeacherDTO(): ExamPO {
    TODO()
}

fun ExamPO.isExamAlreadyBegin() =
        status.hasFlag(ExamStatus.ExamPublished) &&
                status.hasFlag(ExamStatus.Examinable) &&
                Instant.now().run {
                    this > examBeginAt && this < examEndAt
                }

fun ExamPO.isStudentHasQuestionAccess() =
        status.hasFlag(ExamStatus.ExamPublished) &&
                status.hasFlag(ExamStatus.Examinable) ||
                Instant.now().run {
                    this > examBeginAt && this < examEndAt
                }

fun ExamPO.isStudentHasAnswerAccess() =
        status.hasFlag(ExamStatus.ExamPublished) &&
                status.hasFlag(ExamStatus.AnswerPublished)

fun ExamPO.checkStudentAccess(uid: UserId) {
    if (!status.hasFlag(ExamStatus.ExamPublished) || (!students.containsKey(uid) && !teachers.containsKey(uid) && creatorUid != uid))
        throw AuthenticationException("你没有这套试卷的访问权限，因为你不是这场考试的考试或出题人")
}

fun ExamPO.checkTeacherAccess(uid: UserId) {
    if (!teachers.containsKey(uid) && creatorUid != uid)
        throw AuthenticationException("你没有这套试卷的访问权限，因为你不是这场考试的出题人")
}

suspend fun ExamPO.getSnapPO(): SnapPO? {
    return SnapDocument.findOneById(this.snaps)
}

suspend fun personIDsToPersonDTOs(source: MutableMap<UserId, PersonId>): MutableMap<UserId, PersonDTO> {
    val resultMap = mutableMapOf<UserId, PersonDTO>()
    source.forEach { entry ->
        val userPo = PersonDocument.findOneByMongoKey(entry.value.toString())
                ?: return@forEach

        val examIDs = mutableListOf<ClientExamId>()
        val adminExamIDs = mutableListOf<ClientExamId>()

        userPo.exams.forEach {
            examIDs.add(it.toString())
        }

        userPo.adminExams.forEach {
            examIDs.add(it.toString())
        }

        resultMap[entry.key] = PersonDTO(userPo._id.toString(), userPo.uid, userPo.school, userPo.realName, userPo.workerId, userPo.sex, userPo.startYear, userPo.description, examIDs, adminExamIDs)
    }
    return resultMap
}