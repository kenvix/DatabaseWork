package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.contacts.generic.IDResultDTO
import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.contacts.server.PersonPO
import com.kenvix.bookmgr.http.middleware.CheckSuperAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.*
import com.kenvix.bookmgr.model.mongo.PersonDocument
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.utils.exception.CommonBusinessException
import com.kenvix.web.utils.*
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.features.origin
import io.ktor.http.Parameters
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.delete
import io.ktor.locations.get
import io.ktor.locations.put
import io.ktor.request.receiveParameters
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.getOrFail
import io.ktor.util.pipeline.PipelineContext
import kotlinx.coroutines.runBlocking
import java.sql.Timestamp

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
internal object UserController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") { getCurrentUserInfo() }
            get<UserIDLocation> { getUserInfo(it) }
            post("/") { createUser() }
            put<UserIDLocation> { updateUserInfo(it) }
            delete<UserIDLocation> { deleteUser(it) }
        }
    }

    /**
     * Create user
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.createUser() {
        val postParameters: Parameters = call.receiveParameters()
        val timeNow = Timestamp(System.currentTimeMillis())
        val mongoPerson = PersonPO(uid = -1)

        val user = User().apply {
            name = postParameters.getOrFail<String>("username").validateValue { it.length in 0..60 }.trim()
            password = postParameters.getOrFail<String>("password").toPasswordHash()
            email = postParameters["email"]?.validateEmail()
            phone = postParameters.getOrFail<String>("phone").validatePhoneNumber()
            role = AccessLevel.User
            createTime = timeNow
            loginTime = timeNow
            createIp = call.request.origin.remoteHost
            loginIp = call.request.origin.remoteHost
            mongoKey = mongoPerson._id.toString()
        }
        if (user.email!= null && UserModel.isEmailExist(user.email)){
            throw CommonBusinessException("Email have been used.", 1002)
        }
        if (UserModel.isUserNameExist(user.name))
            throw CommonBusinessException("User name have been used.", 1003)


        UserModel.transactionThreadLocal {
            UserModel.insert(user)
            mongoPerson.uid = user.uid
            runBlocking { PersonDocument.insertOne(mongoPerson) }
        }

        respondJson(user.toUserDTO(CheckUserToken.generateToken(user)))
    }

    /**
     * Delete user
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.deleteUser(userLocation: UserIDLocation) {
        val callerUser = middleware(CheckSuperAdminToken)
        UserModel.deleteById(userLocation.id)
        respondJson(IDResultDTO(callerUser.uid))
    }

    /**
     * Get current user info
     * GET /user
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.getCurrentUserInfo() {
        respondJson(middleware(CheckUserToken).toUserDTO())
    }

    /**
     * Get specified user info
     * GET /user/{id}
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.getUserInfo(userLocation: UserIDLocation) {
        val user = UserModel.fetchOneByUid(userLocation.id).assertExist()
        respondJson(user.toUserDTO())
    }

    /**
     * Update user
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.updateUserInfo(userLocation: UserIDLocation) {
        val postParameters: Parameters = call.receiveParameters()

        val callerUser = middleware(CheckUserToken)
        if (userLocation.id != callerUser.uid)
            middleware(CheckSuperAdminToken)

        val user = callerUser.apply {
            uid = userLocation.id

            postParameters["email"].ifNotNull { email = it.validateEmail() }
            postParameters["password"].ifNotNull { password = it.toPasswordHash() }
            postParameters["phone"].ifNotNull { phone = it.validatePhoneNumber() }
        }

        UserModel.update(user)
        respondJson(null, "OK")
    }
}
