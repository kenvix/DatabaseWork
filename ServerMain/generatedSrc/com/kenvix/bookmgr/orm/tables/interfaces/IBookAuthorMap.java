/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * 书籍-作者关系映射表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IBookAuthorMap extends Serializable {

    /**
     * Setter for <code>book_author_map.book_id</code>. 书籍ID
     */
    public IBookAuthorMap setBookId(Long value);

    /**
     * Getter for <code>book_author_map.book_id</code>. 书籍ID
     */
    public Long getBookId();

    /**
     * Setter for <code>book_author_map.author_id</code>. 作者ID
     */
    public IBookAuthorMap setAuthorId(Long value);

    /**
     * Getter for <code>book_author_map.author_id</code>. 作者ID
     */
    public Long getAuthorId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IBookAuthorMap
     */
    public void from(IBookAuthorMap from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IBookAuthorMap
     */
    public <E extends IBookAuthorMap> E into(E into);
}