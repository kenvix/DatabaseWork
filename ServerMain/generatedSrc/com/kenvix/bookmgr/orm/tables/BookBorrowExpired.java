/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.tables.records.BookBorrowExpiredRecord;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
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
public class BookBorrowExpired extends TableImpl<BookBorrowExpiredRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>book_borrow_expired</code>
     */
    public static final BookBorrowExpired BOOK_BORROW_EXPIRED = new BookBorrowExpired();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookBorrowExpiredRecord> getRecordType() {
        return BookBorrowExpiredRecord.class;
    }

    /**
     * The column <code>book_borrow_expired.book_id</code>. 书籍ID
     */
    public final TableField<BookBorrowExpiredRecord, Long> BOOK_ID = createField(DSL.name("book_id"), SQLDataType.BIGINT.nullable(false), this, "书籍ID");

    /**
     * The column <code>book_borrow_expired.borrower_uid</code>. 借书人UID
     */
    public final TableField<BookBorrowExpiredRecord, Long> BORROWER_UID = createField(DSL.name("borrower_uid"), SQLDataType.BIGINT.nullable(false), this, "借书人UID");

    /**
     * The column <code>book_borrow_expired.borrowed_at</code>. 借书日期
     */
    public final TableField<BookBorrowExpiredRecord, Timestamp> BORROWED_AT = createField(DSL.name("borrowed_at"), SQLDataType.TIMESTAMP(0).nullable(false).defaultValue(DSL.inline("0000-00-00 00:00:00", SQLDataType.TIMESTAMP)), this, "借书日期");

    /**
     * The column <code>book_borrow_expired.expected_returned_at</code>. 期望的还书日期
     */
    public final TableField<BookBorrowExpiredRecord, Timestamp> EXPECTED_RETURNED_AT = createField(DSL.name("expected_returned_at"), SQLDataType.TIMESTAMP(0).nullable(false).defaultValue(DSL.inline("0000-00-00 00:00:00", SQLDataType.TIMESTAMP)), this, "期望的还书日期");

    /**
     * The column <code>book_borrow_expired.book_title</code>. 书籍标题
     */
    public final TableField<BookBorrowExpiredRecord, String> BOOK_TITLE = createField(DSL.name("book_title"), SQLDataType.VARCHAR(120).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "书籍标题");

    /**
     * The column <code>book_borrow_expired.borrower_email</code>. 电子邮箱
     */
    public final TableField<BookBorrowExpiredRecord, String> BORROWER_EMAIL = createField(DSL.name("borrower_email"), SQLDataType.VARCHAR(60).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "电子邮箱");

    /**
     * The column <code>book_borrow_expired.borrower_real_name</code>. 真实姓名
     */
    public final TableField<BookBorrowExpiredRecord, String> BORROWER_REAL_NAME = createField(DSL.name("borrower_real_name"), SQLDataType.VARCHAR(30).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "真实姓名");

    /**
     * The column <code>book_borrow_expired.borrower_serial_id</code>. 工号/序列号
     */
    public final TableField<BookBorrowExpiredRecord, String> BORROWER_SERIAL_ID = createField(DSL.name("borrower_serial_id"), SQLDataType.VARCHAR(15).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "工号/序列号");

    private BookBorrowExpired(Name alias, Table<BookBorrowExpiredRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookBorrowExpired(Name alias, Table<BookBorrowExpiredRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("VIEW"), TableOptions.view("create view `book_borrow_expired` as "));
    }

    /**
     * Create an aliased <code>book_borrow_expired</code> table reference
     */
    public BookBorrowExpired(String alias) {
        this(DSL.name(alias), BOOK_BORROW_EXPIRED);
    }

    /**
     * Create an aliased <code>book_borrow_expired</code> table reference
     */
    public BookBorrowExpired(Name alias) {
        this(alias, BOOK_BORROW_EXPIRED);
    }

    /**
     * Create a <code>book_borrow_expired</code> table reference
     */
    public BookBorrowExpired() {
        this(DSL.name("book_borrow_expired"), null);
    }

    public <O extends Record> BookBorrowExpired(Table<O> child, ForeignKey<O, BookBorrowExpiredRecord> key) {
        super(child, key, BOOK_BORROW_EXPIRED);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public BookBorrowExpired as(String alias) {
        return new BookBorrowExpired(DSL.name(alias), this);
    }

    @Override
    public BookBorrowExpired as(Name alias) {
        return new BookBorrowExpired(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookBorrowExpired rename(String name) {
        return new BookBorrowExpired(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookBorrowExpired rename(Name name) {
        return new BookBorrowExpired(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Timestamp, Timestamp, String, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
