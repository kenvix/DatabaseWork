package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.PublisherDao
import com.kenvix.bookmgr.orm.tables.Publisher.PUBLISHER
import com.kenvix.bookmgr.orm.tables.pojos.Publisher
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object PublisherModel : PublisherDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun fetchAll() = dsl.select().from(PUBLISHER).fetchInto(Publisher::class.java)
}