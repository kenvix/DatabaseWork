/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.BookStatusRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class BookStatus extends TableImpl<BookStatusRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>book_status</code>
     */
    public static final BookStatus BOOK_STATUS = new BookStatus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookStatusRecord> getRecordType() {
        return BookStatusRecord.class;
    }

    /**
     * The column <code>book_status.id</code>.
     */
    public final TableField<BookStatusRecord, Byte> ID = createField(DSL.name("id"), SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>book_status.description</code>.
     */
    public final TableField<BookStatusRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(10), this, "");

    private BookStatus(Name alias, Table<BookStatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookStatus(Name alias, Table<BookStatusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("书籍状态表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>book_status</code> table reference
     */
    public BookStatus(String alias) {
        this(DSL.name(alias), BOOK_STATUS);
    }

    /**
     * Create an aliased <code>book_status</code> table reference
     */
    public BookStatus(Name alias) {
        this(alias, BOOK_STATUS);
    }

    /**
     * Create a <code>book_status</code> table reference
     */
    public BookStatus() {
        this(DSL.name("book_status"), null);
    }

    public <O extends Record> BookStatus(Table<O> child, ForeignKey<O, BookStatusRecord> key) {
        super(child, key, BOOK_STATUS);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<BookStatusRecord> getPrimaryKey() {
        return Keys.KEY_BOOK_STATUS_PRIMARY;
    }

    @Override
    public List<UniqueKey<BookStatusRecord>> getKeys() {
        return Arrays.<UniqueKey<BookStatusRecord>>asList(Keys.KEY_BOOK_STATUS_PRIMARY);
    }

    @Override
    public BookStatus as(String alias) {
        return new BookStatus(DSL.name(alias), this);
    }

    @Override
    public BookStatus as(Name alias) {
        return new BookStatus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookStatus rename(String name) {
        return new BookStatus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookStatus rename(Name name) {
        return new BookStatus(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Byte, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
