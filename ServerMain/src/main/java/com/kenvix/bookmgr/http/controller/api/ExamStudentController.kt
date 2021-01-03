package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.contacts.generic.ExamStatus
import com.kenvix.bookmgr.contacts.generic.StudentExamFlag
import com.kenvix.bookmgr.contacts.server.ExamPO
import com.kenvix.bookmgr.http.middleware.FastCheckUserToken
import com.kenvix.bookmgr.http.utils.*
import com.kenvix.bookmgr.model.mongo.ExamDocument
import com.kenvix.bookmgr.model.mongo.PersonDocument
import com.kenvix.bookmgr.model.mongo.QuestionDocument
import com.kenvix.web.utils.*
import io.ktor.application.ApplicationCall
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.get
import io.ktor.locations.put
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.util.pipeline.PipelineContext
import org.bson.types.ObjectId
import org.litote.kmongo.id.toId

@KtorExperimentalLocationsAPI
object ExamStudentController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/examine") { getMyExams() }
            get<ExamineIDLocation> { getExamDetails(it) }
            put<ExamineIDLocation> { submitExam(it) }
        }
    }

    /**
     * 获取我的考试列表，包括考试概述信息。不包含题目
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.getMyExams() {
        val callerUser = middleware(FastCheckUserToken)
        PersonDocument.findOneById(ObjectId(callerUser.mongoKey).toId()).assertExist().also { personPO ->
            personPO.exams.mapNotNull {
                ExamDocument.findOneById(it)?.toExamStudentDTO()
            }.filter { it.status.hasFlag(ExamStatus.ExamPublished) }.also {
                respondJson(it)
            }
        }
    }

    /**
     * 获取我的考试概述详细信息。如果此接口调用时尚未开始考试，则没有题目信息。
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.getExamDetails(examineIDLocation: ExamineIDLocation) {
        val callerUser = middleware(FastCheckUserToken)
        val exam = ExamDocument.findOneById(examineIDLocation.mongoId).assertExist()
        exam.checkStudentAccess(callerUser.uid)

        val isStudentHasQuestionAccess = exam.isStudentHasQuestionAccess() &&
                (exam.studentTotalScores[callerUser.uid]?.get(1)?.hasFlag(StudentExamFlag.Submitted) == false) &&
                (exam.studentTotalScores[callerUser.uid]?.get(1)?.hasFlag(StudentExamFlag.PermissionRevoked) == false)

        val questions = if (isStudentHasQuestionAccess) {
            exam.questions.mapNotNull { QuestionDocument.findOneById(it)?.toQuestionDTO() }
        } else {
            null
        }

        //TODO: 增加公布答案功能
        respondJson(exam.toExamStudentDTO(questions), if (!isStudentHasQuestionAccess) "题目不可访问" else "考试题目如下")
    }

    /**
     * 交卷。此过程不会保存任何答案，仅将试卷标记为已提交。
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.submitExam(examineIDLocation: ExamineIDLocation) {
        val callerUser = middleware(FastCheckUserToken)
        val exam: ExamPO = ExamDocument.findOneById(examineIDLocation.mongoId).assertExist()
        exam.checkStudentAccess(callerUser.uid)
        val scores = exam.studentTotalScores[callerUser.uid] ?: arrayOf(0, 0)
        scores[1] = scores[1].flaggedOf(StudentExamFlag.Submitted)

        ExamDocument.updateOne(exam)
        respondSuccess("交卷成功")
    }

}