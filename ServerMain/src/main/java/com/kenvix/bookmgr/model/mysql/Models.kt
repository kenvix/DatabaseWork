package com.kenvix.bookmgr.model.mysql

import com.google.common.cache.CacheStats
import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.Tables.BOOK_STATUS
import com.kenvix.bookmgr.orm.tables.pojos.BookStatus
import com.kenvix.web.server.Cached
import com.kenvix.web.server.KeyValueCache
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookStatusModel : BaseModel {
    val bookStatusMap: Map<Byte, String> = KeyValueCache.get("book_status_map") {
        LinkedHashMap<Byte, String>().apply {
            getAll().forEach{
                this[it.id] = it.description
            }
        }
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getAll() = dsl.select().from(BOOK_STATUS).orderBy(BOOK_STATUS.ID.asc()).fetchInto(BookStatus::class.java)
    fun invalidateCache() {
        KeyValueCache.invalidate("book_status_map")
    }
}