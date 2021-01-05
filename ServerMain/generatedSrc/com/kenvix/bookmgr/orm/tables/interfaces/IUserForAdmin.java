/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.processing.Generated;


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
public interface IUserForAdmin extends Serializable {

    /**
     * Setter for <code>user_for_admin.uid</code>. 用户UID
     */
    public IUserForAdmin setUid(Long value);

    /**
     * Getter for <code>user_for_admin.uid</code>. 用户UID
     */
    public Long getUid();

    /**
     * Setter for <code>user_for_admin.serial_id</code>. 工号/序列号
     */
    public IUserForAdmin setSerialId(String value);

    /**
     * Getter for <code>user_for_admin.serial_id</code>. 工号/序列号
     */
    public String getSerialId();

    /**
     * Setter for <code>user_for_admin.email</code>. 电子邮箱
     */
    public IUserForAdmin setEmail(String value);

    /**
     * Getter for <code>user_for_admin.email</code>. 电子邮箱
     */
    public String getEmail();

    /**
     * Setter for <code>user_for_admin.real_name</code>. 真实姓名
     */
    public IUserForAdmin setRealName(String value);

    /**
     * Getter for <code>user_for_admin.real_name</code>. 真实姓名
     */
    public String getRealName();

    /**
     * Setter for <code>user_for_admin.password</code>. Bcrypt密码哈希值
     */
    public IUserForAdmin setPassword(String value);

    /**
     * Getter for <code>user_for_admin.password</code>. Bcrypt密码哈希值
     */
    public String getPassword();

    /**
     * Setter for <code>user_for_admin.access_level</code>. 访问级别
     */
    public IUserForAdmin setAccessLevel(Byte value);

    /**
     * Getter for <code>user_for_admin.access_level</code>. 访问级别
     */
    public Byte getAccessLevel();

    /**
     * Setter for <code>user_for_admin.access_level_description</code>.
     */
    public IUserForAdmin setAccessLevelDescription(String value);

    /**
     * Getter for <code>user_for_admin.access_level_description</code>.
     */
    public String getAccessLevelDescription();

    /**
     * Setter for <code>user_for_admin.created_at</code>. 创建时间
     */
    public IUserForAdmin setCreatedAt(Timestamp value);

    /**
     * Getter for <code>user_for_admin.created_at</code>. 创建时间
     */
    public Timestamp getCreatedAt();

    /**
     * Setter for <code>user_for_admin.phone</code>. 电话号
     */
    public IUserForAdmin setPhone(Long value);

    /**
     * Getter for <code>user_for_admin.phone</code>. 电话号
     */
    public Long getPhone();

    /**
     * Setter for <code>user_for_admin.card_serial_id</code>. 卡片序列号
     */
    public IUserForAdmin setCardSerialId(Long value);

    /**
     * Getter for <code>user_for_admin.card_serial_id</code>. 卡片序列号
     */
    public Long getCardSerialId();

    /**
     * Setter for <code>user_for_admin.start_year</code>. 入学(职)年份
     */
    public IUserForAdmin setStartYear(Short value);

    /**
     * Getter for <code>user_for_admin.start_year</code>. 入学(职)年份
     */
    public Short getStartYear();

    /**
     * Setter for <code>user_for_admin.department</code>. 所在部门
     */
    public IUserForAdmin setDepartment(String value);

    /**
     * Getter for <code>user_for_admin.department</code>. 所在部门
     */
    public String getDepartment();

    /**
     * Setter for <code>user_for_admin.comment</code>. 备注
     */
    public IUserForAdmin setComment(String value);

    /**
     * Getter for <code>user_for_admin.comment</code>. 备注
     */
    public String getComment();

    /**
     * Setter for <code>user_for_admin.ip_creation</code>. 创建时IP
     */
    public IUserForAdmin setIpCreation(String value);

    /**
     * Getter for <code>user_for_admin.ip_creation</code>. 创建时IP
     */
    public String getIpCreation();

    /**
     * Setter for <code>user_for_admin.ip_login</code>. 上次登录IP
     */
    public IUserForAdmin setIpLogin(String value);

    /**
     * Getter for <code>user_for_admin.ip_login</code>. 上次登录IP
     */
    public String getIpLogin();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IUserForAdmin
     */
    public void from(IUserForAdmin from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IUserForAdmin
     */
    public <E extends IUserForAdmin> E into(E into);
}