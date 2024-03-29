/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * 出版社
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IPublisher extends Serializable {

    /**
     * Setter for <code>publisher.id</code>. 出版社ID
     */
    public IPublisher setId(Long value);

    /**
     * Getter for <code>publisher.id</code>. 出版社ID
     */
    public Long getId();

    /**
     * Setter for <code>publisher.name</code>. 出版社名称
     */
    public IPublisher setName(String value);

    /**
     * Getter for <code>publisher.name</code>. 出版社名称
     */
    public String getName();

    /**
     * Setter for <code>publisher.description</code>. 出版社简介
     */
    public IPublisher setDescription(String value);

    /**
     * Getter for <code>publisher.description</code>. 出版社简介
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IPublisher
     */
    public void from(IPublisher from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IPublisher
     */
    public <E extends IPublisher> E into(E into);
}
