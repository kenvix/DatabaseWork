/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IBook;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;


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
public class Book implements IBook {

    private static final long serialVersionUID = 1L;

    private Long      id;
    private Long      creatorUid;
    private Integer   typeId;
    private String    title;
    private String    description;
    private Long      publisherId;
    private Timestamp createdAt;
    private Integer   numTotal;
    private Integer   numAvailable;
    private String    isbn;
    private Byte      status;

    public Book() {}

    public Book(IBook value) {
        this.id = value.getId();
        this.creatorUid = value.getCreatorUid();
        this.typeId = value.getTypeId();
        this.title = value.getTitle();
        this.description = value.getDescription();
        this.publisherId = value.getPublisherId();
        this.createdAt = value.getCreatedAt();
        this.numTotal = value.getNumTotal();
        this.numAvailable = value.getNumAvailable();
        this.isbn = value.getIsbn();
        this.status = value.getStatus();
    }

    public Book(
        Long      id,
        Long      creatorUid,
        Integer   typeId,
        String    title,
        String    description,
        Long      publisherId,
        Timestamp createdAt,
        Integer   numTotal,
        Integer   numAvailable,
        String    isbn,
        Byte      status
    ) {
        this.id = id;
        this.creatorUid = creatorUid;
        this.typeId = typeId;
        this.title = title;
        this.description = description;
        this.publisherId = publisherId;
        this.createdAt = createdAt;
        this.numTotal = numTotal;
        this.numAvailable = numAvailable;
        this.isbn = isbn;
        this.status = status;
    }

    /**
     * Getter for <code>book.id</code>. 书本ID
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>book.id</code>. 书本ID
     */
    @Override
    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>book.creator_uid</code>. 条目创建者UID
     */
    @Override
    public Long getCreatorUid() {
        return this.creatorUid;
    }

    /**
     * Setter for <code>book.creator_uid</code>. 条目创建者UID
     */
    @Override
    public Book setCreatorUid(Long creatorUid) {
        this.creatorUid = creatorUid;
        return this;
    }

    /**
     * Getter for <code>book.type_id</code>. 图书类型ID
     */
    @Override
    public Integer getTypeId() {
        return this.typeId;
    }

    /**
     * Setter for <code>book.type_id</code>. 图书类型ID
     */
    @Override
    public Book setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    /**
     * Getter for <code>book.title</code>. 书籍标题
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for <code>book.title</code>. 书籍标题
     */
    @Override
    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Getter for <code>book.description</code>. 书籍概述
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>book.description</code>. 书籍概述
     */
    @Override
    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>book.publisher_id</code>. 出版社ID
     */
    @Override
    public Long getPublisherId() {
        return this.publisherId;
    }

    /**
     * Setter for <code>book.publisher_id</code>. 出版社ID
     */
    @Override
    public Book setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
        return this;
    }

    /**
     * Getter for <code>book.created_at</code>. 条目创建时间
     */
    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>book.created_at</code>. 条目创建时间
     */
    @Override
    public Book setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>book.num_total</code>. 书籍总数
     */
    @Override
    public Integer getNumTotal() {
        return this.numTotal;
    }

    /**
     * Setter for <code>book.num_total</code>. 书籍总数
     */
    @Override
    public Book setNumTotal(Integer numTotal) {
        this.numTotal = numTotal;
        return this;
    }

    /**
     * Getter for <code>book.num_available</code>. 可用书籍数
     */
    @Override
    public Integer getNumAvailable() {
        return this.numAvailable;
    }

    /**
     * Setter for <code>book.num_available</code>. 可用书籍数
     */
    @Override
    public Book setNumAvailable(Integer numAvailable) {
        this.numAvailable = numAvailable;
        return this;
    }

    /**
     * Getter for <code>book.isbn</code>. 国际标准书号 (International Standard Book Number)
     */
    @Override
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Setter for <code>book.isbn</code>. 国际标准书号 (International Standard Book Number)
     */
    @Override
    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    /**
     * Getter for <code>book.status</code>. 书籍状态
     */
    @Override
    public Byte getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>book.status</code>. 书籍状态
     */
    @Override
    public Book setStatus(Byte status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book (");

        sb.append(id);
        sb.append(", ").append(creatorUid);
        sb.append(", ").append(typeId);
        sb.append(", ").append(title);
        sb.append(", ").append(description);
        sb.append(", ").append(publisherId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(numTotal);
        sb.append(", ").append(numAvailable);
        sb.append(", ").append(isbn);
        sb.append(", ").append(status);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBook from) {
        setId(from.getId());
        setCreatorUid(from.getCreatorUid());
        setTypeId(from.getTypeId());
        setTitle(from.getTitle());
        setDescription(from.getDescription());
        setPublisherId(from.getPublisherId());
        setCreatedAt(from.getCreatedAt());
        setNumTotal(from.getNumTotal());
        setNumAvailable(from.getNumAvailable());
        setIsbn(from.getIsbn());
        setStatus(from.getStatus());
    }

    @Override
    public <E extends IBook> E into(E into) {
        into.from(this);
        return into;
    }
}
