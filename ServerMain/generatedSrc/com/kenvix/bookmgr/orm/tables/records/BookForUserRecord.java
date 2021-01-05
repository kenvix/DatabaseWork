/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.BookForUser;
import com.kenvix.bookmgr.orm.tables.interfaces.IBookForUser;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record10;
import org.jooq.Row10;
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
public class BookForUserRecord extends TableRecordImpl<BookForUserRecord> implements Record10<Long, String, String, Long, Timestamp, Integer, Integer, Byte, String, String>, IBookForUser {

    private static final long serialVersionUID = -1298019838;

    /**
     * Setter for <code>book_for_user.id</code>. 书本ID
     */
    @Override
    public BookForUserRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.id</code>. 书本ID
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>book_for_user.title</code>. 书籍标题
     */
    @Override
    public BookForUserRecord setTitle(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.title</code>. 书籍标题
     */
    @Override
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>book_for_user.description</code>. 书籍概述
     */
    @Override
    public BookForUserRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.description</code>. 书籍概述
     */
    @Override
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>book_for_user.publisher_id</code>. 出版社ID
     */
    @Override
    public BookForUserRecord setPublisherId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.publisher_id</code>. 出版社ID
     */
    @Override
    public Long getPublisherId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>book_for_user.created_at</code>. 条目创建时间
     */
    @Override
    public BookForUserRecord setCreatedAt(Timestamp value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.created_at</code>. 条目创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>book_for_user.num_total</code>. 书籍总数
     */
    @Override
    public BookForUserRecord setNumTotal(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.num_total</code>. 书籍总数
     */
    @Override
    public Integer getNumTotal() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>book_for_user.num_available</code>. 可用书籍数
     */
    @Override
    public BookForUserRecord setNumAvailable(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.num_available</code>. 可用书籍数
     */
    @Override
    public Integer getNumAvailable() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>book_for_user.status</code>. 书籍状态
     */
    @Override
    public BookForUserRecord setStatus(Byte value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.status</code>. 书籍状态
     */
    @Override
    public Byte getStatus() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>book_for_user.publisher_name</code>. 出版社名称
     */
    @Override
    public BookForUserRecord setPublisherName(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.publisher_name</code>. 出版社名称
     */
    @Override
    public String getPublisherName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>book_for_user.publisher_description</code>. 出版社简介
     */
    @Override
    public BookForUserRecord setPublisherDescription(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>book_for_user.publisher_description</code>. 出版社简介
     */
    @Override
    public String getPublisherDescription() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, Long, Timestamp, Integer, Integer, Byte, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, String, String, Long, Timestamp, Integer, Integer, Byte, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BookForUser.BOOK_FOR_USER.ID;
    }

    @Override
    public Field<String> field2() {
        return BookForUser.BOOK_FOR_USER.TITLE;
    }

    @Override
    public Field<String> field3() {
        return BookForUser.BOOK_FOR_USER.DESCRIPTION;
    }

    @Override
    public Field<Long> field4() {
        return BookForUser.BOOK_FOR_USER.PUBLISHER_ID;
    }

    @Override
    public Field<Timestamp> field5() {
        return BookForUser.BOOK_FOR_USER.CREATED_AT;
    }

    @Override
    public Field<Integer> field6() {
        return BookForUser.BOOK_FOR_USER.NUM_TOTAL;
    }

    @Override
    public Field<Integer> field7() {
        return BookForUser.BOOK_FOR_USER.NUM_AVAILABLE;
    }

    @Override
    public Field<Byte> field8() {
        return BookForUser.BOOK_FOR_USER.STATUS;
    }

    @Override
    public Field<String> field9() {
        return BookForUser.BOOK_FOR_USER.PUBLISHER_NAME;
    }

    @Override
    public Field<String> field10() {
        return BookForUser.BOOK_FOR_USER.PUBLISHER_DESCRIPTION;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public Long component4() {
        return getPublisherId();
    }

    @Override
    public Timestamp component5() {
        return getCreatedAt();
    }

    @Override
    public Integer component6() {
        return getNumTotal();
    }

    @Override
    public Integer component7() {
        return getNumAvailable();
    }

    @Override
    public Byte component8() {
        return getStatus();
    }

    @Override
    public String component9() {
        return getPublisherName();
    }

    @Override
    public String component10() {
        return getPublisherDescription();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public Long value4() {
        return getPublisherId();
    }

    @Override
    public Timestamp value5() {
        return getCreatedAt();
    }

    @Override
    public Integer value6() {
        return getNumTotal();
    }

    @Override
    public Integer value7() {
        return getNumAvailable();
    }

    @Override
    public Byte value8() {
        return getStatus();
    }

    @Override
    public String value9() {
        return getPublisherName();
    }

    @Override
    public String value10() {
        return getPublisherDescription();
    }

    @Override
    public BookForUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BookForUserRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public BookForUserRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public BookForUserRecord value4(Long value) {
        setPublisherId(value);
        return this;
    }

    @Override
    public BookForUserRecord value5(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public BookForUserRecord value6(Integer value) {
        setNumTotal(value);
        return this;
    }

    @Override
    public BookForUserRecord value7(Integer value) {
        setNumAvailable(value);
        return this;
    }

    @Override
    public BookForUserRecord value8(Byte value) {
        setStatus(value);
        return this;
    }

    @Override
    public BookForUserRecord value9(String value) {
        setPublisherName(value);
        return this;
    }

    @Override
    public BookForUserRecord value10(String value) {
        setPublisherDescription(value);
        return this;
    }

    @Override
    public BookForUserRecord values(Long value1, String value2, String value3, Long value4, Timestamp value5, Integer value6, Integer value7, Byte value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBookForUser from) {
        setId(from.getId());
        setTitle(from.getTitle());
        setDescription(from.getDescription());
        setPublisherId(from.getPublisherId());
        setCreatedAt(from.getCreatedAt());
        setNumTotal(from.getNumTotal());
        setNumAvailable(from.getNumAvailable());
        setStatus(from.getStatus());
        setPublisherName(from.getPublisherName());
        setPublisherDescription(from.getPublisherDescription());
    }

    @Override
    public <E extends IBookForUser> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookForUserRecord
     */
    public BookForUserRecord() {
        super(BookForUser.BOOK_FOR_USER);
    }

    /**
     * Create a detached, initialised BookForUserRecord
     */
    public BookForUserRecord(Long id, String title, String description, Long publisherId, Timestamp createdAt, Integer numTotal, Integer numAvailable, Byte status, String publisherName, String publisherDescription) {
        super(BookForUser.BOOK_FOR_USER);

        set(0, id);
        set(1, title);
        set(2, description);
        set(3, publisherId);
        set(4, createdAt);
        set(5, numTotal);
        set(6, numAvailable);
        set(7, status);
        set(8, publisherName);
        set(9, publisherDescription);
    }
}
