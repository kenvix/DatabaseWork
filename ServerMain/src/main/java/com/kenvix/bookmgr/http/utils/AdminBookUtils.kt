package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.model.mysql.*
import com.kenvix.bookmgr.orm.tables.pojos.Author
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.stream.Collectors


object AdminBookControllerUtils {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS")

    internal suspend fun PipelineContext<Unit, ApplicationCall>.addBook() = withContext(Dispatchers.IO) {
        val user = middleware(CheckCommonAdminToken)
        val params: Parameters = call.receiveParameters()
        val authorIds: List<Long> = getAuthorIds(params)

        val book = BookModel.transactionThreadLocal {
            val book = Book().applyBookFromParams(params, user.uid)
            BookModel.insert(book)
            authorIds.forEach { authorId -> BookAuthorMapModel.insert(BookAuthorMap(book.id, authorId)) }
            book
        }

        respondSuccess("添加图书 ${book.title} 成功", book, URI("/admin/book/edit/${book.id}"))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.updateBook(bookId: Long) = withContext(Dispatchers.IO) {
        val user = middleware(CheckCommonAdminToken)
        val params: Parameters = call.receiveParameters()
        val newAuthorIds: List<Long> = getAuthorIds(params)
        val book = BookModel.fetchOneById(bookId).assertExist()
        val oldAuthorIds: List<Long> = BookAuthorMapModel.fetchAuthorIdListByBook(bookId)

        BookModel.transactionThreadLocal {
            book.applyBookFromParams(params, user.uid)
            BookModel.update(book)
            (newAuthorIds - oldAuthorIds).forEach { authorId ->
                BookAuthorMapModel.insert(BookAuthorMap(book.id, authorId))
            }
            (oldAuthorIds - newAuthorIds).forEach { authorId ->
                BookAuthorMapModel.deleteByBookAndAuthorId(book.id, authorId)
            }
            book
        }

        respondSuccess("修改图书 ${book.title} 成功", book, URI("/admin/book/edit/$bookId"))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.deleteBook(bookId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckCommonAdminToken)
        BookModel.deleteById(bookId)
        respondSuccess("删除图书成功")
    }

    private fun getAuthorIds(params: Parameters): List<Long> {
        return if (params["use_author_name_text_list"] != null) {
            (params["authors_text"] ?: "")
                .split("\n")
                .asSequence()
                .map { it.trim() }
                .filter { it.isNotBlank() }
                .map { it to AuthorModel.fetchOneIdByName(it) }
                .map {
                    if (it.second == null) {
                        val author = Author().apply {
                            name = it.first
                            fullname = it.first
                        }
                        AuthorModel.insert(author)
                        author.id
                    } else {
                        it.second!!
                    }
                }
                .toList()
        } else {
            params.getAll("author[]")?.map { it.toLong() } ?: emptyList()
        }
    }

    private fun Book.applyBookFromParams(params: Parameters, uid: Long) = apply {
        title = params["title"].validateValue { it.length in 1..120 }
        description = params["description"] ?: ""
        isbn = params["isbn"] ?: ""
        createdAt = params["created_at"]?.runCatching {
            Timestamp(dateDefaultFormatter.get().parse(replace('T', ' ')).time)
        }?.getOrDefault(Timestamp(System.currentTimeMillis())) ?: Timestamp(System.currentTimeMillis())
        creatorUid = uid
        numTotal = params["num_total"]?.run { toInt() }?.validateValue { it >= 0 } ?: 0
        numAvailable = params["num_available"]?.run { toInt() }?.validateValue { it <= numTotal } ?: 0
        publisherId = params["publisher_id"]?.let {
            if (it.isNumeric()) {
                it.toLong()
            } else {
                PublisherModel.fetchOneByName(it)?.id?.toLong() ?: businessException("无此出版社")
            }
        } ?: 0
        typeId = params["type_id"]?.let {
            if (it.isNumeric()) {
                it.toInt()
            } else {
                BookTypeModel.fetchByName(it)[0]?.id?.toInt() ?: businessException("无此书目类别")
            }
        } ?: 0
        status = params["status"]?.toByte() ?: 1
    }
}