/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.SettingRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 设置表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Setting extends TableImpl<SettingRecord> {

    private static final long serialVersionUID = 988016699;

    /**
     * The reference instance of <code>setting</code>
     */
    public static final Setting SETTING = new Setting();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SettingRecord> getRecordType() {
        return SettingRecord.class;
    }

    /**
     * The column <code>setting.key</code>.
     */
    public final TableField<SettingRecord, String> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>setting.value</code>.
     */
    public final TableField<SettingRecord, String> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>setting.description</code>.
     */
    public final TableField<SettingRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>setting</code> table reference
     */
    public Setting() {
        this(DSL.name("setting"), null);
    }

    /**
     * Create an aliased <code>setting</code> table reference
     */
    public Setting(String alias) {
        this(DSL.name(alias), SETTING);
    }

    /**
     * Create an aliased <code>setting</code> table reference
     */
    public Setting(Name alias) {
        this(alias, SETTING);
    }

    private Setting(Name alias, Table<SettingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Setting(Name alias, Table<SettingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("设置表"), TableOptions.table());
    }

    public <O extends Record> Setting(Table<O> child, ForeignKey<O, SettingRecord> key) {
        super(child, key, SETTING);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<SettingRecord> getPrimaryKey() {
        return Keys.KEY_SETTING_PRIMARY;
    }

    @Override
    public List<UniqueKey<SettingRecord>> getKeys() {
        return Arrays.<UniqueKey<SettingRecord>>asList(Keys.KEY_SETTING_PRIMARY);
    }

    @Override
    public Setting as(String alias) {
        return new Setting(DSL.name(alias), this);
    }

    @Override
    public Setting as(Name alias) {
        return new Setting(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Setting rename(String name) {
        return new Setting(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Setting rename(Name name) {
        return new Setting(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}