/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IInvoiceStatus;

import javax.annotation.processing.Generated;


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
public class InvoiceStatus implements IInvoiceStatus {

    private static final long serialVersionUID = 58459091;

    private Byte   id;
    private String description;

    public InvoiceStatus() {}

    public InvoiceStatus(IInvoiceStatus value) {
        this.id = value.getId();
        this.description = value.getDescription();
    }

    public InvoiceStatus(
        Byte   id,
        String description
    ) {
        this.id = id;
        this.description = description;
    }

    @Override
    public Byte getId() {
        return this.id;
    }

    @Override
    public InvoiceStatus setId(Byte id) {
        this.id = id;
        return this;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public InvoiceStatus setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InvoiceStatus (");

        sb.append(id);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
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
}