/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.InvoiceForUser;
import com.kenvix.bookmgr.orm.tables.interfaces.IInvoiceForUser;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.JSON;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.TableRecordImpl;


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
public class InvoiceForUserRecord extends TableRecordImpl<InvoiceForUserRecord> implements Record14<Long, String, Short, Long, Integer, Timestamp, Byte, String, Timestamp, Timestamp, String, JSON, String, String>, IInvoiceForUser {

    private static final long serialVersionUID = 399096686;

    /**
     * Setter for <code>invoice_for_user.id</code>. 订单ID
     */
    @Override
    public InvoiceForUserRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.id</code>. 订单ID
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>invoice_for_user.name</code>. 订单名称
     */
    @Override
    public InvoiceForUserRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.name</code>. 订单名称
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>invoice_for_user.type</code>. 订单类型
     */
    @Override
    public InvoiceForUserRecord setType(Short value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.type</code>. 订单类型
     */
    @Override
    public Short getType() {
        return (Short) get(2);
    }

    /**
     * Setter for <code>invoice_for_user.owner_uid</code>. 付款人UID
     */
    @Override
    public InvoiceForUserRecord setOwnerUid(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.owner_uid</code>. 付款人UID
     */
    @Override
    public Long getOwnerUid() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>invoice_for_user.should_pay</code>. 应付金额
     */
    @Override
    public InvoiceForUserRecord setShouldPay(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.should_pay</code>. 应付金额
     */
    @Override
    public Integer getShouldPay() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>invoice_for_user.created_at</code>. 创建时间
     */
    @Override
    public InvoiceForUserRecord setCreatedAt(Timestamp value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.created_at</code>. 创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>invoice_for_user.status</code>. 订单状态
     */
    @Override
    public InvoiceForUserRecord setStatus(Byte value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.status</code>. 订单状态
     */
    @Override
    public Byte getStatus() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>invoice_for_user.status_description</code>.
     */
    @Override
    public InvoiceForUserRecord setStatusDescription(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.status_description</code>.
     */
    @Override
    public String getStatusDescription() {
        return (String) get(7);
    }

    /**
     * Setter for <code>invoice_for_user.expire_at</code>. 订单过期时间
     */
    @Override
    public InvoiceForUserRecord setExpireAt(Timestamp value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.expire_at</code>. 订单过期时间
     */
    @Override
    public Timestamp getExpireAt() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>invoice_for_user.paid_at</code>. 订单支付时间,NULL为没付
     */
    @Override
    public InvoiceForUserRecord setPaidAt(Timestamp value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.paid_at</code>. 订单支付时间,NULL为没付
     */
    @Override
    public Timestamp getPaidAt() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>invoice_for_user.comment</code>. 订单备注
     */
    @Override
    public InvoiceForUserRecord setComment(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.comment</code>. 订单备注
     */
    @Override
    public String getComment() {
        return (String) get(10);
    }

    /**
     * Setter for <code>invoice_for_user.extra_data</code>. 保留备用。特定订单驱动可读的数据信息
     */
    @Override
    public InvoiceForUserRecord setExtraData(JSON value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.extra_data</code>. 保留备用。特定订单驱动可读的数据信息
     */
    @Override
    public JSON getExtraData() {
        return (JSON) get(11);
    }

    /**
     * Setter for <code>invoice_for_user.type_description</code>.
     */
    @Override
    public InvoiceForUserRecord setTypeDescription(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.type_description</code>.
     */
    @Override
    public String getTypeDescription() {
        return (String) get(12);
    }

    /**
     * Setter for <code>invoice_for_user.type_driver</code>.
     */
    @Override
    public InvoiceForUserRecord setTypeDriver(String value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>invoice_for_user.type_driver</code>.
     */
    @Override
    public String getTypeDriver() {
        return (String) get(13);
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row14<Long, String, Short, Long, Integer, Timestamp, Byte, String, Timestamp, Timestamp, String, JSON, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<Long, String, Short, Long, Integer, Timestamp, Byte, String, Timestamp, Timestamp, String, JSON, String, String> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return InvoiceForUser.INVOICE_FOR_USER.ID;
    }

    @Override
    public Field<String> field2() {
        return InvoiceForUser.INVOICE_FOR_USER.NAME;
    }

    @Override
    public Field<Short> field3() {
        return InvoiceForUser.INVOICE_FOR_USER.TYPE;
    }

    @Override
    public Field<Long> field4() {
        return InvoiceForUser.INVOICE_FOR_USER.OWNER_UID;
    }

    @Override
    public Field<Integer> field5() {
        return InvoiceForUser.INVOICE_FOR_USER.SHOULD_PAY;
    }

    @Override
    public Field<Timestamp> field6() {
        return InvoiceForUser.INVOICE_FOR_USER.CREATED_AT;
    }

    @Override
    public Field<Byte> field7() {
        return InvoiceForUser.INVOICE_FOR_USER.STATUS;
    }

    @Override
    public Field<String> field8() {
        return InvoiceForUser.INVOICE_FOR_USER.STATUS_DESCRIPTION;
    }

    @Override
    public Field<Timestamp> field9() {
        return InvoiceForUser.INVOICE_FOR_USER.EXPIRE_AT;
    }

    @Override
    public Field<Timestamp> field10() {
        return InvoiceForUser.INVOICE_FOR_USER.PAID_AT;
    }

    @Override
    public Field<String> field11() {
        return InvoiceForUser.INVOICE_FOR_USER.COMMENT;
    }

    @Override
    public Field<JSON> field12() {
        return InvoiceForUser.INVOICE_FOR_USER.EXTRA_DATA;
    }

    @Override
    public Field<String> field13() {
        return InvoiceForUser.INVOICE_FOR_USER.TYPE_DESCRIPTION;
    }

    @Override
    public Field<String> field14() {
        return InvoiceForUser.INVOICE_FOR_USER.TYPE_DRIVER;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Short component3() {
        return getType();
    }

    @Override
    public Long component4() {
        return getOwnerUid();
    }

    @Override
    public Integer component5() {
        return getShouldPay();
    }

    @Override
    public Timestamp component6() {
        return getCreatedAt();
    }

    @Override
    public Byte component7() {
        return getStatus();
    }

    @Override
    public String component8() {
        return getStatusDescription();
    }

    @Override
    public Timestamp component9() {
        return getExpireAt();
    }

    @Override
    public Timestamp component10() {
        return getPaidAt();
    }

    @Override
    public String component11() {
        return getComment();
    }

    @Override
    public JSON component12() {
        return getExtraData();
    }

    @Override
    public String component13() {
        return getTypeDescription();
    }

    @Override
    public String component14() {
        return getTypeDriver();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Short value3() {
        return getType();
    }

    @Override
    public Long value4() {
        return getOwnerUid();
    }

    @Override
    public Integer value5() {
        return getShouldPay();
    }

    @Override
    public Timestamp value6() {
        return getCreatedAt();
    }

    @Override
    public Byte value7() {
        return getStatus();
    }

    @Override
    public String value8() {
        return getStatusDescription();
    }

    @Override
    public Timestamp value9() {
        return getExpireAt();
    }

    @Override
    public Timestamp value10() {
        return getPaidAt();
    }

    @Override
    public String value11() {
        return getComment();
    }

    @Override
    public JSON value12() {
        return getExtraData();
    }

    @Override
    public String value13() {
        return getTypeDescription();
    }

    @Override
    public String value14() {
        return getTypeDriver();
    }

    @Override
    public InvoiceForUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value3(Short value) {
        setType(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value4(Long value) {
        setOwnerUid(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value5(Integer value) {
        setShouldPay(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value6(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value7(Byte value) {
        setStatus(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value8(String value) {
        setStatusDescription(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value9(Timestamp value) {
        setExpireAt(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value10(Timestamp value) {
        setPaidAt(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value11(String value) {
        setComment(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value12(JSON value) {
        setExtraData(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value13(String value) {
        setTypeDescription(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord value14(String value) {
        setTypeDriver(value);
        return this;
    }

    @Override
    public InvoiceForUserRecord values(Long value1, String value2, Short value3, Long value4, Integer value5, Timestamp value6, Byte value7, String value8, Timestamp value9, Timestamp value10, String value11, JSON value12, String value13, String value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
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

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InvoiceForUserRecord
     */
    public InvoiceForUserRecord() {
        super(InvoiceForUser.INVOICE_FOR_USER);
    }

    /**
     * Create a detached, initialised InvoiceForUserRecord
     */
    public InvoiceForUserRecord(Long id, String name, Short type, Long ownerUid, Integer shouldPay, Timestamp createdAt, Byte status, String statusDescription, Timestamp expireAt, Timestamp paidAt, String comment, JSON extraData, String typeDescription, String typeDriver) {
        super(InvoiceForUser.INVOICE_FOR_USER);

        set(0, id);
        set(1, name);
        set(2, type);
        set(3, ownerUid);
        set(4, shouldPay);
        set(5, createdAt);
        set(6, status);
        set(7, statusDescription);
        set(8, expireAt);
        set(9, paidAt);
        set(10, comment);
        set(11, extraData);
        set(12, typeDescription);
        set(13, typeDriver);
    }
}