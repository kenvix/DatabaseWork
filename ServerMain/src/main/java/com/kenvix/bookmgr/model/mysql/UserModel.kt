package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.UserId
import com.kenvix.bookmgr.orm.tables.Book
import com.kenvix.bookmgr.orm.tables.User.USER
import com.kenvix.bookmgr.orm.tables.daos.UserDao
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.from
import com.kenvix.web.utils.limit
import com.kenvix.web.utils.select
import com.kenvix.web.utils.where
import org.jooq.Configuration
import org.jooq.impl.DSL

@OptIn(SingletonModel::class)
object UserModel : UserDao(), BaseModel {
    private val table
        get() = USER

    fun isSerialIdExist(name: String): Boolean {
        return (dsl select table.UID from table where table.SERIAL_ID.eq(name) limit 1).fetchOne() != null
    }

    fun isEmailExist(email: String): Boolean {
        return (dsl select table.UID from table where table.EMAIL.eq(email) limit 1).fetchOne() != null
    }

    fun fetchOneByEmailOrSerialId(name: String): User? {
        return if (name.contains('@'))
            fetchOneByEmail(name)
        else
            fetchOneBySerialId(name)
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }

    private val countQuery = DSL.query("SELECT count(*) from " + USER.name)
    fun getTableApproximateCount(): Long = dsl.explain(countQuery).rows().toLong()
}