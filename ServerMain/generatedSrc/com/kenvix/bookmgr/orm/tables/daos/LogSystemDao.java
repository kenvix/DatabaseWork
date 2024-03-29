/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.enums.LogSystemLevel;
import com.kenvix.bookmgr.orm.tables.LogSystem;
import com.kenvix.bookmgr.orm.tables.records.LogSystemRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 系统日志
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogSystemDao extends DAOImpl<LogSystemRecord, com.kenvix.bookmgr.orm.tables.pojos.LogSystem, Long> {

    /**
     * Create a new LogSystemDao without any configuration
     */
    public LogSystemDao() {
        super(LogSystem.LOG_SYSTEM, com.kenvix.bookmgr.orm.tables.pojos.LogSystem.class);
    }

    /**
     * Create a new LogSystemDao with an attached configuration
     */
    public LogSystemDao(Configuration configuration) {
        super(LogSystem.LOG_SYSTEM, com.kenvix.bookmgr.orm.tables.pojos.LogSystem.class, configuration);
    }

    @Override
    public Long getId(com.kenvix.bookmgr.orm.tables.pojos.LogSystem object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(LogSystem.LOG_SYSTEM.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchById(Long... values) {
        return fetch(LogSystem.LOG_SYSTEM.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.LogSystem fetchOneById(Long value) {
        return fetchOne(LogSystem.LOG_SYSTEM.ID, value);
    }

    /**
     * Fetch records that have <code>source BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchRangeOfSource(String lowerInclusive, String upperInclusive) {
        return fetchRange(LogSystem.LOG_SYSTEM.SOURCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>source IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchBySource(String... values) {
        return fetch(LogSystem.LOG_SYSTEM.SOURCE, values);
    }

    /**
     * Fetch records that have <code>level BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchRangeOfLevel(LogSystemLevel lowerInclusive, LogSystemLevel upperInclusive) {
        return fetchRange(LogSystem.LOG_SYSTEM.LEVEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>level IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchByLevel(LogSystemLevel... values) {
        return fetch(LogSystem.LOG_SYSTEM.LEVEL, values);
    }

    /**
     * Fetch records that have <code>time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchRangeOfTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(LogSystem.LOG_SYSTEM.TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>time IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchByTime(Timestamp... values) {
        return fetch(LogSystem.LOG_SYSTEM.TIME, values);
    }

    /**
     * Fetch records that have <code>message BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchRangeOfMessage(String lowerInclusive, String upperInclusive) {
        return fetchRange(LogSystem.LOG_SYSTEM.MESSAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>message IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchByMessage(String... values) {
        return fetch(LogSystem.LOG_SYSTEM.MESSAGE, values);
    }

    /**
     * Fetch records that have <code>exception BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchRangeOfException(String lowerInclusive, String upperInclusive) {
        return fetchRange(LogSystem.LOG_SYSTEM.EXCEPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>exception IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.LogSystem> fetchByException(String... values) {
        return fetch(LogSystem.LOG_SYSTEM.EXCEPTION, values);
    }
}
