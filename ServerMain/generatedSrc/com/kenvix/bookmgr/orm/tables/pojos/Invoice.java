/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IInvoice;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.JSON;


/**
 * 账单，包括罚款
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Invoice implements IInvoice {

    private static final long serialVersionUID = -33544774;

    private Long      id;
    private String    name;
    private Short     type;
    private Long      ownerUid;
    private Integer   shouldPay;
    private Timestamp createdAt;
    private Byte      status;
    private Timestamp expireAt;
    private Timestamp paidAt;
    private String    comment;
    private JSON      extraData;

    public Invoice() {}

    public Invoice(IInvoice value) {
        this.id = value.getId();
        this.name = value.getName();
        this.type = value.getType();
        this.ownerUid = value.getOwnerUid();
        this.shouldPay = value.getShouldPay();
        this.createdAt = value.getCreatedAt();
        this.status = value.getStatus();
        this.expireAt = value.getExpireAt();
        this.paidAt = value.getPaidAt();
        this.comment = value.getComment();
        this.extraData = value.getExtraData();
    }

    public Invoice(
        Long      id,
        String    name,
        Short     type,
        Long      ownerUid,
        Integer   shouldPay,
        Timestamp createdAt,
        Byte      status,
        Timestamp expireAt,
        Timestamp paidAt,
        String    comment,
        JSON      extraData
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ownerUid = ownerUid;
        this.shouldPay = shouldPay;
        this.createdAt = createdAt;
        this.status = status;
        this.expireAt = expireAt;
        this.paidAt = paidAt;
        this.comment = comment;
        this.extraData = extraData;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Invoice setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Invoice setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Short getType() {
        return this.type;
    }

    @Override
    public Invoice setType(Short type) {
        this.type = type;
        return this;
    }

    @Override
    public Long getOwnerUid() {
        return this.ownerUid;
    }

    @Override
    public Invoice setOwnerUid(Long ownerUid) {
        this.ownerUid = ownerUid;
        return this;
    }

    @Override
    public Integer getShouldPay() {
        return this.shouldPay;
    }

    @Override
    public Invoice setShouldPay(Integer shouldPay) {
        this.shouldPay = shouldPay;
        return this;
    }

    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public Invoice setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public Byte getStatus() {
        return this.status;
    }

    @Override
    public Invoice setStatus(Byte status) {
        this.status = status;
        return this;
    }

    @Override
    public Timestamp getExpireAt() {
        return this.expireAt;
    }

    @Override
    public Invoice setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
        return this;
    }

    @Override
    public Timestamp getPaidAt() {
        return this.paidAt;
    }

    @Override
    public Invoice setPaidAt(Timestamp paidAt) {
        this.paidAt = paidAt;
        return this;
    }

    @Override
    public String getComment() {
        return this.comment;
    }

    @Override
    public Invoice setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public JSON getExtraData() {
        return this.extraData;
    }

    @Override
    public Invoice setExtraData(JSON extraData) {
        this.extraData = extraData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Invoice (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(type);
        sb.append(", ").append(ownerUid);
        sb.append(", ").append(shouldPay);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(status);
        sb.append(", ").append(expireAt);
        sb.append(", ").append(paidAt);
        sb.append(", ").append(comment);
        sb.append(", ").append(extraData);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IInvoice from) {
        setId(from.getId());
        setName(from.getName());
        setType(from.getType());
        setOwnerUid(from.getOwnerUid());
        setShouldPay(from.getShouldPay());
        setCreatedAt(from.getCreatedAt());
        setStatus(from.getStatus());
        setExpireAt(from.getExpireAt());
        setPaidAt(from.getPaidAt());
        setComment(from.getComment());
        setExtraData(from.getExtraData());
    }

    @Override
    public <E extends IInvoice> E into(E into) {
        into.from(this);
        return into;
    }
}
