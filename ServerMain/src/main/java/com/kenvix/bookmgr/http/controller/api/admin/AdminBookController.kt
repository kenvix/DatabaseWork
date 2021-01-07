package com.kenvix.bookmgr.http.controller.api.admin

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors
import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.AuthorModel
import com.kenvix.bookmgr.model.mysql.BookForUserModel
import com.kenvix.bookmgr.model.mysql.BookForUserModel.getBooksForUser
import com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR
import com.kenvix.bookmgr.orm.tables.BookAuthorMap.BOOK_AUTHOR_MAP
import com.kenvix.bookmgr.orm.tables.BookForUser.BOOK_FOR_USER
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthor
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
object AdminBookController : AdminApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckCommonAdminToken)
            }

            post("/") {
                middleware(CheckCommonAdminToken)

                val params = call.receiveParameters()

            }

            delete<BookIDLocation> {
                middleware(CheckCommonAdminToken)
            }

            patch<BookIDLocation> {
                middleware(CheckCommonAdminToken)

            }
        }
    }
}