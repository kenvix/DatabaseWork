package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.borrowBookForCurrentUser
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.getAllBookBorrowsForCurrentUser
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.renewBookForCurrentUser
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.returnBookForCurrentUser
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.http.utils.BorrowIDLocation
import com.kenvix.web.utils.respondJson
import io.ktor.locations.*
import io.ktor.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
object BookBorrowController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            // 列出我的所有借书
            get("/") {
                respondJson(getAllBookBorrowsForCurrentUser())
            }

            // 请求借书，即“新增借书”
            post<BookIDLocation> { bookId ->
                borrowBookForCurrentUser(bookId.id)
            }

            // 续期，即“修改借书”
            patch<BorrowIDLocation> { borrowId ->
                renewBookForCurrentUser(borrowId.id)
            }

            // 还书，即“删除借书”
            delete<BorrowIDLocation> { borrowId ->
                returnBookForCurrentUser(borrowId.id)
            }
        }
    }
}