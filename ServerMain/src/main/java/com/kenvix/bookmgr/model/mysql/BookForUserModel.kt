package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.BookForUser.*
import com.kenvix.bookmgr.orm.tables.pojos.BookForUser
import org.jooq.Condition
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object BookForUserModel : BaseModel {
    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    fun getBooksForAdmin(conditions: List<Condition>): MutableList<BookForUser> {
        val queryBuilder = dsl
            .select()
            .from(BOOK_FOR_USER)
            .where(conditions)
            .orderBy(BOOK_FOR_USER.ID)

        return queryBuilder.fetchInto(BookForUser::class.java)
    }

    fun getBooksForUser(conditions: List<Condition>): MutableList<BookForUser> {
        val queryBuilder = dsl
            .select(
                BOOK_FOR_USER.ID,
                BOOK_FOR_USER.TITLE,
                BOOK_FOR_USER.DESCRIPTION,
                BOOK_FOR_USER.CREATED_AT,
                BOOK_FOR_USER.NUM_TOTAL,
                BOOK_FOR_USER.NUM_AVAILABLE,
                BOOK_FOR_USER.STATUS,
                BOOK_FOR_USER.STATUS_DESCRIPTION,
                BOOK_FOR_USER.TYPE_NAME,
                BOOK_FOR_USER.PUBLISHER_NAME,
                BOOK_FOR_USER.PUBLISHER_ID,
                BOOK_FOR_USER.AUTHOR_NAME,
                BOOK_FOR_USER.AUTHOR_FULLNAME,
                BOOK_FOR_USER.AUTHOR_COUNTRY,
            )
            .from(BOOK_FOR_USER)
            .where(conditions).and(BOOK_FOR_USER.STATUS.greaterOrEqual(4))
            .orderBy(BOOK_FOR_USER.ID)

        return queryBuilder.fetchInto(BookForUser::class.java)
    }
}