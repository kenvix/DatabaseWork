//--------------------------------------------------
// Interface BaseModel
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.model.mysql

import com.kenvix.bookmgr.AppConstants
import org.jooq.Configuration
import org.jooq.exception.DataAccessException
import org.slf4j.LoggerFactory

@SingletonModel
interface BaseModel {
    /**
     * Create a new jooq DSL context.
     * Note that you do NOT need to keep a reference to a DSLContext.
     * This method is delegated
     * @see AppConstants.dslContext
     */
    val dsl
        get() = AppConstants.dslContext

    fun <R> Configuration.use(then: ((Configuration) -> R)): R {
        val initialState = AppConstants.jooqConfigurationOrNull
        AppConstants.jooqConfigurationOrNull = this
        return try {
            then(this)
        } catch (exception: Throwable) {
            logger.debug("Config use block failed: $exception")
            throw exception
        } finally {
            logger.debug("Recover thread local jooq config to initial")
            AppConstants.jooqConfigurationOrNull = initialState
        }
    }

    /**
     * Run transaction for current thread.
     * Please note that codes in lambda should NOT call any ThreadPool or Coroutines.
     *
     * @throws Throwable Any exception wrapped by DataAccessException or DataAccessException itself if it has no wrapped exception
     */
    fun <R> transactionThreadLocal(then: ((Configuration) -> R)): R {
        return try {
            dsl.transactionResult { config ->
                config.use { then(it) }
            }
        } catch (e: DataAccessException) {
            if (e.cause != null)
                throw e.cause!!
            else
                throw e
        }
    }

    companion object {
        val logger = LoggerFactory.getLogger("Models")
    }

    fun configuration(): Configuration
}


@RequiresOptIn(
    "The SingletonModel is designed for jooq DAOs and requires you to override configuration()" +
            " method and let it get Configuration from AppConstants.jooqConfiguration. " +
            "Moreover, never use coroutines and multi-thread related method in " +
            "transactionThreadLocal scope. Please confirm that by adding annotation @OptIn(SingletonModel::class)",
    level = RequiresOptIn.Level.ERROR
)
annotation class SingletonModel

/**
 * Describe a model method that would cache result
 */
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
annotation class CachedModelMethod