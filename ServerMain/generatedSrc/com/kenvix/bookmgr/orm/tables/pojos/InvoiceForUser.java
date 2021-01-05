/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IInvoiceForUser;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.JSON;


/**
 * VIEW
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InvoiceForUser implements IInvoiceForUser {

    private static final long serialVersionUID = -909534971;

    private Long      id;
    private String    name;
    private Short     type;
    private Long      ownerUid;
    private Integer   shouldPay;
    private Timestamp createdAt;
    private Byte      status;
    private String    statusDescription;
    private Timestamp expireAt;
    private Timestamp paidAt;
    private String    comment;
    private JSON      extraData;
    private String    typeDescription;
    private String    typeDriver;

    public InvoiceForUser() {}

    public InvoiceForUser(IInvoiceForUser value) {
        this.id = value.getId();
        this.name = value.getName();
        this.type = value.getType();
        this.ownerUid = value.getOwnerUid();
        this.shouldPay = value.getShouldPay();
        this.createdAt = value.getCreatedAt();
        this.status = value.getStatus();
        this.statusDescription = value.getStatusDescription();
        this.expireAt = value.getExpireAt();
        this.paidAt = value.getPaidAt();
        this.comment = value.getComment();
        this.extraData = value.getExtraData();
        this.typeDescription = value.getTypeDescription();
        this.typeDriver = value.getTypeDriver();
    }

    public InvoiceForUser(
        Long      id,
        String    name,
        Short     type,
        Long      ownerUid,
        Integer   shouldPay,
        Timestamp createdAt,
        Byte      status,
        String    statusDescription,
        Timestamp expireAt,
        Timestamp paidAt,
        String    comment,
        JSON      extraData,
        String    typeDescription,
        String    typeDriver
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ownerUid = ownerUid;
        this.shouldPay = shouldPay;
        this.createdAt = createdAt;
        this.status = status;
        this.statusDescription = statusDescription;
        this.expireAt = expireAt;
        this.paidAt = paidAt;
        this.comment = comment;
        this.extraData = extraData;
        this.typeDescription = typeDescription;
        this.typeDriver = typeDriver;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public InvoiceForUser setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public InvoiceForUser setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Short getType() {
        return this.type;
    }

    @Override
    public InvoiceForUser setType(Short type) {
        this.type = type;
        return this;
    }

    @Override
    public Long getOwnerUid() {
        return this.ownerUid;
    }

    @Override
    public InvoiceForUser setOwnerUid(Long ownerUid) {
        this.ownerUid = ownerUid;
        return this;
    }

    @Override
    public Integer getShouldPay() {
        return this.shouldPay;
    }

    @Override
    public InvoiceForUser setShouldPay(Integer shouldPay) {
        this.shouldPay = shouldPay;
        return this;
    }

    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public InvoiceForUser setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public Byte getStatus() {
        return this.status;
    }

    @Override
    public InvoiceForUser setStatus(Byte status) {
        this.status = status;
        return this;
    }

    @Override
    public String getStatusDescription() {
        return this.statusDescription;
    }

    @Override
    public InvoiceForUser setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
        return this;
    }

    @Override
    public Timestamp getExpireAt() {
        return this.expireAt;
    }

    @Override
    public InvoiceForUser setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
        return this;
    }

    @Override
    public Timestamp getPaidAt() {
        return this.paidAt;
    }

    @Override
    public InvoiceForUser setPaidAt(Timestamp paidAt) {
        this.paidAt = paidAt;
        return this;
    }

    @Override
    public String getComment() {
        return this.comment;
    }

    @Override
    public InvoiceForUser setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public JSON getExtraData() {
        return this.extraData;
    }

    @Override
    public InvoiceForUser setExtraData(JSON extraData) {
        this.extraData = extraData;
        return this;
    }

    @Override
    public String getTypeDescription() {
        return this.typeDescription;
    }

    @Override
    public InvoiceForUser setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
        return this;
    }

    @Override
    public String getTypeDriver() {
        return this.typeDriver;
    }

    @Override
    public InvoiceForUser setTypeDriver(String typeDriver) {
        this.typeDriver = typeDriver;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InvoiceForUser (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(type);
        sb.append(", ").append(ownerUid);
        sb.append(", ").append(shouldPay);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(status);
        sb.append(", ").append(statusDescription);
        sb.append(", ").append(expireAt);
        sb.append(", ").append(paidAt);
        sb.append(", ").append(comment);
        sb.append(", ").append(extraData);
        sb.append(", ").append(typeDescription);
        sb.append(", ").append(typeDriver);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IInvoiceForUser from) {
        setId(from.getId());
        setName(from.getName());
        setType(from.getType());
        setOwnerUid(from.getOwnerUid());
        setShouldPay(from.getShouldPay());
        setCreatedAt(from.getCreatedAt());
        setStatus(from.getStatus());
        setStatusDescription(from.getStatusDescription());
        setExpireAt(from.getExpireAt());
        setPaidAt(from.getPaidAt());
        setComment(from.getComment());
        setExtraData(from.getExtraData());
        setTypeDescription(from.getTypeDescription());
        setTypeDriver(from.getTypeDriver());
    }

    @Override
    public <E extends IInvoiceForUser> E into(E into) {
        into.from(this);
        return into;
    }
}