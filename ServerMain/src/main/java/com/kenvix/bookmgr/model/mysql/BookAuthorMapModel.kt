package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.BookAuthorMapDao
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookAuthorMapModel : BookAuthorMapDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}