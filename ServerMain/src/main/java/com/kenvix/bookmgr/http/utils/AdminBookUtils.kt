package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.model.mysql.BookAuthorMapModel
import com.kenvix.bookmgr.model.mysql.BookModel
import com.kenvix.bookmgr.model.mysql.PublisherModel
import com.kenvix.bookmgr.orm.tables.pojos.Book
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthorMap
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URI
import java.sql.Timestamp

object AdminBookControllerUtils {

    internal suspend fun PipelineContext<Unit, ApplicationCall>.addBook() = withContext(Dispatchers.IO) {
        val user = middleware(CheckCommonAdminToken)
        val params: Parameters = call.receiveParameters()
        val authorIds: List<Long> = params.getAll("author[]")?.map { it.toLong() } ?: emptyList()

        val book = BookModel.transactionThreadLocal {
            val book = Book().applyBookFromParams(params, user.uid)
            BookModel.insert(book)
            authorIds.forEach { authorId -> BookAuthorMapModel.insert(BookAuthorMap(book.id, authorId)) }
            book
        }

        respondSuccess("添加图书 ${book.title} 成功", book, URI("/admin/book"))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.updateBook(bookId: Long) = withContext(Dispatchers.IO) {
        val user = middleware(CheckCommonAdminToken)
        val params: Parameters = call.receiveParameters()
        val newAuthorIds: List<Long> = params.getAll("author[]")?.map { it.toLong() } ?: emptyList()
        val book = BookModel.fetchOneById(bookId).assertExist()
        val oldAuthorIds: List<Long> = BookAuthorMapModel.fetchAuthorIdListByBook(bookId)

        BookModel.transactionThreadLocal {
            book.applyBookFromParams(params, user.uid)
            BookModel.update(book)
            (newAuthorIds - oldAuthorIds).forEach { authorId -> BookAuthorMapModel.insert(BookAuthorMap(book.id, authorId)) }
            (oldAuthorIds - newAuthorIds).forEach { authorId -> BookAuthorMapModel.deleteByBookAndAuthorId(book.id, authorId) }
            book
        }

        respondSuccess("修改图书 ${book.title} 成功", book, URI("/admin/book"))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.deleteBook(bookId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckCommonAdminToken)
        BookModel.deleteById(bookId)
        respondSuccess("删除图书成功")
    }

    internal fun Book.applyBookFromParams(params: Parameters, uid: Long) = apply {
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