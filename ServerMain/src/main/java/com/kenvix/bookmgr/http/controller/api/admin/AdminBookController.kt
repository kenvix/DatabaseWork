package com.kenvix.bookmgr.http.controller.api.admin

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors
import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.AdminBookControllerUtils.addBook
import com.kenvix.bookmgr.http.utils.AdminBookControllerUtils.deleteBook
import com.kenvix.bookmgr.http.utils.AdminBookControllerUtils.updateBook
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.*
import com.kenvix.bookmgr.model.mysql.BookForUserModel.getBooksForUser
import com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR
import com.kenvix.bookmgr.orm.tables.BookAuthorMap.BOOK_AUTHOR_MAP
import com.kenvix.bookmgr.orm.tables.BookForUser.BOOK_FOR_USER
import com.kenvix.bookmgr.orm.tables.pojos.Book
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthor
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthorMap
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URI
import java.sql.Timestamp

@KtorExperimentalLocationsAPI
object AdminBookController : AdminApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckCommonAdminToken)
            }

            // 添加图书
            // 支持前端辅助：type_id, publisher_id 如果提供数字则自动识别为 id，非数字则可自动根据内容查找ID
            post("/") {
               addBook()
            }

            // 修改图书
            // 支持前端辅助：自动删除被删的作者
            put<BookIDLocation> { bookId ->
                updateBook(bookId.id)
            }

            delete<BookIDLocation> { bookId ->
                deleteBook(bookId.id)
            }

            patch<BookIDLocation> { bookId ->
                middleware(CheckCommonAdminToken)

            }
        }
    }

}