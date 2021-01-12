package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.pojos.Author
import com.kenvix.bookmgr.orm.tables.Author.AUTHOR
import com.kenvix.bookmgr.orm.tables.daos.AuthorDao
import org.jooq.Configuration
import org.jooq.Record1
import org.jooq.SelectConditionStep

@OptIn(SingletonModel::class)
object AuthorModel : AuthorDao(), BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getAuthorsIdsConditionByName(names: List<String>): SelectConditionStep<Record1<Long>>? {
        return AppConstants.dslContext.select(AUTHOR.ID).from(AUTHOR).where(AUTHOR.NAME.`in`(names))
    }

    fun fetchOneIdByName(name: String): Long? =
        dsl.select(AUTHOR.ID).from(AUTHOR).where(AUTHOR.NAME.eq(name)).fetchOne()?.value1()

    fun fetchAll() = dsl.select().from(AUTHOR).fetchInto(Author::class.java)
}