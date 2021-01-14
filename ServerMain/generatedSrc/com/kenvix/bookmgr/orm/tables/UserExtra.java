/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.UserExtraRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 用户扩展信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserExtra extends TableImpl<UserExtraRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>user_extra</code>
     */
    public static final UserExtra USER_EXTRA = new UserExtra();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserExtraRecord> getRecordType() {
        return UserExtraRecord.class;
    }

    /**
     * The column <code>user_extra.uid</code>.
     */
    public final TableField<UserExtraRecord, Long> UID = createField(DSL.name("uid"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>user_extra.phone</code>. 电话号
     */
    public final TableField<UserExtraRecord, Long> PHONE = createField(DSL.name("phone"), SQLDataType.BIGINT, this, "电话号");

    /**
     * The column <code>user_extra.money</code>. 可用钱数（单位为分）
     */
    public final TableField<UserExtraRecord, Integer> MONEY = createField(DSL.name("money"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "可用钱数（单位为分）");

    /**
     * The column <code>user_extra.card_serial_id</code>. 卡片序列号
     */
    public final TableField<UserExtraRecord, Long> CARD_SERIAL_ID = createField(DSL.name("card_serial_id"), SQLDataType.BIGINT, this, "卡片序列号");

    /**
     * The column <code>user_extra.start_year</code>. 入学(职)年份
     */
    public final TableField<UserExtraRecord, Short> START_YEAR = createField(DSL.name("start_year"), SQLDataType.SMALLINT, this, "入学(职)年份");

    /**
     * The column <code>user_extra.department</code>. 所在部门
     */
    public final TableField<UserExtraRecord, String> DEPARTMENT = createField(DSL.name("department"), SQLDataType.VARCHAR(20), this, "所在部门");

    /**
     * The column <code>user_extra.comment</code>. 备注
     */
    public final TableField<UserExtraRecord, String> COMMENT = createField(DSL.name("comment"), SQLDataType.CLOB, this, "备注");

    private UserExtra(Name alias, Table<UserExtraRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserExtra(Name alias, Table<UserExtraRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("用户扩展信息"), TableOptions.table());
    }

    /**
     * Create an aliased <code>user_extra</code> table reference
     */
    public UserExtra(String alias) {
        this(DSL.name(alias), USER_EXTRA);
    }

    /**
     * Create an aliased <code>user_extra</code> table reference
     */
    public UserExtra(Name alias) {
        this(alias, USER_EXTRA);
    }

    /**
     * Create a <code>user_extra</code> table reference
     */
    public UserExtra() {
        this(DSL.name("user_extra"), null);
    }

    public <O extends Record> UserExtra(Table<O> child, ForeignKey<O, UserExtraRecord> key) {
        super(child, key, USER_EXTRA);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<UserExtraRecord> getPrimaryKey() {
        return Keys.KEY_USER_EXTRA_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserExtraRecord>> getKeys() {
        return Arrays.<UniqueKey<UserExtraRecord>>asList(Keys.KEY_USER_EXTRA_PRIMARY);
    }

    @Override
    public List<ForeignKey<UserExtraRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserExtraRecord, ?>>asList(Keys.FK_UID);
    }

    public User user() {
        return new User(this, Keys.FK_UID);
    }

    @Override
    public UserExtra as(String alias) {
        return new UserExtra(DSL.name(alias), this);
    }

    @Override
    public UserExtra as(Name alias) {
        return new UserExtra(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserExtra rename(String name) {
        return new UserExtra(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserExtra rename(Name name) {
        return new UserExtra(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, Integer, Long, Short, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
