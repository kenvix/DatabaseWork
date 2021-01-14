/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.InvoiceTypeRecord;

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
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 订单类型
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InvoiceType extends TableImpl<InvoiceTypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>invoice_type</code>
     */
    public static final InvoiceType INVOICE_TYPE = new InvoiceType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InvoiceTypeRecord> getRecordType() {
        return InvoiceTypeRecord.class;
    }

    /**
     * The column <code>invoice_type.id</code>.
     */
    public final TableField<InvoiceTypeRecord, Short> ID = createField(DSL.name("id"), SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>invoice_type.description</code>.
     */
    public final TableField<InvoiceTypeRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>invoice_type.driver</code>.
     */
    public final TableField<InvoiceTypeRecord, String> DRIVER = createField(DSL.name("driver"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    private InvoiceType(Name alias, Table<InvoiceTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private InvoiceType(Name alias, Table<InvoiceTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("订单类型"), TableOptions.table());
    }

    /**
     * Create an aliased <code>invoice_type</code> table reference
     */
    public InvoiceType(String alias) {
        this(DSL.name(alias), INVOICE_TYPE);
    }

    /**
     * Create an aliased <code>invoice_type</code> table reference
     */
    public InvoiceType(Name alias) {
        this(alias, INVOICE_TYPE);
    }

    /**
     * Create a <code>invoice_type</code> table reference
     */
    public InvoiceType() {
        this(DSL.name("invoice_type"), null);
    }

    public <O extends Record> InvoiceType(Table<O> child, ForeignKey<O, InvoiceTypeRecord> key) {
        super(child, key, INVOICE_TYPE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<InvoiceTypeRecord> getPrimaryKey() {
        return Keys.KEY_INVOICE_TYPE_PRIMARY;
    }

    @Override
    public List<UniqueKey<InvoiceTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<InvoiceTypeRecord>>asList(Keys.KEY_INVOICE_TYPE_PRIMARY);
    }

    @Override
    public InvoiceType as(String alias) {
        return new InvoiceType(DSL.name(alias), this);
    }

    @Override
    public InvoiceType as(Name alias) {
        return new InvoiceType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public InvoiceType rename(String name) {
        return new InvoiceType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InvoiceType rename(Name name) {
        return new InvoiceType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Short, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
