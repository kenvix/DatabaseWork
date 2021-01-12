package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.daos.BookAuthorMapDao
import com.kenvix.bookmgr.orm.tables.BookAuthorMap.BOOK_AUTHOR_MAP
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookAuthorMapModel : BookAuthorMapDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun fetchAuthorIdListByBook(bookId: Long): List<Long> = dsl
        .select(BOOK_AUTHOR_MAP.AUTHOR_ID)
        .from(BOOK_AUTHOR_MAP)
        .where(BOOK_AUTHOR_MAP.BOOK_ID.eq(bookId))
        .fetchInto(Long::class.java)

    fun deleteByBookAndAuthorId(bookId: Long, authorId: Long) {
        Routines.bookAuthorMapDelete(configuration(), bookId, authorId)
    }
}