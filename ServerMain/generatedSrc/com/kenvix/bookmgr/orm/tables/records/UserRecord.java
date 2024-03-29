/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.User;
import com.kenvix.bookmgr.orm.tables.interfaces.IUser;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户基本信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record9<Long, String, String, String, String, Byte, Timestamp, String, String>, IUser {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>user.uid</code>. 用户UID
     */
    @Override
    public UserRecord setUid(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>user.uid</code>. 用户UID
     */
    @Override
    public Long getUid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>user.serial_id</code>. 工号/序列号
     */
    @Override
    public UserRecord setSerialId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>user.serial_id</code>. 工号/序列号
     */
    @Override
    public String getSerialId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>user.email</code>. 电子邮箱
     */
    @Override
    public UserRecord setEmail(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>user.email</code>. 电子邮箱
     */
    @Override
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>user.real_name</code>. 真实姓名
     */
    @Override
    public UserRecord setRealName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>user.real_name</code>. 真实姓名
     */
    @Override
    public String getRealName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>user.password</code>. Bcrypt密码哈希值
     */
    @Override
    public UserRecord setPassword(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>user.password</code>. Bcrypt密码哈希值
     */
    @Override
    public String getPassword() {
        return (String) get(4);
    }

    /**
     * Setter for <code>user.access_level</code>. 访问级别
     */
    @Override
    public UserRecord setAccessLevel(Byte value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>user.access_level</code>. 访问级别
     */
    @Override
    public Byte getAccessLevel() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>user.created_at</code>. 创建时间
     */
    @Override
    public UserRecord setCreatedAt(Timestamp value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>user.created_at</code>. 创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>user.ip_creation</code>. 创建时IP
     */
    @Override
    public UserRecord setIpCreation(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>user.ip_creation</code>. 创建时IP
     */
    @Override
    public String getIpCreation() {
        return (String) get(7);
    }

    /**
     * Setter for <code>user.ip_login</code>. 上次登录IP
     */
    @Override
    public UserRecord setIpLogin(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>user.ip_login</code>. 上次登录IP
     */
    @Override
    public String getIpLogin() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, String, Byte, Timestamp, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, String, String, Byte, Timestamp, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return User.USER.UID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.SERIAL_ID;
    }

    @Override
    public Field<String> field3() {
        return User.USER.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return User.USER.REAL_NAME;
    }

    @Override
    public Field<String> field5() {
        return User.USER.PASSWORD;
    }

    @Override
    public Field<Byte> field6() {
        return User.USER.ACCESS_LEVEL;
    }

    @Override
    public Field<Timestamp> field7() {
        return User.USER.CREATED_AT;
    }

    @Override
    public Field<String> field8() {
        return User.USER.IP_CREATION;
    }

    @Override
    public Field<String> field9() {
        return User.USER.IP_LOGIN;
    }

    @Override
    public Long component1() {
        return getUid();
    }

    @Override
    public String component2() {
        return getSerialId();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getRealName();
    }

    @Override
    public String component5() {
        return getPassword();
    }

    @Override
    public Byte component6() {
        return getAccessLevel();
    }

    @Override
    public Timestamp component7() {
        return getCreatedAt();
    }

    @Override
    public String component8() {
        return getIpCreation();
    }

    @Override
    public String component9() {
        return getIpLogin();
    }

    @Override
    public Long value1() {
        return getUid();
    }

    @Override
    public String value2() {
        return getSerialId();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getRealName();
    }

    @Override
    public String value5() {
        return getPassword();
    }

    @Override
    public Byte value6() {
        return getAccessLevel();
    }

    @Override
    public Timestamp value7() {
        return getCreatedAt();
    }

    @Override
    public String value8() {
        return getIpCreation();
    }

    @Override
    public String value9() {
        return getIpLogin();
    }

    @Override
    public UserRecord value1(Long value) {
        setUid(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setSerialId(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setRealName(value);
        return this;
    }

    @Override
    public UserRecord value5(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value6(Byte value) {
        setAccessLevel(value);
        return this;
    }

    @Override
    public UserRecord value7(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UserRecord value8(String value) {
        setIpCreation(value);
        return this;
    }

    @Override
    public UserRecord value9(String value) {
        setIpLogin(value);
        return this;
    }

    @Override
    public UserRecord values(Long value1, String value2, String value3, String value4, String value5, Byte value6, Timestamp value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUser from) {
        setUid(from.getUid());
        setSerialId(from.getSerialId());
        setEmail(from.getEmail());
        setRealName(from.getRealName());
        setPassword(from.getPassword());
        setAccessLevel(from.getAccessLevel());
        setCreatedAt(from.getCreatedAt());
        setIpCreation(from.getIpCreation());
        setIpLogin(from.getIpLogin());
    }

    @Override
    public <E extends IUser> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Long uid, String serialId, String email, String realName, String password, Byte accessLevel, Timestamp createdAt, String ipCreation, String ipLogin) {
        super(User.USER);

        setUid(uid);
        setSerialId(serialId);
        setEmail(email);
        setRealName(realName);
        setPassword(password);
        setAccessLevel(accessLevel);
        setCreatedAt(createdAt);
        setIpCreation(ipCreation);
        setIpLogin(ipLogin);
    }
}
