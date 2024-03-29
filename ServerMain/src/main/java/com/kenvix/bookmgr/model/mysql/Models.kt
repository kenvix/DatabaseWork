package com.kenvix.bookmgr.model.mysql

import com.google.common.cache.CacheStats
import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.Tables.*
import com.kenvix.bookmgr.orm.tables.Book
import com.kenvix.bookmgr.orm.tables.BookBorrowExpired
import com.kenvix.bookmgr.orm.tables.pojos.BookBorrowForAdmin
import com.kenvix.bookmgr.orm.tables.pojos.BookStatus
import com.kenvix.bookmgr.orm.tables.pojos.UserForAdmin
import com.kenvix.web.server.Cached
import com.kenvix.web.server.KeyValueCache
import org.jooq.Configuration
import org.jooq.impl.DSL
import java.sql.Timestamp

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

@OptIn(SingletonModel::class)
object BookBorrowForAdminModel : BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getAll() = dsl
        .select()
        .from(BOOK_BORROW_FOR_ADMIN)
        .orderBy(BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT.asc().nullsFirst())
        .fetchInto(BookBorrowForAdmin::class.java)

    fun getAllExpired() = dsl
        .select()
        .from(BOOK_BORROW_FOR_ADMIN)
        .where(BOOK_BORROW_FOR_ADMIN.EXPECTED_RETURNED_AT.lessThan(Timestamp(System.currentTimeMillis())).and(BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT.isNull))
        .orderBy(BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT.asc().nullsFirst())
        .fetchInto(BookBorrowForAdmin::class.java)
}

@OptIn(SingletonModel::class)
object UserForAdminModel : BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getOneByUid(uid: Long): UserForAdmin? = dsl
        .select()
        .from(USER_FOR_ADMIN)
        .where(USER_FOR_ADMIN.UID.eq(uid))
        .fetchOneInto(UserForAdmin::class.java)

    fun getAll(): List<UserForAdmin> = dsl
        .select()
        .from(USER_FOR_ADMIN)
        .where(USER_FOR_ADMIN.UID.greaterThan(0))
        .orderBy(USER_FOR_ADMIN.UID.asc())
        .fetchInto(UserForAdmin::class.java)

    private val countQuery = DSL.query("SELECT count(*) from " + USER_FOR_ADMIN.name)
    fun getTableApproximateCount(): Long = dsl.explain(countQuery).rows().toLong()
}