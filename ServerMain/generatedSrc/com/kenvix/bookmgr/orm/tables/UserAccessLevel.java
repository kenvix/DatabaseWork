/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.UserAccessLevelRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 用户访问级别定义
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAccessLevel extends TableImpl<UserAccessLevelRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>user_access_level</code>
     */
    public static final UserAccessLevel USER_ACCESS_LEVEL = new UserAccessLevel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserAccessLevelRecord> getRecordType() {
        return UserAccessLevelRecord.class;
    }

    /**
     * The column <code>user_access_level.id</code>.
     */
    public final TableField<UserAccessLevelRecord, Byte> ID = createField(DSL.name("id"), SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>user_access_level.description</code>.
     */
    public final TableField<UserAccessLevelRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    private UserAccessLevel(Name alias, Table<UserAccessLevelRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserAccessLevel(Name alias, Table<UserAccessLevelRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("用户访问级别定义"), TableOptions.table());
    }

    /**
     * Create an aliased <code>user_access_level</code> table reference
     */
    public UserAccessLevel(String alias) {
        this(DSL.name(alias), USER_ACCESS_LEVEL);
    }

    /**
     * Create an aliased <code>user_access_level</code> table reference
     */
    public UserAccessLevel(Name alias) {
        this(alias, USER_ACCESS_LEVEL);
    }

    /**
     * Create a <code>user_access_level</code> table reference
     */
    public UserAccessLevel() {
        this(DSL.name("user_access_level"), null);
    }

    public <O extends Record> UserAccessLevel(Table<O> child, ForeignKey<O, UserAccessLevelRecord> key) {
        super(child, key, USER_ACCESS_LEVEL);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<UserAccessLevelRecord> getPrimaryKey() {
        return Keys.KEY_USER_ACCESS_LEVEL_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserAccessLevelRecord>> getKeys() {
        return Arrays.<UniqueKey<UserAccessLevelRecord>>asList(Keys.KEY_USER_ACCESS_LEVEL_PRIMARY);
    }

    @Override
    public UserAccessLevel as(String alias) {
        return new UserAccessLevel(DSL.name(alias), this);
    }

    @Override
    public UserAccessLevel as(Name alias) {
        return new UserAccessLevel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAccessLevel rename(String name) {
        return new UserAccessLevel(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAccessLevel rename(Name name) {
        return new UserAccessLevel(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Byte, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
