@file:JvmName("SqlUtils")
@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.kenvix.web.utils

import com.kenvix.bookmgr.AppConstants
import io.ktor.features.*
import org.jooq.*
import org.jooq.impl.DSL

infix fun <T1> DSLContext.select(field1: SelectField<T1>): SelectSelectStep<Record1<T1>> = this.select(field1)

infix fun <R: Record> SelectFromStep<R>.from(table: TableLike<*>) = this.from(table)

infix fun <R: Record> SelectWhereStep<R>.where(condition: Condition) = this.where(condition)

infix fun <R: Record> SelectLimitStep<R>.limit(numberOfRows: Int) = this.limit(numberOfRows)

fun TableField<*, String>.validateLength(value: String?): String {
    if (value.isNullOrEmpty())
        throw BadRequestException("$name cannot be empty.")

    val fieldLength = dataType.length()
    if (value.length > fieldLength)
        throw BadRequestException("$name is too long, it cannot be longer than $fieldLength characters")

    return value
}

fun newDSL() = DSL.using(AppConstants.jooqConfiguration)