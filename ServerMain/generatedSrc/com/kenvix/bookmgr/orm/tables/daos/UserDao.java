/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.tables.User;
import com.kenvix.bookmgr.orm.tables.records.UserRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class UserDao extends DAOImpl<UserRecord, com.kenvix.bookmgr.orm.tables.pojos.User, Long> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, com.kenvix.bookmgr.orm.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    public UserDao(Configuration configuration) {
        super(User.USER, com.kenvix.bookmgr.orm.tables.pojos.User.class, configuration);
    }

    @Override
    public Long getId(com.kenvix.bookmgr.orm.tables.pojos.User object) {
        return object.getUid();
    }

    /**
     * Fetch records that have <code>uid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfUid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(User.USER.UID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uid IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByUid(Long... values) {
        return fetch(User.USER.UID, values);
    }

    /**
     * Fetch a unique record that has <code>uid = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.User fetchOneByUid(Long value) {
        return fetchOne(User.USER.UID, value);
    }

    /**
     * Fetch records that have <code>serial_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfSerialId(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.SERIAL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>serial_id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchBySerialId(String... values) {
        return fetch(User.USER.SERIAL_ID, values);
    }

    /**
     * Fetch a unique record that has <code>serial_id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.User fetchOneBySerialId(String value) {
        return fetchOne(User.USER.SERIAL_ID, value);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByEmail(String... values) {
        return fetch(User.USER.EMAIL, values);
    }

    /**
     * Fetch a unique record that has <code>email = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.User fetchOneByEmail(String value) {
        return fetchOne(User.USER.EMAIL, value);
    }

    /**
     * Fetch records that have <code>real_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfRealName(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.REAL_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>real_name IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByRealName(String... values) {
        return fetch(User.USER.REAL_NAME, values);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByPassword(String... values) {
        return fetch(User.USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>access_level BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfAccessLevel(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(User.USER.ACCESS_LEVEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>access_level IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByAccessLevel(Byte... values) {
        return fetch(User.USER.ACCESS_LEVEL, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfCreatedAt(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(User.USER.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByCreatedAt(Timestamp... values) {
        return fetch(User.USER.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>ip_creation BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfIpCreation(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.IP_CREATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ip_creation IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByIpCreation(String... values) {
        return fetch(User.USER.IP_CREATION, values);
    }

    /**
     * Fetch records that have <code>ip_login BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchRangeOfIpLogin(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.IP_LOGIN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ip_login IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.User> fetchByIpLogin(String... values) {
        return fetch(User.USER.IP_LOGIN, values);
    }
}
