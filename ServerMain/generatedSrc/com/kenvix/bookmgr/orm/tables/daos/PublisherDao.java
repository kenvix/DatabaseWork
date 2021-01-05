/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.tables.Publisher;
import com.kenvix.bookmgr.orm.tables.records.PublisherRecord;

import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 出版社
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PublisherDao extends DAOImpl<PublisherRecord, com.kenvix.bookmgr.orm.tables.pojos.Publisher, Long> {

    /**
     * Create a new PublisherDao without any configuration
     */
    public PublisherDao() {
        super(Publisher.PUBLISHER, com.kenvix.bookmgr.orm.tables.pojos.Publisher.class);
    }

    /**
     * Create a new PublisherDao with an attached configuration
     */
    public PublisherDao(Configuration configuration) {
        super(Publisher.PUBLISHER, com.kenvix.bookmgr.orm.tables.pojos.Publisher.class, configuration);
    }

    @Override
    public Long getId(com.kenvix.bookmgr.orm.tables.pojos.Publisher object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Publisher> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Publisher.PUBLISHER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Publisher> fetchById(Long... values) {
        return fetch(Publisher.PUBLISHER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.Publisher fetchOneById(Long value) {
        return fetchOne(Publisher.PUBLISHER.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Publisher> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Publisher.PUBLISHER.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Publisher> fetchByName(String... values) {
        return fetch(Publisher.PUBLISHER.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.Publisher fetchOneByName(String value) {
        return fetchOne(Publisher.PUBLISHER.NAME, value);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Publisher> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Publisher.PUBLISHER.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Publisher> fetchByDescription(String... values) {
        return fetch(Publisher.PUBLISHER.DESCRIPTION, values);
    }
}
