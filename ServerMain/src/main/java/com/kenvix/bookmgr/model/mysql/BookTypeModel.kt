package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookType
import com.kenvix.bookmgr.contacts.generic.SecondBookType
import com.kenvix.bookmgr.contacts.generic.TopBookType
import com.kenvix.bookmgr.orm.tables.daos.BookTypeDao
import com.kenvix.bookmgr.orm.tables.BookType.BOOK_TYPE
import com.kenvix.web.server.KeyValueCache
import org.jooq.Configuration
import com.kenvix.bookmgr.orm.tables.pojos.BookType as BookTypeInDatabase


@OptIn(SingletonModel::class)
object BookTypeModel : BookTypeDao(), BaseModel {
    val bookStatusMap: Map<Int, BookType> = KeyValueCache.get("book_type_map") {
        val allTypes = getAll()

        LinkedHashMap<Int, BookType>().apply {
            // Must be ordered by parent id !
            allTypes.forEach {
                if (it.parentId == 0) {
                    put(it.id, TopBookType(it.id, it.name))
                } else {
                    val parent = get(it.parentId) as TopBookType
                    parent.childMap[it.id] = SecondBookType(it.id, it.name, parent)
                }
            }
        }
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getTypeIdByNameUncached(name: String): Int {
        return dsl.select(BOOK_TYPE.ID).from(BOOK_TYPE).where(BOOK_TYPE.NAME.eq(name)).fetchOne()?.value1() ?: 0
    }

    /**
     * Get all types ordered by parent id asc
     */
    fun getAll(): List<BookTypeInDatabase> = dsl
        .select()
        .from(BOOK_TYPE)
        .orderBy(BOOK_TYPE.PARENT_ID.asc())
        .fetchInto(BookTypeInDatabase::class.java)
}