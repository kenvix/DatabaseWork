//--------------------------------------------------
// Class GuavaCache
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

import com.google.common.cache.CacheBuilder
import com.kenvix.web.utils.*
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.test.Test

class GuavaCache {
    data class TestCacheValue(val first: String, var second: Int)

    @Test
    fun testWriteOutside() {
        val cache = CacheBuilder.newBuilder().apply {
            expireAfterWrite(1, TimeUnit.SECONDS)
            removalListener<Int, TestCacheValue> { r ->
                println("Cache being to delete due to ${r.cause}: ${r.value}")
            }
        }.build<Int, TestCacheValue>()

        val beingWrite = TestCacheValue("wdnmd", 114514)
        cache.put(1919810, beingWrite)

        assert(cache.getIfPresent(1919810) === beingWrite)
        beingWrite.second = -17
        assert(cache.getIfPresent(1919810)!!.second == -17)
        println(cache.getIfPresent(1919810)!!.second)
    }

    @Test
    fun time() {
        val time: DateTime = DateTime.now()
        println(time)
        println(time.toEpochSecond())
        println(time.toEpochMilli())
        println()

        val date = Date()
        println(date.format())
        println()

        val instant: Instant = Instant.now()
        println(instant)
        println(instant.toEpochMilli())
        println(instant.format())
        println(instant.formatMilli())
        println(instant.formatNanos())
        println(instant.formatNormalized())
        println()
    }
}