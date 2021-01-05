/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Indexes;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.PublisherRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
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
 * 出版社
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Publisher extends TableImpl<PublisherRecord> {

    private static final long serialVersionUID = -1286568815;

    /**
     * The reference instance of <code>publisher</code>
     */
    public static final Publisher PUBLISHER = new Publisher();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PublisherRecord> getRecordType() {
        return PublisherRecord.class;
    }

    /**
     * The column <code>publisher.id</code>. 出版社ID
     */
    public final TableField<PublisherRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "出版社ID");

    /**
     * The column <code>publisher.name</code>. 出版社名称
     */
    public final TableField<PublisherRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(80).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "出版社名称");

    /**
     * The column <code>publisher.description</code>. 出版社简介
     */
    public final TableField<PublisherRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB, this, "出版社简介");

    /**
     * Create a <code>publisher</code> table reference
     */
    public Publisher() {
        this(DSL.name("publisher"), null);
    }

    /**
     * Create an aliased <code>publisher</code> table reference
     */
    public Publisher(String alias) {
        this(DSL.name(alias), PUBLISHER);
    }

    /**
     * Create an aliased <code>publisher</code> table reference
     */
    public Publisher(Name alias) {
        this(alias, PUBLISHER);
    }

    private Publisher(Name alias, Table<PublisherRecord> aliased) {
        this(alias, aliased, null);
    }

    private Publisher(Name alias, Table<PublisherRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("出版社"), TableOptions.table());
    }

    public <O extends Record> Publisher(Table<O> child, ForeignKey<O, PublisherRecord> key) {
        super(child, key, PUBLISHER);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PUBLISHER_UNIQUE_NAME);
    }

    @Override
    public Identity<PublisherRecord, Long> getIdentity() {
        return Keys.IDENTITY_PUBLISHER;
    }

    @Override
    public UniqueKey<PublisherRecord> getPrimaryKey() {
        return Keys.KEY_PUBLISHER_PRIMARY;
    }

    @Override
    public List<UniqueKey<PublisherRecord>> getKeys() {
        return Arrays.<UniqueKey<PublisherRecord>>asList(Keys.KEY_PUBLISHER_PRIMARY, Keys.KEY_PUBLISHER_UNIQUE_NAME);
    }

    @Override
    public Publisher as(String alias) {
        return new Publisher(DSL.name(alias), this);
    }

    @Override
    public Publisher as(Name alias) {
        return new Publisher(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Publisher rename(String name) {
        return new Publisher(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Publisher rename(Name name) {
        return new Publisher(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}