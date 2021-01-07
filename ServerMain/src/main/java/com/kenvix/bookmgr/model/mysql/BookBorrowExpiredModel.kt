package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookBorrowExpiredModel : BaseModel {


    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}