package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.Book
import com.kenvix.bookmgr.orm.tables.daos.BookDao
import org.jooq.Configuration
import org.jooq.impl.DSL

@OptIn(SingletonModel::class)
object BookModel : BookDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    private val countQuery = DSL.query("SELECT count(*) from " + Book.BOOK.name)
    fun getTableApproximateCount(): Long = dsl.explain(countQuery).rows().toLong()
}