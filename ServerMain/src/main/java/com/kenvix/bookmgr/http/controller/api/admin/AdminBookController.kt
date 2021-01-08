package com.kenvix.bookmgr.http.controller.api.admin

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors
import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
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
                val user = middleware(CheckCommonAdminToken)
                val params: Parameters = call.receiveParameters()
                val authorIds: List<Long> = params.getAll("author[]")?.map { it.toLong() } ?: emptyList()

                val book = BookModel.transactionThreadLocal {
                    val book = Book().applyBookFromParams(params, user.uid)
                    BookModel.insert(book)
                    authorIds.forEach { authorId -> BookAuthorMapModel.insert(BookAuthorMap(book.id, authorId)) }
                    book
                }

                respondJson(book)
            }

            // 修改图书
            // 支持前端辅助：自动删除被删的作者
            put<BookIDLocation> { bookId ->
                val user = middleware(CheckCommonAdminToken)
                val params: Parameters = call.receiveParameters()
                val newAuthorIds: List<Long> = params.getAll("author[]")?.map { it.toLong() } ?: emptyList()
                val book = BookModel.fetchOneById(bookId.id).assertExist()
                val oldAuthorIds: List<Long> = BookAuthorMapModel.fetchAuthorIdListByBook(bookId.id)

                BookModel.transactionThreadLocal {
                    book.applyBookFromParams(params, user.uid)
                    BookModel.update(book)
                    (newAuthorIds - oldAuthorIds).forEach { authorId -> BookAuthorMapModel.insert(BookAuthorMap(book.id, authorId)) }
                    (oldAuthorIds - newAuthorIds).forEach { authorId -> BookAuthorMapModel.deleteByBookAndAuthorId(book.id, authorId) }
                    book
                }

                respondJson(book)
            }

            delete<BookIDLocation> { bookId ->
                middleware(CheckCommonAdminToken)
                BookModel.deleteById(bookId.id)
                respondSuccess("Deleted book")
            }

            patch<BookIDLocation> { bookId ->
                middleware(CheckCommonAdminToken)

            }
        }
    }

    private fun Book.applyBookFromParams(params: Parameters, uid: Long) = apply {
        title = params["title"].validateValue { it.length in 1..120 }
        description = params["description"] ?: ""
        createdAt = Timestamp(System.currentTimeMillis())
        creatorUid = uid
        numTotal = params["num_total"]?.run { toInt() }?.validateValue { it >= 0 } ?: 0
        numAvailable = params["num_available"]?.run { toInt() }?.validateValue { it <= numTotal } ?: 0
        typeId = params["type_id"]?.let {
            if (it.isNumeric()) {
                it.toInt()
            } else {
                PublisherModel.fetchOneByName(it)?.id?.toInt() ?: businessException("无此出版社")
            }
        } ?: 0
        status = params["status"]?.toByte() ?: 1
    }
}