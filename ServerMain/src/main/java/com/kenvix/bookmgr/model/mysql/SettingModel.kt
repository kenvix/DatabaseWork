package com.kenvix.bookmgr.model.mysql

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.orm.tables.daos.SettingDao
import com.kenvix.bookmgr.orm.tables.pojos.Setting
import org.jooq.Configuration
import java.util.concurrent.TimeUnit

@OptIn(SingletonModel::class)
object SettingModel : SettingDao(), BaseModel {
    val settingCache: Cache<String, Any> = CacheBuilder
        .newBuilder()
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .build()

    inline operator fun <reified T> get(key: String, noinline converter: ((String) -> T)? = null): T {
        val cache = settingCache.getIfPresent(key)
        if (cache != null) {
            return cache as T
        } else {
            val value = when (T::class) {
                String::class -> getKeyFromDatabase(key) as T
                Int::class -> getKeyFromDatabase(key).toInt() as T
                Long::class -> getKeyFromDatabase(key).toLong() as T
                Boolean::class -> getKeyFromDatabase(key).toBoolean() as T
                Double::class -> getKeyFromDatabase(key).toDouble() as T
                Short::class -> getKeyFromDatabase(key).toShort() as T
                Float::class -> getKeyFromDatabase(key).toFloat() as T
                else -> {
                    if (converter != null)
                        converter(getKeyFromDatabase(key))
                    else
                        throw IllegalArgumentException("Type not supported: ${T::class.qualifiedName}")
                }
            }

            settingCache.put(key + "@" + T::class.java.name, value)
            return value
        }
    }
    
    fun getKeyFromDatabase(key: String): String {
        return fetchOneByKey(key).value
    }

    inline operator fun <reified T> set(key: String, value: T) {
        set(key, value, null)
    }

    inline fun <reified T> set(key: String, value: T, noinline serializer: ((T) -> String)? = null) {
        settingCache.put(key + "@" + T::class.java.name, value)
        update(Setting(key, value.run { if (serializer != null) serializer(this) else toString() }))
    }

    override fun configuration(): Configuration {
        return AppConstants.jooqConfiguration
    }
}