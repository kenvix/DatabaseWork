/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * 书籍状态表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IBookStatus extends Serializable {

    /**
     * Setter for <code>book_status.id</code>.
     */
    public IBookStatus setId(Byte value);

    /**
     * Getter for <code>book_status.id</code>.
     */
    public Byte getId();

    /**
     * Setter for <code>book_status.description</code>.
     */
    public IBookStatus setDescription(String value);

    /**
     * Getter for <code>book_status.description</code>.
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IBookStatus
     */
    public void from(IBookStatus from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IBookStatus
     */
    public <E extends IBookStatus> E into(E into);
}
