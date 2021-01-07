package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.BookTypeDao
import com.kenvix.bookmgr.orm.tables.BookType.BOOK_TYPE
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookTypeModel : BookTypeDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getTypeIdByName(name: String): Int {
        return dsl.select(BOOK_TYPE.ID).from(BOOK_TYPE).where(BOOK_TYPE.NAME.eq(name)).fetchOne()?.value1() ?: 0
    }
}