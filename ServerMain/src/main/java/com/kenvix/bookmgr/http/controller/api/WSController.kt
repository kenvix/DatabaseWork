package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.contacts.server.ExamPO
import com.kenvix.bookmgr.contacts.server.QuestionPO
import com.kenvix.bookmgr.contacts.server.SnapUnitPO
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mongo.ExamDocument
import com.kenvix.bookmgr.model.mongo.QuestionDocument
import com.kenvix.bookmgr.model.mongo.SnapDocument
import com.kenvix.bookmgr.pb.ExamLog
import com.kenvix.utils.preferences.ServerEnv.UploadSaveDir
import com.kenvix.utils.preferences.ServerEnv.WebSiteUrl
import com.kenvix.web.utils.*
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.close
import io.ktor.routing.Route
import io.ktor.websocket.DefaultWebSocketServerSession
import io.ktor.websocket.webSocket
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.litote.kmongo.id.StringId
import org.litote.kmongo.toId
import java.util.concurrent.ConcurrentHashMap

object WSController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            webSocket("/log") { monitorExam() }
        }
    }

    data class StudentStateStorage(var updateTime: Long,
                                   var state: ExamLog.State,
                                   var lastSnapFileName: String?)

    private val clients = ConcurrentHashMap<Long, ConcurrentHashMap<ExamLog.InitReq.ClientType, DefaultWebSocketServerSession>?>()

    private val teacherClients = arrayListOf<DefaultWebSocketServerSession>()

    private val studentStatus = ConcurrentHashMap<Long, StudentStateStorage>()

    /**
     * 考试 Websocket
     */
    private suspend fun DefaultWebSocketServerSession.monitorExam() {
        val user = CheckUserToken.check(call, true)
        val uid = user.uid
        var examID: String? = null
        var clientType: ExamLog.InitReq.ClientType? = null
        logger.debug("${user.uid} / Connection Established")

        try {
            for (frame in incoming) {
                val req = withContext(Dispatchers.IO) {
                    ExamLog.Msg.parseFrom(frame.buffer).req
                }
                logger.debug("${user.uid} / Lost Connection")
                when (req.type) {
                    ExamLog.MsgType.PingMsg -> respondMsg {
                        rsp = buildRsp(ExamLog.MsgType.PongMsg) { pong = pongBuilder.alsoBuild { } }
                    }

                    ExamLog.MsgType.Init_Req -> {
                        examID = req.init.examId
                        clientType = req.init.clientType
                        if (!clients.containsKey(user.uid)) {
                            clients[user.uid] = ConcurrentHashMap()
                        }

                        when (clientType) {
                            ExamLog.InitReq.ClientType.Teacher -> {
                                if (ExamDocument.findOneById(StringId(examID))?.teachers?.keys?.contains(user.uid) != false) {
                                    respondMsg {
                                        rsp = buildRsp(ExamLog.MsgType.Init_Rsp) {
                                            init = initBuilder.alsoBuild {
                                                code = 1
                                                msg = "你没有这场考试的管理权限"
                                            }
                                        }
                                    }
                                    return
                                }
                            }
                            ExamLog.InitReq.ClientType.StudentMonitor -> {
                                if (!studentStatus.containsKey(user.uid)) {
                                    studentStatus[user.uid] = StudentStateStorage(req.init.time, ExamLog.State.OK,null)
                                }
                                logger.debug("${user.uid} / Exam Monitor Connected")
                            }
                            ExamLog.InitReq.ClientType.StudentExaminer -> {
                                logger.debug("${user.uid} / Examiner Connected")
                            }
                            else -> close()
                        }

                        // 断开旧的客户端的连接
                        clients[uid]?.get(clientType)?.close()
                        clients[uid]?.remove(clientType)
                        clients[uid]?.set(clientType, this)

                        respondMsg {
                            rsp = buildRsp(ExamLog.MsgType.Init_Rsp) {
                                init = initBuilder.alsoBuild {
                                    examId = examID
                                    code = 0
                                    msg = ""
                                    data = ""
                                }
                            }
                        }
                    }

                    ExamLog.MsgType.StateUpload_Req -> {
                        if (handleStateUpload(examID, clientType, req, uid)) return
                    }

                    ExamLog.MsgType.SnapUpload_Req -> {
                        if (handleSnapUpload(examID, clientType, req, uid)) return

                    }

                    ExamLog.MsgType.SetExamMsg_Req -> {
                        if (handleSetExamMsg(examID, clientType, req)) return
                    }

                    ExamLog.MsgType.SaveAnswer_Req -> {
                        if (handleSaveAnswer(examID, clientType, req, uid)) return
                    }

                    else -> {

                    }
                }

            }
        } catch (e: Throwable) {
            logger.warn("${user.uid} / Unexpected ws exception was thrown. This Connection is failed", e)
            this.runCatching { close() }
        } finally {
            // 连接断开后的操作
            if (clientType != null && clientType == ExamLog.InitReq.ClientType.StudentMonitor) {  // 设置用户为离开状态
                studentStatus[uid]?.state = ExamLog.State.LEAVE
            }
            if (clientType != null && clientType == ExamLog.InitReq.ClientType.Teacher) {
                teacherClients.remove(this)
            }
            logger.debug("${user.uid} / Lost Connection")

            if (clients[user.uid]?.size ?: 1 == 0) {
                clients[user.uid] = null
                logger.debug("${user.uid} / Resources released")
            }
        }
    }

    private suspend fun DefaultWebSocketServerSession.handleSnapUpload(examID: String?, clientType: ExamLog.InitReq.ClientType?, req: ExamLog.Req, uid: Long): Boolean {
        if (!checkInit(examID, clientType)) {
            return true
        }

        val snapInfo = req.snapUploadReq
        val filename = "$uid-${snapInfo.time}.${snapInfo.fileType}"
        val file = uploadSavePath.resolve(filename).toFile()

        if (!uploadSavePath.toFile().exists()) {
            uploadSavePath.toFile().mkdir()
        }

        file.outputStream().buffered().use { output -> output.write(snapInfo.content.toByteArray()) }
        val snapStorage = SnapDocument.findOneById(ExamDocument.findOneById(examID!!.toId())?.snaps!!)!!
        snapStorage.snaps[uid]?.add(SnapUnitPO(uid, filename, snapInfo.fileType))
        SnapDocument.updateOneById(snapStorage._id, snapStorage)
        studentStatus[uid]?.lastSnapFileName = filename
        sendRefreshState(uid)
        respondMsg {
            rsp = buildRsp(ExamLog.MsgType.SnapUpload_Rsp) {
                snapUploadRsp = snapUploadRspBuilder.alsoBuild {
                    code = 0
                }
            }
        }

        return false
    }

    private suspend fun DefaultWebSocketServerSession.handleSaveAnswer(examID: String?, clientType: ExamLog.InitReq.ClientType?, req: ExamLog.Req, uid: Long): Boolean {
        if (!checkInit(examID, clientType)) {
            return true
        }

        // 保存答案
        try {
            req.saveAnswerReq.answersList?.ifNotNull { answer ->
                val exam = examID.assertExist().toMongoId<ExamPO>().run {
                    ExamDocument.findOneById(this).assertExist()
                }

                answer.asFlow().filterNotNull().map {
                    it.questionId.toMongoId<QuestionPO>() to it.content
                }.filter {
                    it.first in exam.questions
                }.map {
                    QuestionDocument.findOneById(it.first)?.ifNotNull { question ->
                        question.studentAnswers[uid] = it.second
                        QuestionDocument.updateOne(question)
                    }
                }.collect()

                respondMsg {
                    buildRsp(ExamLog.MsgType.SaveAnswer_Rsp) {
                        saveAnswerRsp = saveAnswerRspBuilder.alsoBuild {
                            code = 0
                            msg = "OK"
                        }
                    }
                }
            }
        } catch (e: Throwable) {
            logger.info("$uid / Auto save failed", e)

            respondMsg {
                buildRsp(ExamLog.MsgType.SaveAnswer_Rsp) {
                    saveAnswerRsp = saveAnswerRspBuilder.alsoBuild {
                        code = 1
                        msg = e.message
                    }
                }
            }
        }
        return false
    }

    private suspend fun DefaultWebSocketServerSession.handleSetExamMsg(examID: String?, clientType: ExamLog.InitReq.ClientType?, req: ExamLog.Req): Boolean {
        if (!checkInit(examID, clientType)) {
            return true
        }
        if (clientType != ExamLog.InitReq.ClientType.Teacher) {
            respondMsg {
                buildRsp(ExamLog.MsgType.SetExamMsg_Rsp) {
                    setExamMsgRsp = setExamMsgRspBuilder.alsoBuild {
                        code = 1
                        msg = "你没有权限设置信息"
                    }
                }
            }
        }
        val reqMsg = req.setExamMsgReq

        if (!clients.containsKey(reqMsg.uid)) {
            val userClient = clients[reqMsg.uid]?.get(ExamLog.InitReq.ClientType.StudentExaminer)
            if (userClient != null && userClient.isActive) {
                userClient.respond {
                    buildMsg(ExamLog.Msg.Action.Cmd) {
                        cmd = buildCmd(ExamLog.MsgType.ReceiveExamMsg_CMD) {
                            receiveExamMsgCmd = receiveExamMsgCmdBuilder.alsoBuild {
                                msg = reqMsg.msg
                                this.type = reqMsg.type
                            }
                        }
                    }
                }
                respondMsg {
                    buildRsp(ExamLog.MsgType.SetExamMsg_Rsp) {
                        setExamMsgRsp = setExamMsgRspBuilder.alsoBuild {
                            code = 0
                        }
                    }
                }
            }
        }
        respondMsg {
            buildRsp(ExamLog.MsgType.SetExamMsg_Rsp) {
                setExamMsgRsp = setExamMsgRspBuilder.alsoBuild {
                    code = 2
                    msg = "用户未连接或不存在"
                }
            }
        }
        return false
    }

    private suspend fun DefaultWebSocketServerSession.handleStateUpload(examID: String?, clientType: ExamLog.InitReq.ClientType?, req: ExamLog.Req, uid: Long): Boolean {
        if (!checkInit(examID, clientType)) {
            return true
        }

        val payload = req.stateUploadReq
        studentStatus[uid]?.updateTime = payload.time
        studentStatus[uid]?.state = payload.state
        sendRefreshState(uid)
        respondMsg { rsp = buildRsp(ExamLog.MsgType.StateUpload_Rsp) { stateUploadRsp = stateUploadRspBuilder.alsoBuild { this.code = 0 } } }
        return false
    }


    private inline fun buildMsg(action: ExamLog.Msg.Action = ExamLog.Msg.Action.Rsp, crossinline body: ExamLog.Msg.Builder.() -> Unit): ExamLog.Msg {
        val builder = ExamLog.Msg.newBuilder()
        builder.action = action
        body(builder)
        return builder.build()
    }

    private inline fun buildCmd(type: ExamLog.MsgType, crossinline body: ExamLog.Cmd.Builder.() -> Unit): ExamLog.Cmd {
        val builder = ExamLog.Cmd.newBuilder()
        builder.type = type
        body(builder)
        return builder.build()
    }

    private inline fun buildRsp(type: ExamLog.MsgType, crossinline body: ExamLog.Rsp.Builder.() -> Unit): ExamLog.Rsp {
        val builder = ExamLog.Rsp.newBuilder()
        builder.type = type
        body(builder)
        return builder.build()
    }

    private suspend inline fun DefaultWebSocketServerSession.respond(crossinline body: () -> ExamLog.Msg) = withContext(Dispatchers.IO) {
        send(Frame.Binary(true, body().toByteArray()))
    }

    private inline fun <reified T : com.google.protobuf.GeneratedMessageV3.Builder<T>, reified R> T.alsoBuild(crossinline body: T.() -> Unit): R {
        body()
        return this.build() as R
    }

    private suspend inline fun DefaultWebSocketServerSession.respondMsg(crossinline body: ExamLog.Msg.Builder.() -> Unit) {
        respond { buildMsg(ExamLog.Msg.Action.Rsp, body) }
    }

    private suspend inline fun DefaultWebSocketServerSession.checkInit(examID: String?, clientType: ExamLog.InitReq.ClientType?): Boolean {
        if (clientType == null || examID == null) {
            respondMsg {
                rsp = buildRsp(ExamLog.MsgType.SnapUpload_Rsp) {
                    snapUploadRsp = snapUploadRspBuilder.alsoBuild {
                        code = 1
                        msg = "你没有init"
                    }
                }
            }
            close()
            return false
        }
        return true
    }

    private suspend inline fun sendRefreshState(uid: Long) {
        teacherClients.forEach {
            if (it.isActive) {
                it.respondMsg {
                    buildMsg(ExamLog.Msg.Action.Cmd) {
                        cmd = buildCmd(ExamLog.MsgType.ReceiveExamMsg_CMD) {
                            refreshStateCmd = refreshStateCmdBuilder.alsoBuild {
                                this.uid = uid
                                this.newPicUrl = "$WebSiteUrl/$UploadSaveDir/${studentStatus[uid]?.lastSnapFileName}"
                                this.state = studentStatus[uid]?.state
                            }
                        }
                    }
                }

            }
        }


    }
}