package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.BookBorrowExpired.BOOK_BORROW_EXPIRED
import com.kenvix.bookmgr.orm.tables.pojos.BookBorrowExpired
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookBorrowExpiredModel : BaseModel {
    fun hasExpiredBook(uid: Long): Boolean {
        return Routines.bookBorrowerHasExpired(configuration(), uid) == true
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getAll() = dsl
        .select()
        .from(BOOK_BORROW_EXPIRED)
        .orderBy(BOOK_BORROW_EXPIRED.EXPECTED_RETURNED_AT.asc())
        .fetchInto(BookBorrowExpired::class.java)
}