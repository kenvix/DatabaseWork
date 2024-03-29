/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.tables.records.BookForUserRecord;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row18;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class BookForUser extends TableImpl<BookForUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>book_for_user</code>
     */
    public static final BookForUser BOOK_FOR_USER = new BookForUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookForUserRecord> getRecordType() {
        return BookForUserRecord.class;
    }

    /**
     * The column <code>book_for_user.id</code>. 书本ID
     */
    public final TableField<BookForUserRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BIGINT)), this, "书本ID");

    /**
     * The column <code>book_for_user.title</code>. 书籍标题
     */
    public final TableField<BookForUserRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(120).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "书籍标题");

    /**
     * The column <code>book_for_user.description</code>. 书籍概述
     */
    public final TableField<BookForUserRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.CLOB.nullable(false), this, "书籍概述");

    /**
     * The column <code>book_for_user.publisher_id</code>. 出版社ID
     */
    public final TableField<BookForUserRecord, Long> PUBLISHER_ID = createField(DSL.name("publisher_id"), SQLDataType.BIGINT.nullable(false), this, "出版社ID");

    /**
     * The column <code>book_for_user.created_at</code>. 条目创建时间
     */
    public final TableField<BookForUserRecord, Timestamp> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMP(0).nullable(false).defaultValue(DSL.inline("0000-00-00 00:00:00", SQLDataType.TIMESTAMP)), this, "条目创建时间");

    /**
     * The column <code>book_for_user.num_total</code>. 书籍总数
     */
    public final TableField<BookForUserRecord, Integer> NUM_TOTAL = createField(DSL.name("num_total"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "书籍总数");

    /**
     * The column <code>book_for_user.num_available</code>. 可用书籍数
     */
    public final TableField<BookForUserRecord, Integer> NUM_AVAILABLE = createField(DSL.name("num_available"), SQLDataType.INTEGER.nullable(false), this, "可用书籍数");

    /**
     * The column <code>book_for_user.status</code>. 书籍状态
     */
    public final TableField<BookForUserRecord, Byte> STATUS = createField(DSL.name("status"), SQLDataType.TINYINT.nullable(false), this, "书籍状态");

    /**
     * The column <code>book_for_user.publisher_name</code>. 出版社名称
     */
    public final TableField<BookForUserRecord, String> PUBLISHER_NAME = createField(DSL.name("publisher_name"), SQLDataType.VARCHAR(80).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "出版社名称");

    /**
     * The column <code>book_for_user.author_id</code>. 作者ID
     */
    public final TableField<BookForUserRecord, Long> AUTHOR_ID = createField(DSL.name("author_id"), SQLDataType.BIGINT, this, "作者ID");

    /**
     * The column <code>book_for_user.author_name</code>.
     */
    public final TableField<BookForUserRecord, String> AUTHOR_NAME = createField(DSL.name("author_name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>book_for_user.author_fullname</code>.
     */
    public final TableField<BookForUserRecord, String> AUTHOR_FULLNAME = createField(DSL.name("author_fullname"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>book_for_user.author_country</code>.
     */
    public final TableField<BookForUserRecord, String> AUTHOR_COUNTRY = createField(DSL.name("author_country"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>book_for_user.creator_uid</code>. 条目创建者UID
     */
    public final TableField<BookForUserRecord, Long> CREATOR_UID = createField(DSL.name("creator_uid"), SQLDataType.BIGINT.nullable(false), this, "条目创建者UID");

    /**
     * The column <code>book_for_user.type_id</code>. 图书类型ID
     */
    public final TableField<BookForUserRecord, Integer> TYPE_ID = createField(DSL.name("type_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "图书类型ID");

    /**
     * The column <code>book_for_user.type_name</code>. 类目名称
     */
    public final TableField<BookForUserRecord, String> TYPE_NAME = createField(DSL.name("type_name"), SQLDataType.VARCHAR(50).nullable(false), this, "类目名称");

    /**
     * The column <code>book_for_user.status_description</code>.
     */
    public final TableField<BookForUserRecord, String> STATUS_DESCRIPTION = createField(DSL.name("status_description"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>book_for_user.isbn</code>. 国际标准书号 (International Standard Book Number)
     */
    public final TableField<BookForUserRecord, String> ISBN = createField(DSL.name("isbn"), SQLDataType.VARCHAR(40).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "国际标准书号 (International Standard Book Number)");

    private BookForUser(Name alias, Table<BookForUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookForUser(Name alias, Table<BookForUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"), TableOptions.view("create view `book_for_user` as "));
    }

    /**
     * Create an aliased <code>book_for_user</code> table reference
     */
    public BookForUser(String alias) {
        this(DSL.name(alias), BOOK_FOR_USER);
    }

    /**
     * Create an aliased <code>book_for_user</code> table reference
     */
    public BookForUser(Name alias) {
        this(alias, BOOK_FOR_USER);
    }

    /**
     * Create a <code>book_for_user</code> table reference
     */
    public BookForUser() {
        this(DSL.name("book_for_user"), null);
    }

    public <O extends Record> BookForUser(Table<O> child, ForeignKey<O, BookForUserRecord> key) {
        super(child, key, BOOK_FOR_USER);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public BookForUser as(String alias) {
        return new BookForUser(DSL.name(alias), this);
    }

    @Override
    public BookForUser as(Name alias) {
        return new BookForUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookForUser rename(String name) {
        return new BookForUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookForUser rename(Name name) {
        return new BookForUser(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row18<Long, String, String, Long, Timestamp, Integer, Integer, Byte, String, Long, String, String, String, Long, Integer, String, String, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }
}
