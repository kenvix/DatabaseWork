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
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InvoiceForUser implements IInvoiceForUser {

    private static final long serialVersionUID = 1L;

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

    /**
     * Getter for <code>invoice_for_user.id</code>. 订单ID
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>invoice_for_user.id</code>. 订单ID
     */
    @Override
    public InvoiceForUser setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.name</code>. 订单名称
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>invoice_for_user.name</code>. 订单名称
     */
    @Override
    public InvoiceForUser setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.type</code>. 订单类型
     */
    @Override
    public Short getType() {
        return this.type;
    }

    /**
     * Setter for <code>invoice_for_user.type</code>. 订单类型
     */
    @Override
    public InvoiceForUser setType(Short type) {
        this.type = type;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.owner_uid</code>. 付款人UID
     */
    @Override
    public Long getOwnerUid() {
        return this.ownerUid;
    }

    /**
     * Setter for <code>invoice_for_user.owner_uid</code>. 付款人UID
     */
    @Override
    public InvoiceForUser setOwnerUid(Long ownerUid) {
        this.ownerUid = ownerUid;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.should_pay</code>. 应付金额
     */
    @Override
    public Integer getShouldPay() {
        return this.shouldPay;
    }

    /**
     * Setter for <code>invoice_for_user.should_pay</code>. 应付金额
     */
    @Override
    public InvoiceForUser setShouldPay(Integer shouldPay) {
        this.shouldPay = shouldPay;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.created_at</code>. 创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>invoice_for_user.created_at</code>. 创建时间
     */
    @Override
    public InvoiceForUser setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.status</code>. 订单状态
     */
    @Override
    public Byte getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>invoice_for_user.status</code>. 订单状态
     */
    @Override
    public InvoiceForUser setStatus(Byte status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.status_description</code>.
     */
    @Override
    public String getStatusDescription() {
        return this.statusDescription;
    }

    /**
     * Setter for <code>invoice_for_user.status_description</code>.
     */
    @Override
    public InvoiceForUser setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.expire_at</code>. 订单过期时间
     */
    @Override
    public Timestamp getExpireAt() {
        return this.expireAt;
    }

    /**
     * Setter for <code>invoice_for_user.expire_at</code>. 订单过期时间
     */
    @Override
    public InvoiceForUser setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.paid_at</code>. 订单支付时间,NULL为没付
     */
    @Override
    public Timestamp getPaidAt() {
        return this.paidAt;
    }

    /**
     * Setter for <code>invoice_for_user.paid_at</code>. 订单支付时间,NULL为没付
     */
    @Override
    public InvoiceForUser setPaidAt(Timestamp paidAt) {
        this.paidAt = paidAt;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.comment</code>. 订单备注
     */
    @Override
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter for <code>invoice_for_user.comment</code>. 订单备注
     */
    @Override
    public InvoiceForUser setComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.extra_data</code>. 保留备用。特定订单驱动可读的数据信息
     */
    @Override
    public JSON getExtraData() {
        return this.extraData;
    }

    /**
     * Setter for <code>invoice_for_user.extra_data</code>. 保留备用。特定订单驱动可读的数据信息
     */
    @Override
    public InvoiceForUser setExtraData(JSON extraData) {
        this.extraData = extraData;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.type_description</code>.
     */
    @Override
    public String getTypeDescription() {
        return this.typeDescription;
    }

    /**
     * Setter for <code>invoice_for_user.type_description</code>.
     */
    @Override
    public InvoiceForUser setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.type_driver</code>.
     */
    @Override
    public String getTypeDriver() {
        return this.typeDriver;
    }

    /**
     * Setter for <code>invoice_for_user.type_driver</code>.
     */
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
