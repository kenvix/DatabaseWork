package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.UserExtraDao
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object UserExtraModel : UserExtraDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}