/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.LogCardAccessRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 刷卡日志（不可修改和删除）
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogCardAccess extends TableImpl<LogCardAccessRecord> {

    private static final long serialVersionUID = -1144873223;

    /**
     * The reference instance of <code>log_card_access</code>
     */
    public static final LogCardAccess LOG_CARD_ACCESS = new LogCardAccess();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LogCardAccessRecord> getRecordType() {
        return LogCardAccessRecord.class;
    }

    /**
     * The column <code>log_card_access.id</code>.
     */
    public final TableField<LogCardAccessRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>log_card_access.serial_id</code>. 卡序列号
     */
    public final TableField<LogCardAccessRecord, Long> SERIAL_ID = createField(DSL.name("serial_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "卡序列号");

    /**
     * The column <code>log_card_access.is_success</code>. 是否刷卡成功
     */
    public final TableField<LogCardAccessRecord, Boolean> IS_SUCCESS = createField(DSL.name("is_success"), org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'0'", org.jooq.impl.SQLDataType.BIT)), this, "是否刷卡成功");

    /**
     * The column <code>log_card_access.time</code>. 刷卡时间
     */
    public final TableField<LogCardAccessRecord, Timestamp> TIME = createField(DSL.name("time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "刷卡时间");

    /**
     * The column <code>log_card_access.machine_id</code>. 刷卡机器编号
     */
    public final TableField<LogCardAccessRecord, Integer> MACHINE_ID = createField(DSL.name("machine_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "刷卡机器编号");

    /**
     * Create a <code>log_card_access</code> table reference
     */
    public LogCardAccess() {
        this(DSL.name("log_card_access"), null);
    }

    /**
     * Create an aliased <code>log_card_access</code> table reference
     */
    public LogCardAccess(String alias) {
        this(DSL.name(alias), LOG_CARD_ACCESS);
    }

    /**
     * Create an aliased <code>log_card_access</code> table reference
     */
    public LogCardAccess(Name alias) {
        this(alias, LOG_CARD_ACCESS);
    }

    private LogCardAccess(Name alias, Table<LogCardAccessRecord> aliased) {
        this(alias, aliased, null);
    }

    private LogCardAccess(Name alias, Table<LogCardAccessRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("刷卡日志（不可修改和删除）"), TableOptions.table());
    }

    public <O extends Record> LogCardAccess(Table<O> child, ForeignKey<O, LogCardAccessRecord> key) {
        super(child, key, LOG_CARD_ACCESS);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<LogCardAccessRecord, Long> getIdentity() {
        return Keys.IDENTITY_LOG_CARD_ACCESS;
    }

    @Override
    public UniqueKey<LogCardAccessRecord> getPrimaryKey() {
        return Keys.KEY_LOG_CARD_ACCESS_PRIMARY;
    }

    @Override
    public List<UniqueKey<LogCardAccessRecord>> getKeys() {
        return Arrays.<UniqueKey<LogCardAccessRecord>>asList(Keys.KEY_LOG_CARD_ACCESS_PRIMARY);
    }

    @Override
    public LogCardAccess as(String alias) {
        return new LogCardAccess(DSL.name(alias), this);
    }

    @Override
    public LogCardAccess as(Name alias) {
        return new LogCardAccess(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LogCardAccess rename(String name) {
        return new LogCardAccess(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LogCardAccess rename(Name name) {
        return new LogCardAccess(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Boolean, Timestamp, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
