package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.contacts.generic.IDResultDTO
import com.kenvix.bookmgr.http.middleware.CheckSuperAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.UserIDLocation
import com.kenvix.bookmgr.http.utils.toPasswordHash
import com.kenvix.bookmgr.http.utils.toUserDTO
import com.kenvix.bookmgr.http.utils.validateEmail
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.utils.exception.CommonBusinessException
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import org.jooq.DSLContext
import org.jooq.impl.DSL
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

    private val illegalUserNameRegex = Regex("<|>|@|:|\\|\\\\|\\?|\"|'|\\[")

    /**
     * Create user
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.createUser() {
        val postParameters: Parameters = call.receiveParameters()

        val serialId = postParameters.getOrFail<String>("username").validateValue {
            it.length in 0..60 && !it.contains(illegalUserNameRegex)
        }.trim()

        val realName = postParameters.getOrFail<String>("realName").validateValue {
            it.length in 0..30 && !it.contains(illegalUserNameRegex)
        }.trim()

        val password = postParameters.getOrFail<String>("password").toPasswordHash()
        val email = postParameters["email"]?.validateEmail()

        if (email!= null && UserModel.isEmailExist(email))
            throw CommonBusinessException("Email have been used.", 1002)

        if (UserModel.isSerialIdExist(serialId))
            throw CommonBusinessException("ID have been used.", 1003)

        val uid = Routines.userAdd(
            AppConstants.jooqConfiguration,
            serialId,
            email,
            realName,
            password,
            AccessLevel.User,
            call.request.origin.remoteHost
        )

        val user = UserModel.fetchOneByUid(uid)
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
            //postParameters["phone"].ifNotNull { phone = it.validatePhoneNumber() }
        }

        UserModel.update(user)
        respondJson(null, "OK")
    }
}
