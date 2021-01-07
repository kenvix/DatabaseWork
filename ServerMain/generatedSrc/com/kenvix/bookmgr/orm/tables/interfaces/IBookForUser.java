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
public interface IBookForUser extends Serializable {

    /**
     * Setter for <code>book_for_user.id</code>. 书本ID
     */
    public IBookForUser setId(Long value);

    /**
     * Getter for <code>book_for_user.id</code>. 书本ID
     */
    public Long getId();

    /**
     * Setter for <code>book_for_user.title</code>. 书籍标题
     */
    public IBookForUser setTitle(String value);

    /**
     * Getter for <code>book_for_user.title</code>. 书籍标题
     */
    public String getTitle();

    /**
     * Setter for <code>book_for_user.description</code>. 书籍概述
     */
    public IBookForUser setDescription(String value);

    /**
     * Getter for <code>book_for_user.description</code>. 书籍概述
     */
    public String getDescription();

    /**
     * Setter for <code>book_for_user.publisher_id</code>. 出版社ID
     */
    public IBookForUser setPublisherId(Long value);

    /**
     * Getter for <code>book_for_user.publisher_id</code>. 出版社ID
     */
    public Long getPublisherId();

    /**
     * Setter for <code>book_for_user.created_at</code>. 条目创建时间
     */
    public IBookForUser setCreatedAt(Timestamp value);

    /**
     * Getter for <code>book_for_user.created_at</code>. 条目创建时间
     */
    public Timestamp getCreatedAt();

    /**
     * Setter for <code>book_for_user.num_total</code>. 书籍总数
     */
    public IBookForUser setNumTotal(Integer value);

    /**
     * Getter for <code>book_for_user.num_total</code>. 书籍总数
     */
    public Integer getNumTotal();

    /**
     * Setter for <code>book_for_user.num_available</code>. 可用书籍数
     */
    public IBookForUser setNumAvailable(Integer value);

    /**
     * Getter for <code>book_for_user.num_available</code>. 可用书籍数
     */
    public Integer getNumAvailable();

    /**
     * Setter for <code>book_for_user.status</code>. 书籍状态
     */
    public IBookForUser setStatus(Byte value);

    /**
     * Getter for <code>book_for_user.status</code>. 书籍状态
     */
    public Byte getStatus();

    /**
     * Setter for <code>book_for_user.publisher_name</code>. 出版社名称
     */
    public IBookForUser setPublisherName(String value);

    /**
     * Getter for <code>book_for_user.publisher_name</code>. 出版社名称
     */
    public String getPublisherName();

    /**
     * Setter for <code>book_for_user.author_id</code>. 作者ID
     */
    public IBookForUser setAuthorId(Long value);

    /**
     * Getter for <code>book_for_user.author_id</code>. 作者ID
     */
    public Long getAuthorId();

    /**
     * Setter for <code>book_for_user.author_name</code>.
     */
    public IBookForUser setAuthorName(String value);

    /**
     * Getter for <code>book_for_user.author_name</code>.
     */
    public String getAuthorName();

    /**
     * Setter for <code>book_for_user.author_fullname</code>.
     */
    public IBookForUser setAuthorFullname(String value);

    /**
     * Getter for <code>book_for_user.author_fullname</code>.
     */
    public String getAuthorFullname();

    /**
     * Setter for <code>book_for_user.author_country</code>.
     */
    public IBookForUser setAuthorCountry(String value);

    /**
     * Getter for <code>book_for_user.author_country</code>.
     */
    public String getAuthorCountry();

    /**
     * Setter for <code>book_for_user.creator_uid</code>. 条目创建者UID
     */
    public IBookForUser setCreatorUid(Long value);

    /**
     * Getter for <code>book_for_user.creator_uid</code>. 条目创建者UID
     */
    public Long getCreatorUid();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IBookForUser
     */
    public void from(IBookForUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IBookForUser
     */
    public <E extends IBookForUser> E into(E into);
}
