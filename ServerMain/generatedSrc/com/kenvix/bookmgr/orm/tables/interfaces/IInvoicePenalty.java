/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * 罚款型订单扩展信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IInvoicePenalty extends Serializable {

    /**
     * Setter for <code>invoice_penalty.id</code>.
     */
    public IInvoicePenalty setId(Long value);

    /**
     * Getter for <code>invoice_penalty.id</code>.
     */
    public Long getId();

    /**
     * Setter for <code>invoice_penalty.invoice_id</code>. 订单ID
     */
    public IInvoicePenalty setInvoiceId(Long value);

    /**
     * Getter for <code>invoice_penalty.invoice_id</code>. 订单ID
     */
    public Long getInvoiceId();

    /**
     * Setter for <code>invoice_penalty.book_id</code>. 书籍ID
     */
    public IInvoicePenalty setBookId(Long value);

    /**
     * Getter for <code>invoice_penalty.book_id</code>. 书籍ID
     */
    public Long getBookId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IInvoicePenalty
     */
    public void from(IInvoicePenalty from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IInvoicePenalty
     */
    public <E extends IInvoicePenalty> E into(E into);
}