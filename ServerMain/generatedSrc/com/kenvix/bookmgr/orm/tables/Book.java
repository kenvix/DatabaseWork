/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Indexes;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.BookRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;


/**
 * 书籍表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Book extends TableImpl<BookRecord> {

    private static final long serialVersionUID = 1684961752;

    /**
     * The reference instance of <code>book</code>
     */
    public static final Book BOOK = new Book();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookRecord> getRecordType() {
        return BookRecord.class;
    }

    /**
     * The column <code>book.id</code>. 书本ID
     */
    public final TableField<BookRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "书本ID");

    /**
     * The column <code>book.creator_uid</code>. 条目创建者UID
     */
    public final TableField<BookRecord, Long> CREATOR_UID = createField(DSL.name("creator_uid"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "条目创建者UID");

    /**
     * The column <code>book.title</code>. 书籍标题
     */
    public final TableField<BookRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(120).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "书籍标题");

    /**
     * The column <code>book.description</code>. 书籍概述
     */
    public final TableField<BookRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "书籍概述");

    /**
     * The column <code>book.publisher_id</code>. 出版社ID
     */
    public final TableField<BookRecord, Long> PUBLISHER_ID = createField(DSL.name("publisher_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "出版社ID");

    /**
     * The column <code>book.created_at</code>. 条目创建时间
     */
    public final TableField<BookRecord, Timestamp> CREATED_AT = createField(DSL.name("created_at"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "条目创建时间");

    /**
     * The column <code>book.num_total</code>. 书籍总数
     */
    public final TableField<BookRecord, Integer> NUM_TOTAL = createField(DSL.name("num_total"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.INTEGER)), this, "书籍总数");

    /**
     * The column <code>book.num_available</code>. 可用书籍数
     */
    public final TableField<BookRecord, Integer> NUM_AVAILABLE = createField(DSL.name("num_available"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "可用书籍数");

    /**
     * The column <code>book.status</code>. 书籍状态
     */
    public final TableField<BookRecord, Byte> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "书籍状态");

    /**
     * Create a <code>book</code> table reference
     */
    public Book() {
        this(DSL.name("book"), null);
    }

    /**
     * Create an aliased <code>book</code> table reference
     */
    public Book(String alias) {
        this(DSL.name(alias), BOOK);
    }

    /**
     * Create an aliased <code>book</code> table reference
     */
    public Book(Name alias) {
        this(alias, BOOK);
    }

    private Book(Name alias, Table<BookRecord> aliased) {
        this(alias, aliased, null);
    }

    private Book(Name alias, Table<BookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("书籍表"), TableOptions.table());
    }

    public <O extends Record> Book(Table<O> child, ForeignKey<O, BookRecord> key) {
        super(child, key, BOOK);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BOOK_FK_BOOK_STATUS, Indexes.BOOK_FK_CREATOR_UID, Indexes.BOOK_FK_PUBLISHER_ID);
    }

    @Override
    public Identity<BookRecord, Long> getIdentity() {
        return Keys.IDENTITY_BOOK;
    }

    @Override
    public UniqueKey<BookRecord> getPrimaryKey() {
        return Keys.KEY_BOOK_PRIMARY;
    }

    @Override
    public List<UniqueKey<BookRecord>> getKeys() {
        return Arrays.<UniqueKey<BookRecord>>asList(Keys.KEY_BOOK_PRIMARY);
    }

    @Override
    public List<ForeignKey<BookRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BookRecord, ?>>asList(Keys.FK_CREATOR_UID, Keys.FK_PUBLISHER_ID, Keys.FK_BOOK_STATUS);
    }

    public User user() {
        return new User(this, Keys.FK_CREATOR_UID);
    }

    public Publisher publisher() {
        return new Publisher(this, Keys.FK_PUBLISHER_ID);
    }

    public BookStatus bookStatus() {
        return new BookStatus(this, Keys.FK_BOOK_STATUS);
    }

    @Override
    public List<Check<BookRecord>> getChecks() {
        return Arrays.<Check<BookRecord>>asList(
              Internal.createCheck(this, DSL.name("check_available_book_num"), "(`num_total` >= `num_available`)", true)
        );
    }

    @Override
    public Book as(String alias) {
        return new Book(DSL.name(alias), this);
    }

    @Override
    public Book as(Name alias) {
        return new Book(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(String name) {
        return new Book(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(Name name) {
        return new Book(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Long, String, String, Long, Timestamp, Integer, Integer, Byte> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}