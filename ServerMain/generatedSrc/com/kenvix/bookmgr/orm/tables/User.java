/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Indexes;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.UserRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 用户基本信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1450416353;

    /**
     * The reference instance of <code>user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>user.uid</code>. 用户UID
     */
    public final TableField<UserRecord, Long> UID = createField(DSL.name("uid"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "用户UID");

    /**
     * The column <code>user.serial_id</code>. 工号/序列号
     */
    public final TableField<UserRecord, String> SERIAL_ID = createField(DSL.name("serial_id"), org.jooq.impl.SQLDataType.VARCHAR(15).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "工号/序列号");

    /**
     * The column <code>user.email</code>. 电子邮箱
     */
    public final TableField<UserRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(60).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "电子邮箱");

    /**
     * The column <code>user.real_name</code>. 真实姓名
     */
    public final TableField<UserRecord, String> REAL_NAME = createField(DSL.name("real_name"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "真实姓名");

    /**
     * The column <code>user.password</code>. Bcrypt密码哈希值
     */
    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("password"), org.jooq.impl.SQLDataType.CHAR(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.CHAR)), this, "Bcrypt密码哈希值");

    /**
     * The column <code>user.access_level</code>. 访问级别
     */
    public final TableField<UserRecord, Byte> ACCESS_LEVEL = createField(DSL.name("access_level"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "访问级别");

    /**
     * The column <code>user.created_at</code>. 创建时间
     */
    public final TableField<UserRecord, Timestamp> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>user.ip_creation</code>. 创建时IP
     */
    public final TableField<UserRecord, String> IP_CREATION = createField(DSL.name("ip_creation"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "创建时IP");

    /**
     * The column <code>user.ip_login</code>. 上次登录IP
     */
    public final TableField<UserRecord, String> IP_LOGIN = createField(DSL.name("ip_login"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "上次登录IP");

    /**
     * Create a <code>user</code> table reference
     */
    public User() {
        this(DSL.name("user"), null);
    }

    /**
     * Create an aliased <code>user</code> table reference
     */
    public User(String alias) {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>user</code> table reference
     */
    public User(Name alias) {
        this(alias, USER);
    }

    private User(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("用户基本信息"), TableOptions.table());
    }

    public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key) {
        super(child, key, USER);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_FK_ACCESS_LEVEL, Indexes.USER_UNIQUE_EMAIL, Indexes.USER_UNIQUE_SERIAL_ID);
    }

    @Override
    public Identity<UserRecord, Long> getIdentity() {
        return Keys.IDENTITY_USER;
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.KEY_USER_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(Keys.KEY_USER_PRIMARY, Keys.KEY_USER_UNIQUE_SERIAL_ID, Keys.KEY_USER_UNIQUE_EMAIL);
    }

    @Override
    public List<ForeignKey<UserRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserRecord, ?>>asList(Keys.FK_ACCESS_LEVEL);
    }

    public UserAccessLevel userAccessLevel() {
        return new UserAccessLevel(this, Keys.FK_ACCESS_LEVEL);
    }

    @Override
    public User as(String alias) {
        return new User(DSL.name(alias), this);
    }

    @Override
    public User as(Name alias) {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name) {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name) {
        return new User(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, String, Byte, Timestamp, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
