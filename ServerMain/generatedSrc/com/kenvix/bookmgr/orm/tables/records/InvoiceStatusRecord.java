/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.InvoiceStatus;
import com.kenvix.bookmgr.orm.tables.interfaces.IInvoiceStatus;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 订单状态
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InvoiceStatusRecord extends UpdatableRecordImpl<InvoiceStatusRecord> implements Record2<Byte, String>, IInvoiceStatus {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>invoice_status.id</code>.
     */
    @Override
    public InvoiceStatusRecord setId(Byte value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>invoice_status.id</code>.
     */
    @Override
    public Byte getId() {
        return (Byte) get(0);
    }

    /**
     * Setter for <code>invoice_status.description</code>.
     */
    @Override
    public InvoiceStatusRecord setDescription(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>invoice_status.description</code>.
     */
    @Override
    public String getDescription() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Byte> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Byte, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Byte, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Byte> field1() {
        return InvoiceStatus.INVOICE_STATUS.ID;
    }

    @Override
    public Field<String> field2() {
        return InvoiceStatus.INVOICE_STATUS.DESCRIPTION;
    }

    @Override
    public Byte component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getDescription();
    }

    @Override
    public Byte value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getDescription();
    }

    @Override
    public InvoiceStatusRecord value1(Byte value) {
        setId(value);
        return this;
    }

    @Override
    public InvoiceStatusRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public InvoiceStatusRecord values(Byte value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IInvoiceStatus from) {
        setId(from.getId());
        setDescription(from.getDescription());
    }

    @Override
    public <E extends IInvoiceStatus> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InvoiceStatusRecord
     */
    public InvoiceStatusRecord() {
        super(InvoiceStatus.INVOICE_STATUS);
    }

    /**
     * Create a detached, initialised InvoiceStatusRecord
     */
    public InvoiceStatusRecord(Byte id, String description) {
        super(InvoiceStatus.INVOICE_STATUS);

        setId(id);
        setDescription(description);
    }
}
