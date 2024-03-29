/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.daos;


import com.kenvix.bookmgr.orm.tables.Book;
import com.kenvix.bookmgr.orm.tables.records.BookRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 书籍表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookDao extends DAOImpl<BookRecord, com.kenvix.bookmgr.orm.tables.pojos.Book, Long> {

    /**
     * Create a new BookDao without any configuration
     */
    public BookDao() {
        super(Book.BOOK, com.kenvix.bookmgr.orm.tables.pojos.Book.class);
    }

    /**
     * Create a new BookDao with an attached configuration
     */
    public BookDao(Configuration configuration) {
        super(Book.BOOK, com.kenvix.bookmgr.orm.tables.pojos.Book.class, configuration);
    }

    @Override
    public Long getId(com.kenvix.bookmgr.orm.tables.pojos.Book object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Book.BOOK.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchById(Long... values) {
        return fetch(Book.BOOK.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenvix.bookmgr.orm.tables.pojos.Book fetchOneById(Long value) {
        return fetchOne(Book.BOOK.ID, value);
    }

    /**
     * Fetch records that have <code>creator_uid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfCreatorUid(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Book.BOOK.CREATOR_UID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>creator_uid IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByCreatorUid(Long... values) {
        return fetch(Book.BOOK.CREATOR_UID, values);
    }

    /**
     * Fetch records that have <code>type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Book.BOOK.TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>type_id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByTypeId(Integer... values) {
        return fetch(Book.BOOK.TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>title BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfTitle(String lowerInclusive, String upperInclusive) {
        return fetchRange(Book.BOOK.TITLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByTitle(String... values) {
        return fetch(Book.BOOK.TITLE, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Book.BOOK.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByDescription(String... values) {
        return fetch(Book.BOOK.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>publisher_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfPublisherId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Book.BOOK.PUBLISHER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>publisher_id IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByPublisherId(Long... values) {
        return fetch(Book.BOOK.PUBLISHER_ID, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfCreatedAt(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(Book.BOOK.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByCreatedAt(Timestamp... values) {
        return fetch(Book.BOOK.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>num_total BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfNumTotal(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Book.BOOK.NUM_TOTAL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>num_total IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByNumTotal(Integer... values) {
        return fetch(Book.BOOK.NUM_TOTAL, values);
    }

    /**
     * Fetch records that have <code>num_available BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfNumAvailable(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Book.BOOK.NUM_AVAILABLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>num_available IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByNumAvailable(Integer... values) {
        return fetch(Book.BOOK.NUM_AVAILABLE, values);
    }

    /**
     * Fetch records that have <code>isbn BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfIsbn(String lowerInclusive, String upperInclusive) {
        return fetchRange(Book.BOOK.ISBN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>isbn IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByIsbn(String... values) {
        return fetch(Book.BOOK.ISBN, values);
    }

    /**
     * Fetch records that have <code>status BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchRangeOfStatus(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Book.BOOK.STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.kenvix.bookmgr.orm.tables.pojos.Book> fetchByStatus(Byte... values) {
        return fetch(Book.BOOK.STATUS, values);
    }
}
