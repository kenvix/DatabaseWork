package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.BookDao
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookModel : BookDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}