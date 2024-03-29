/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.interfaces;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * VIEW
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IBookAuthor extends Serializable {

    /**
     * Setter for <code>book_author.book_id</code>. 书籍ID
     */
    public IBookAuthor setBookId(Long value);

    /**
     * Getter for <code>book_author.book_id</code>. 书籍ID
     */
    public Long getBookId();

    /**
     * Setter for <code>book_author.author_id</code>. 作者ID
     */
    public IBookAuthor setAuthorId(Long value);

    /**
     * Getter for <code>book_author.author_id</code>. 作者ID
     */
    public Long getAuthorId();

    /**
     * Setter for <code>book_author.author_name</code>. 作者通用名称，有索引，可重名
     */
    public IBookAuthor setAuthorName(String value);

    /**
     * Getter for <code>book_author.author_name</code>. 作者通用名称，有索引，可重名
     */
    public String getAuthorName();

    /**
     * Setter for <code>book_author.author_fullname</code>. 作者全名
     */
    public IBookAuthor setAuthorFullname(String value);

    /**
     * Getter for <code>book_author.author_fullname</code>. 作者全名
     */
    public String getAuthorFullname();

    /**
     * Setter for <code>book_author.author_country</code>. 作者国籍，使用
ISO 3166-1二位字母代码规范
     */
    public IBookAuthor setAuthorCountry(String value);

    /**
     * Getter for <code>book_author.author_country</code>. 作者国籍，使用
ISO 3166-1二位字母代码规范
     */
    public String getAuthorCountry();

    /**
     * Setter for <code>book_author.author_description</code>. 作者简述
     */
    public IBookAuthor setAuthorDescription(String value);

    /**
     * Getter for <code>book_author.author_description</code>. 作者简述
     */
    public String getAuthorDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IBookAuthor
     */
    public void from(IBookAuthor from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IBookAuthor
     */
    public <E extends IBookAuthor> E into(E into);
}
