/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.tables.UserAccessLevel;
import com.kenvix.bookmgr.orm.tables.records.UserAccessLevelRecord;

import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 用户访问级别定义
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAccessLevelDao extends DAOImpl<UserAccessLevelRecord, com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel, Byte> {

    /**
     * Create a new UserAccessLevelDao without any configuration
     */
    public UserAccessLevelDao() {
        super(UserAccessLevel.USER_ACCESS_LEVEL, com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel.class);
    }

    /**
     * Create a new UserAccessLevelDao with an attached configuration
     */
    public UserAccessLevelDao(Configuration configuration) {
        super(UserAccessLevel.USER_ACCESS_LEVEL, com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel.class, configuration);
    }

    @Override
    public Byte getId(com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel> fetchRangeOfId(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(UserAccessLevel.USER_ACCESS_LEVEL.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel> fetchById(Byte... values) {
        return fetch(UserAccessLevel.USER_ACCESS_LEVEL.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel fetchOneById(Byte value) {
        return fetchOne(UserAccessLevel.USER_ACCESS_LEVEL.ID, value);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(UserAccessLevel.USER_ACCESS_LEVEL.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.UserAccessLevel> fetchByDescription(String... values) {
        return fetch(UserAccessLevel.USER_ACCESS_LEVEL.DESCRIPTION, values);
    }
}