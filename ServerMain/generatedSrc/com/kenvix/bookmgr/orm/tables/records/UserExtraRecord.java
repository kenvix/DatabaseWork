/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.UserExtra;
import com.kenvix.bookmgr.orm.tables.interfaces.IUserExtra;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户扩展信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserExtraRecord extends UpdatableRecordImpl<UserExtraRecord> implements Record7<Long, Long, Integer, Long, Short, String, String>, IUserExtra {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>user_extra.uid</code>.
     */
    @Override
    public UserExtraRecord setUid(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.uid</code>.
     */
    @Override
    public Long getUid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>user_extra.phone</code>. 电话号
     */
    @Override
    public UserExtraRecord setPhone(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.phone</code>. 电话号
     */
    @Override
    public Long getPhone() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>user_extra.money</code>. 可用钱数（单位为分）
     */
    @Override
    public UserExtraRecord setMoney(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.money</code>. 可用钱数（单位为分）
     */
    @Override
    public Integer getMoney() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>user_extra.card_serial_id</code>. 卡片序列号
     */
    @Override
    public UserExtraRecord setCardSerialId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.card_serial_id</code>. 卡片序列号
     */
    @Override
    public Long getCardSerialId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>user_extra.start_year</code>. 入学(职)年份
     */
    @Override
    public UserExtraRecord setStartYear(Short value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.start_year</code>. 入学(职)年份
     */
    @Override
    public Short getStartYear() {
        return (Short) get(4);
    }

    /**
     * Setter for <code>user_extra.department</code>. 所在部门
     */
    @Override
    public UserExtraRecord setDepartment(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.department</code>. 所在部门
     */
    @Override
    public String getDepartment() {
        return (String) get(5);
    }

    /**
     * Setter for <code>user_extra.comment</code>. 备注
     */
    @Override
    public UserExtraRecord setComment(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>user_extra.comment</code>. 备注
     */
    @Override
    public String getComment() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, Integer, Long, Short, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, Long, Integer, Long, Short, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UserExtra.USER_EXTRA.UID;
    }

    @Override
    public Field<Long> field2() {
        return UserExtra.USER_EXTRA.PHONE;
    }

    @Override
    public Field<Integer> field3() {
        return UserExtra.USER_EXTRA.MONEY;
    }

    @Override
    public Field<Long> field4() {
        return UserExtra.USER_EXTRA.CARD_SERIAL_ID;
    }

    @Override
    public Field<Short> field5() {
        return UserExtra.USER_EXTRA.START_YEAR;
    }

    @Override
    public Field<String> field6() {
        return UserExtra.USER_EXTRA.DEPARTMENT;
    }

    @Override
    public Field<String> field7() {
        return UserExtra.USER_EXTRA.COMMENT;
    }

    @Override
    public Long component1() {
        return getUid();
    }

    @Override
    public Long component2() {
        return getPhone();
    }

    @Override
    public Integer component3() {
        return getMoney();
    }

    @Override
    public Long component4() {
        return getCardSerialId();
    }

    @Override
    public Short component5() {
        return getStartYear();
    }

    @Override
    public String component6() {
        return getDepartment();
    }

    @Override
    public String component7() {
        return getComment();
    }

    @Override
    public Long value1() {
        return getUid();
    }

    @Override
    public Long value2() {
        return getPhone();
    }

    @Override
    public Integer value3() {
        return getMoney();
    }

    @Override
    public Long value4() {
        return getCardSerialId();
    }

    @Override
    public Short value5() {
        return getStartYear();
    }

    @Override
    public String value6() {
        return getDepartment();
    }

    @Override
    public String value7() {
        return getComment();
    }

    @Override
    public UserExtraRecord value1(Long value) {
        setUid(value);
        return this;
    }

    @Override
    public UserExtraRecord value2(Long value) {
        setPhone(value);
        return this;
    }

    @Override
    public UserExtraRecord value3(Integer value) {
        setMoney(value);
        return this;
    }

    @Override
    public UserExtraRecord value4(Long value) {
        setCardSerialId(value);
        return this;
    }

    @Override
    public UserExtraRecord value5(Short value) {
        setStartYear(value);
        return this;
    }

    @Override
    public UserExtraRecord value6(String value) {
        setDepartment(value);
        return this;
    }

    @Override
    public UserExtraRecord value7(String value) {
        setComment(value);
        return this;
    }

    @Override
    public UserExtraRecord values(Long value1, Long value2, Integer value3, Long value4, Short value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUserExtra from) {
        setUid(from.getUid());
        setPhone(from.getPhone());
        setMoney(from.getMoney());
        setCardSerialId(from.getCardSerialId());
        setStartYear(from.getStartYear());
        setDepartment(from.getDepartment());
        setComment(from.getComment());
    }

    @Override
    public <E extends IUserExtra> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserExtraRecord
     */
    public UserExtraRecord() {
        super(UserExtra.USER_EXTRA);
    }

    /**
     * Create a detached, initialised UserExtraRecord
     */
    public UserExtraRecord(Long uid, Long phone, Integer money, Long cardSerialId, Short startYear, String department, String comment) {
        super(UserExtra.USER_EXTRA);

        setUid(uid);
        setPhone(phone);
        setMoney(money);
        setCardSerialId(cardSerialId);
        setStartYear(startYear);
        setDepartment(department);
        setComment(comment);
    }
}
