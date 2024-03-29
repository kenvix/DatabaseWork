/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.InvoicePenalty;
import com.kenvix.bookmgr.orm.tables.interfaces.IInvoicePenalty;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 罚款型订单扩展信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InvoicePenaltyRecord extends UpdatableRecordImpl<InvoicePenaltyRecord> implements Record3<Long, Long, Long>, IInvoicePenalty {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>invoice_penalty.id</code>.
     */
    @Override
    public InvoicePenaltyRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>invoice_penalty.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>invoice_penalty.invoice_id</code>. 订单ID
     */
    @Override
    public InvoicePenaltyRecord setInvoiceId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>invoice_penalty.invoice_id</code>. 订单ID
     */
    @Override
    public Long getInvoiceId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>invoice_penalty.book_id</code>. 书籍ID
     */
    @Override
    public InvoicePenaltyRecord setBookId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>invoice_penalty.book_id</code>. 书籍ID
     */
    @Override
    public Long getBookId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return InvoicePenalty.INVOICE_PENALTY.ID;
    }

    @Override
    public Field<Long> field2() {
        return InvoicePenalty.INVOICE_PENALTY.INVOICE_ID;
    }

    @Override
    public Field<Long> field3() {
        return InvoicePenalty.INVOICE_PENALTY.BOOK_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getInvoiceId();
    }

    @Override
    public Long component3() {
        return getBookId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getInvoiceId();
    }

    @Override
    public Long value3() {
        return getBookId();
    }

    @Override
    public InvoicePenaltyRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public InvoicePenaltyRecord value2(Long value) {
        setInvoiceId(value);
        return this;
    }

    @Override
    public InvoicePenaltyRecord value3(Long value) {
        setBookId(value);
        return this;
    }

    @Override
    public InvoicePenaltyRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IInvoicePenalty from) {
        setId(from.getId());
        setInvoiceId(from.getInvoiceId());
        setBookId(from.getBookId());
    }

    @Override
    public <E extends IInvoicePenalty> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InvoicePenaltyRecord
     */
    public InvoicePenaltyRecord() {
        super(InvoicePenalty.INVOICE_PENALTY);
    }

    /**
     * Create a detached, initialised InvoicePenaltyRecord
     */
    public InvoicePenaltyRecord(Long id, Long invoiceId, Long bookId) {
        super(InvoicePenalty.INVOICE_PENALTY);

        setId(id);
        setInvoiceId(invoiceId);
        setBookId(bookId);
    }
}
