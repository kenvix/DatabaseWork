/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.InvoiceStatusRecord;

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
import org.jooq.impl.TableImpl;


/**
 * 订单状态
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InvoiceStatus extends TableImpl<InvoiceStatusRecord> {

    private static final long serialVersionUID = -66181285;

    /**
     * The reference instance of <code>invoice_status</code>
     */
    public static final InvoiceStatus INVOICE_STATUS = new InvoiceStatus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InvoiceStatusRecord> getRecordType() {
        return InvoiceStatusRecord.class;
    }

    /**
     * The column <code>invoice_status.id</code>.
     */
    public final TableField<InvoiceStatusRecord, Byte> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>invoice_status.description</code>.
     */
    public final TableField<InvoiceStatusRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>invoice_status</code> table reference
     */
    public InvoiceStatus() {
        this(DSL.name("invoice_status"), null);
    }

    /**
     * Create an aliased <code>invoice_status</code> table reference
     */
    public InvoiceStatus(String alias) {
        this(DSL.name(alias), INVOICE_STATUS);
    }

    /**
     * Create an aliased <code>invoice_status</code> table reference
     */
    public InvoiceStatus(Name alias) {
        this(alias, INVOICE_STATUS);
    }

    private InvoiceStatus(Name alias, Table<InvoiceStatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private InvoiceStatus(Name alias, Table<InvoiceStatusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("订单状态"), TableOptions.table());
    }

    public <O extends Record> InvoiceStatus(Table<O> child, ForeignKey<O, InvoiceStatusRecord> key) {
        super(child, key, INVOICE_STATUS);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<InvoiceStatusRecord> getPrimaryKey() {
        return Keys.KEY_INVOICE_STATUS_PRIMARY;
    }

    @Override
    public List<UniqueKey<InvoiceStatusRecord>> getKeys() {
        return Arrays.<UniqueKey<InvoiceStatusRecord>>asList(Keys.KEY_INVOICE_STATUS_PRIMARY);
    }

    @Override
    public InvoiceStatus as(String alias) {
        return new InvoiceStatus(DSL.name(alias), this);
    }

    @Override
    public InvoiceStatus as(Name alias) {
        return new InvoiceStatus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InvoiceStatus rename(String name) {
        return new InvoiceStatus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InvoiceStatus rename(Name name) {
        return new InvoiceStatus(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Byte, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}