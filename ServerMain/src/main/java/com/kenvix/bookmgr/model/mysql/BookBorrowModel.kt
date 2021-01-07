package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.BookBorrowDao
import com.kenvix.bookmgr.orm.tables.BookBorrow.BOOK_BORROW
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookBorrowModel : BookBorrowDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun fetchUidById(id: Long): Long? {
        return dsl.select(BOOK_BORROW.BORROWER_UID).from(BOOK_BORROW).where(BOOK_BORROW.ID.eq(id)).fetchOne()?.value1()
    }
}