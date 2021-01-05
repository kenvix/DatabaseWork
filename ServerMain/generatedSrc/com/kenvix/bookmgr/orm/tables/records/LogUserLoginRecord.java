/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.LogUserLogin;
import com.kenvix.bookmgr.orm.tables.interfaces.ILogUserLogin;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户登录日志（不可修改和删除）
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogUserLoginRecord extends UpdatableRecordImpl<LogUserLoginRecord> implements Record5<Long, Long, Timestamp, String, String>, ILogUserLogin {

    private static final long serialVersionUID = -742042129;

    /**
     * Setter for <code>log_user_login.id</code>.
     */
    @Override
    public LogUserLoginRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login.id</code>.
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>log_user_login.uid</code>. 用户UID
     */
    @Override
    public LogUserLoginRecord setUid(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login.uid</code>. 用户UID
     */
    @Override
    public Long getUid() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>log_user_login.time</code>. 登录时间
     */
    @Override
    public LogUserLoginRecord setTime(Timestamp value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login.time</code>. 登录时间
     */
    @Override
    public Timestamp getTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>log_user_login.ip</code>. 登录IP
     */
    @Override
    public LogUserLoginRecord setIp(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login.ip</code>. 登录IP
     */
    @Override
    public String getIp() {
        return (String) get(3);
    }

    /**
     * Setter for <code>log_user_login.useragent</code>. 用户代理
     */
    @Override
    public LogUserLoginRecord setUseragent(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>log_user_login.useragent</code>. 用户代理
     */
    @Override
    public String getUseragent() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Timestamp, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, Timestamp, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return LogUserLogin.LOG_USER_LOGIN.ID;
    }

    @Override
    public Field<Long> field2() {
        return LogUserLogin.LOG_USER_LOGIN.UID;
    }

    @Override
    public Field<Timestamp> field3() {
        return LogUserLogin.LOG_USER_LOGIN.TIME;
    }

    @Override
    public Field<String> field4() {
        return LogUserLogin.LOG_USER_LOGIN.IP;
    }

    @Override
    public Field<String> field5() {
        return LogUserLogin.LOG_USER_LOGIN.USERAGENT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getUid();
    }

    @Override
    public Timestamp component3() {
        return getTime();
    }

    @Override
    public String component4() {
        return getIp();
    }

    @Override
    public String component5() {
        return getUseragent();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getUid();
    }

    @Override
    public Timestamp value3() {
        return getTime();
    }

    @Override
    public String value4() {
        return getIp();
    }

    @Override
    public String value5() {
        return getUseragent();
    }

    @Override
    public LogUserLoginRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public LogUserLoginRecord value2(Long value) {
        setUid(value);
        return this;
    }

    @Override
    public LogUserLoginRecord value3(Timestamp value) {
        setTime(value);
        return this;
    }

    @Override
    public LogUserLoginRecord value4(String value) {
        setIp(value);
        return this;
    }

    @Override
    public LogUserLoginRecord value5(String value) {
        setUseragent(value);
        return this;
    }

    @Override
    public LogUserLoginRecord values(Long value1, Long value2, Timestamp value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ILogUserLogin from) {
        setId(from.getId());
        setUid(from.getUid());
        setTime(from.getTime());
        setIp(from.getIp());
        setUseragent(from.getUseragent());
    }

    @Override
    public <E extends ILogUserLogin> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LogUserLoginRecord
     */
    public LogUserLoginRecord() {
        super(LogUserLogin.LOG_USER_LOGIN);
    }

    /**
     * Create a detached, initialised LogUserLoginRecord
     */
    public LogUserLoginRecord(Long id, Long uid, Timestamp time, String ip, String useragent) {
        super(LogUserLogin.LOG_USER_LOGIN);

        set(0, id);
        set(1, uid);
        set(2, time);
        set(3, ip);
        set(4, useragent);
    }
}
