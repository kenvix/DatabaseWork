package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.daos.BookBorrowDao
import com.kenvix.bookmgr.orm.tables.BookBorrow.BOOK_BORROW
import com.kenvix.bookmgr.orm.tables.User
import org.jooq.Configuration
import org.jooq.impl.DSL

@OptIn(SingletonModel::class)
object BookBorrowModel : BookBorrowDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getUnreturnedBookNum(uid: Long): Int {
        return Routines.bookBorrowUnreturnedNum(configuration(), uid) ?: 0
    }

    fun fetchUidById(id: Long): Long? {
        return dsl.select(BOOK_BORROW.BORROWER_UID).from(BOOK_BORROW).where(BOOK_BORROW.ID.eq(id)).fetchOne()?.value1()
    }

    private val countQuery = DSL.query("SELECT count(*) from " + BOOK_BORROW.name)
    fun getTableApproximateCount(): Long = dsl.explain(countQuery).rows().toLong()
}