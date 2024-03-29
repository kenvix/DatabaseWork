/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.tables.LogUserLogin;
import com.kenvix.bookmgr.orm.tables.records.LogUserLoginRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 用户登录日志（不可修改和删除）
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogUserLoginDao extends DAOImpl<LogUserLoginRecord, com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin, Long> {

    /**
     * Create a new LogUserLoginDao without any configuration
     */
    public LogUserLoginDao() {
        super(LogUserLogin.LOG_USER_LOGIN, com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin.class);
    }

    /**
     * Create a new LogUserLoginDao with an attached configuration
     */
    public LogUserLoginDao(Configuration configuration) {
        super(LogUserLogin.LOG_USER_LOGIN, com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin.class, configuration);
    }

    @Override
    public Long getId(com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(LogUserLogin.LOG_USER_LOGIN.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchById(Long... values) {
        return fetch(LogUserLogin.LOG_USER_LOGIN.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin fetchOneById(Long value) {
        return fetchOne(LogUserLogin.LOG_USER_LOGIN.ID, value);
    }

    /**
     * Fetch records that have <code>uid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchRangeOfUid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(LogUserLogin.LOG_USER_LOGIN.UID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uid IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchByUid(Long... values) {
        return fetch(LogUserLogin.LOG_USER_LOGIN.UID, values);
    }

    /**
     * Fetch records that have <code>time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchRangeOfTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(LogUserLogin.LOG_USER_LOGIN.TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>time IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchByTime(Timestamp... values) {
        return fetch(LogUserLogin.LOG_USER_LOGIN.TIME, values);
    }

    /**
     * Fetch records that have <code>ip BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchRangeOfIp(String lowerInclusive, String upperInclusive) {
        return fetchRange(LogUserLogin.LOG_USER_LOGIN.IP, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ip IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchByIp(String... values) {
        return fetch(LogUserLogin.LOG_USER_LOGIN.IP, values);
    }

    /**
     * Fetch records that have <code>useragent BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchRangeOfUseragent(String lowerInclusive, String upperInclusive) {
        return fetchRange(LogUserLogin.LOG_USER_LOGIN.USERAGENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>useragent IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogUserLogin> fetchByUseragent(String... values) {
        return fetch(LogUserLogin.LOG_USER_LOGIN.USERAGENT, values);
    }
}
