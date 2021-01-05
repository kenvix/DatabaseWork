/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.processing.Generated;


/**
 * 用户基本信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IUser extends Serializable {

    /**
     * Setter for <code>user.uid</code>. 用户UID
     */
    public IUser setUid(Long value);

    /**
     * Getter for <code>user.uid</code>. 用户UID
     */
    public Long getUid();

    /**
     * Setter for <code>user.serial_id</code>. 工号/序列号
     */
    public IUser setSerialId(String value);

    /**
     * Getter for <code>user.serial_id</code>. 工号/序列号
     */
    public String getSerialId();

    /**
     * Setter for <code>user.email</code>. 电子邮箱
     */
    public IUser setEmail(String value);

    /**
     * Getter for <code>user.email</code>. 电子邮箱
     */
    public String getEmail();

    /**
     * Setter for <code>user.real_name</code>. 真实姓名
     */
    public IUser setRealName(String value);

    /**
     * Getter for <code>user.real_name</code>. 真实姓名
     */
    public String getRealName();

    /**
     * Setter for <code>user.password</code>. Bcrypt密码哈希值
     */
    public IUser setPassword(String value);

    /**
     * Getter for <code>user.password</code>. Bcrypt密码哈希值
     */
    public String getPassword();

    /**
     * Setter for <code>user.access_level</code>. 访问级别
     */
    public IUser setAccessLevel(Byte value);

    /**
     * Getter for <code>user.access_level</code>. 访问级别
     */
    public Byte getAccessLevel();

    /**
     * Setter for <code>user.created_at</code>. 创建时间
     */
    public IUser setCreatedAt(Timestamp value);

    /**
     * Getter for <code>user.created_at</code>. 创建时间
     */
    public Timestamp getCreatedAt();

    /**
     * Setter for <code>user.ip_creation</code>. 创建时IP
     */
    public IUser setIpCreation(String value);

    /**
     * Getter for <code>user.ip_creation</code>. 创建时IP
     */
    public String getIpCreation();

    /**
     * Setter for <code>user.ip_login</code>. 上次登录IP
     */
    public IUser setIpLogin(String value);

    /**
     * Getter for <code>user.ip_login</code>. 上次登录IP
     */
    public String getIpLogin();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IUser
     */
    public void from(IUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IUser
     */
    public <E extends IUser> E into(E into);
}