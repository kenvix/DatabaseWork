package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.UserId
import com.kenvix.bookmgr.orm.tables.daos.UserDao
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.from
import com.kenvix.web.utils.limit
import com.kenvix.web.utils.select
import com.kenvix.web.utils.where
import org.jooq.Configuration

@OptIn(SingletonModel::class)
object UserModel : UserDao(), BaseModel {
    private val table
        get() = com.kenvix.bookmgr.orm.tables.User.USER

    fun isUserNameExist(name: String): Boolean {
        return (dsl select table.UID from table where table.NAME.eq(name) limit 1).fetchOne() != null
    }

    fun isEmailExist(email: String): Boolean {
        return (dsl select table.UID from table where table.EMAIL.eq(email) limit 1).fetchOne() != null
    }

    fun fetchOneByEmailOrUserName(name: String): User? {
        return if (isEmailExist(name))
            fetchOneByEmail(name)
        else
            fetchOneByName(name)
    }

    /**
     * 获取已索引的基本信息。包括UID、邮箱、用户名、手机号、MongoID、密码、角色（非常快，优先使用）
     */
    fun fetchOneBasicInformationByUid(id: UserId): User? {
        return dsl
                .select(table.UID, table.EMAIL, table.NAME, table.PHONE, table.MONGO_KEY, table.PASSWORD, table.ROLE)
                .from(table)
                .where(table.UID.eq(id))
                .fetchOne()
                ?.into(User::class.java)
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}