/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.LogUserLoginForAdmin;
import com.kenvix.bookmgr.orm.tables.interfaces.ILogUserLoginForAdmin;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class LogUserLoginForAdminRecord extends TableRecordImpl<LogUserLoginForAdminRecord> implements Record9<Timestamp, Byte, String, String, String, Long, String, Timestamp, String>, ILogUserLoginForAdmin {

    private static final long serialVersionUID = 810587353;

    /**
     * Setter for <code>log_user_login_for_admin.created_at</code>. 创建时间
     */
    @Override
    public LogUserLoginForAdminRecord setCreatedAt(Timestamp value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.created_at</code>. 创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(0);
    }

    /**
     * Setter for <code>log_user_login_for_admin.access_level</code>. 访问级别
     */
    @Override
    public LogUserLoginForAdminRecord setAccessLevel(Byte value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.access_level</code>. 访问级别
     */
    @Override
    public Byte getAccessLevel() {
        return (Byte) get(1);
    }

    /**
     * Setter for <code>log_user_login_for_admin.real_name</code>. 真实姓名
     */
    @Override
    public LogUserLoginForAdminRecord setRealName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.real_name</code>. 真实姓名
     */
    @Override
    public String getRealName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>log_user_login_for_admin.email</code>. 电子邮箱
     */
    @Override
    public LogUserLoginForAdminRecord setEmail(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.email</code>. 电子邮箱
     */
    @Override
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>log_user_login_for_admin.serial_id</code>. 工号/序列号
     */
    @Override
    public LogUserLoginForAdminRecord setSerialId(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.serial_id</code>. 工号/序列号
     */
    @Override
    public String getSerialId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>log_user_login_for_admin.uid</code>. 用户UID
     */
    @Override
    public LogUserLoginForAdminRecord setUid(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.uid</code>. 用户UID
     */
    @Override
    public Long getUid() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>log_user_login_for_admin.ip</code>. 登录IP
     */
    @Override
    public LogUserLoginForAdminRecord setIp(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.ip</code>. 登录IP
     */
    @Override
    public String getIp() {
        return (String) get(6);
    }

    /**
     * Setter for <code>log_user_login_for_admin.time</code>. 登录时间
     */
    @Override
    public LogUserLoginForAdminRecord setTime(Timestamp value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.time</code>. 登录时间
     */
    @Override
    public Timestamp getTime() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>log_user_login_for_admin.useragent</code>. 用户代理
     */
    @Override
    public LogUserLoginForAdminRecord setUseragent(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login_for_admin.useragent</code>. 用户代理
     */
    @Override
    public String getUseragent() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Timestamp, Byte, String, String, String, Long, String, Timestamp, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Timestamp, Byte, String, String, String, Long, String, Timestamp, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Timestamp> field1() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.CREATED_AT;
    }

    @Override
    public Field<Byte> field2() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.ACCESS_LEVEL;
    }

    @Override
    public Field<String> field3() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.REAL_NAME;
    }

    @Override
    public Field<String> field4() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.SERIAL_ID;
    }

    @Override
    public Field<Long> field6() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.UID;
    }

    @Override
    public Field<String> field7() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.IP;
    }

    @Override
    public Field<Timestamp> field8() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.TIME;
    }

    @Override
    public Field<String> field9() {
        return LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN.USERAGENT;
    }

    @Override
    public Timestamp component1() {
        return getCreatedAt();
    }

    @Override
    public Byte component2() {
        return getAccessLevel();
    }

    @Override
    public String component3() {
        return getRealName();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getSerialId();
    }

    @Override
    public Long component6() {
        return getUid();
    }

    @Override
    public String component7() {
        return getIp();
    }

    @Override
    public Timestamp component8() {
        return getTime();
    }

    @Override
    public String component9() {
        return getUseragent();
    }

    @Override
    public Timestamp value1() {
        return getCreatedAt();
    }

    @Override
    public Byte value2() {
        return getAccessLevel();
    }

    @Override
    public String value3() {
        return getRealName();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getSerialId();
    }

    @Override
    public Long value6() {
        return getUid();
    }

    @Override
    public String value7() {
        return getIp();
    }

    @Override
    public Timestamp value8() {
        return getTime();
    }

    @Override
    public String value9() {
        return getUseragent();
    }

    @Override
    public LogUserLoginForAdminRecord value1(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value2(Byte value) {
        setAccessLevel(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value3(String value) {
        setRealName(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value5(String value) {
        setSerialId(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value6(Long value) {
        setUid(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value7(String value) {
        setIp(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value8(Timestamp value) {
        setTime(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord value9(String value) {
        setUseragent(value);
        return this;
    }

    @Override
    public LogUserLoginForAdminRecord values(Timestamp value1, Byte value2, String value3, String value4, String value5, Long value6, String value7, Timestamp value8, String value9) {
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
    public void from(ILogUserLoginForAdmin from) {
        setCreatedAt(from.getCreatedAt());
        setAccessLevel(from.getAccessLevel());
        setRealName(from.getRealName());
        setEmail(from.getEmail());
        setSerialId(from.getSerialId());
        setUid(from.getUid());
        setIp(from.getIp());
        setTime(from.getTime());
        setUseragent(from.getUseragent());
    }

    @Override
    public <E extends ILogUserLoginForAdmin> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LogUserLoginForAdminRecord
     */
    public LogUserLoginForAdminRecord() {
        super(LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN);
    }

    /**
     * Create a detached, initialised LogUserLoginForAdminRecord
     */
    public LogUserLoginForAdminRecord(Timestamp createdAt, Byte accessLevel, String realName, String email, String serialId, Long uid, String ip, Timestamp time, String useragent) {
        super(LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN);

        set(0, createdAt);
        set(1, accessLevel);
        set(2, realName);
        set(3, email);
        set(4, serialId);
        set(5, uid);
        set(6, ip);
        set(7, time);
        set(8, useragent);
    }
}