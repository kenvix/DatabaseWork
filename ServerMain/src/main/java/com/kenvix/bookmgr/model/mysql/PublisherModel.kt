package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.PublisherDao
import com.kenvix.bookmgr.orm.tables.Publisher.PUBLISHER
import com.kenvix.bookmgr.orm.tables.pojos.Publisher
import com.kenvix.web.server.KeyValueCache
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object PublisherModel : PublisherDao(), BaseModel {
    val publisherMap: Map<Long, Publisher> = KeyValueCache.get("publisher_map") {
        LinkedHashMap<Long, Publisher>().apply {
            getAll().forEach{
                this[it.id] = it
            }
        }
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getAll() = dsl.select().from(PUBLISHER).fetchInto(Publisher::class.java)
}