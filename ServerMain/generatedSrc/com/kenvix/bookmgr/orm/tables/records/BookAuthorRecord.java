/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.BookAuthor;
import com.kenvix.bookmgr.orm.tables.interfaces.IBookAuthor;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.TableRecordImpl;


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
public class BookAuthorRecord extends TableRecordImpl<BookAuthorRecord> implements Record6<Long, Long, String, String, String, String>, IBookAuthor {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>book_author.book_id</code>. 书籍ID
     */
    @Override
    public BookAuthorRecord setBookId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>book_author.book_id</code>. 书籍ID
     */
    @Override
    public Long getBookId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>book_author.author_id</code>. 作者ID
     */
    @Override
    public BookAuthorRecord setAuthorId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>book_author.author_id</code>. 作者ID
     */
    @Override
    public Long getAuthorId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>book_author.author_name</code>. 作者通用名称，有索引，可重名
     */
    @Override
    public BookAuthorRecord setAuthorName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>book_author.author_name</code>. 作者通用名称，有索引，可重名
     */
    @Override
    public String getAuthorName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>book_author.author_fullname</code>. 作者全名
     */
    @Override
    public BookAuthorRecord setAuthorFullname(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>book_author.author_fullname</code>. 作者全名
     */
    @Override
    public String getAuthorFullname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>book_author.author_country</code>. 作者国籍，使用
ISO 3166-1二位字母代码规范
     */
    @Override
    public BookAuthorRecord setAuthorCountry(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>book_author.author_country</code>. 作者国籍，使用
ISO 3166-1二位字母代码规范
     */
    @Override
    public String getAuthorCountry() {
        return (String) get(4);
    }

    /**
     * Setter for <code>book_author.author_description</code>. 作者简述
     */
    @Override
    public BookAuthorRecord setAuthorDescription(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>book_author.author_description</code>. 作者简述
     */
    @Override
    public String getAuthorDescription() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, Long, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BookAuthor.BOOK_AUTHOR.BOOK_ID;
    }

    @Override
    public Field<Long> field2() {
        return BookAuthor.BOOK_AUTHOR.AUTHOR_ID;
    }

    @Override
    public Field<String> field3() {
        return BookAuthor.BOOK_AUTHOR.AUTHOR_NAME;
    }

    @Override
    public Field<String> field4() {
        return BookAuthor.BOOK_AUTHOR.AUTHOR_FULLNAME;
    }

    @Override
    public Field<String> field5() {
        return BookAuthor.BOOK_AUTHOR.AUTHOR_COUNTRY;
    }

    @Override
    public Field<String> field6() {
        return BookAuthor.BOOK_AUTHOR.AUTHOR_DESCRIPTION;
    }

    @Override
    public Long component1() {
        return getBookId();
    }

    @Override
    public Long component2() {
        return getAuthorId();
    }

    @Override
    public String component3() {
        return getAuthorName();
    }

    @Override
    public String component4() {
        return getAuthorFullname();
    }

    @Override
    public String component5() {
        return getAuthorCountry();
    }

    @Override
    public String component6() {
        return getAuthorDescription();
    }

    @Override
    public Long value1() {
        return getBookId();
    }

    @Override
    public Long value2() {
        return getAuthorId();
    }

    @Override
    public String value3() {
        return getAuthorName();
    }

    @Override
    public String value4() {
        return getAuthorFullname();
    }

    @Override
    public String value5() {
        return getAuthorCountry();
    }

    @Override
    public String value6() {
        return getAuthorDescription();
    }

    @Override
    public BookAuthorRecord value1(Long value) {
        setBookId(value);
        return this;
    }

    @Override
    public BookAuthorRecord value2(Long value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public BookAuthorRecord value3(String value) {
        setAuthorName(value);
        return this;
    }

    @Override
    public BookAuthorRecord value4(String value) {
        setAuthorFullname(value);
        return this;
    }

    @Override
    public BookAuthorRecord value5(String value) {
        setAuthorCountry(value);
        return this;
    }

    @Override
    public BookAuthorRecord value6(String value) {
        setAuthorDescription(value);
        return this;
    }

    @Override
    public BookAuthorRecord values(Long value1, Long value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBookAuthor from) {
        setBookId(from.getBookId());
        setAuthorId(from.getAuthorId());
        setAuthorName(from.getAuthorName());
        setAuthorFullname(from.getAuthorFullname());
        setAuthorCountry(from.getAuthorCountry());
        setAuthorDescription(from.getAuthorDescription());
    }

    @Override
    public <E extends IBookAuthor> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookAuthorRecord
     */
    public BookAuthorRecord() {
        super(BookAuthor.BOOK_AUTHOR);
    }

    /**
     * Create a detached, initialised BookAuthorRecord
     */
    public BookAuthorRecord(Long bookId, Long authorId, String authorName, String authorFullname, String authorCountry, String authorDescription) {
        super(BookAuthor.BOOK_AUTHOR);

        setBookId(bookId);
        setAuthorId(authorId);
        setAuthorName(authorName);
        setAuthorFullname(authorFullname);
        setAuthorCountry(authorCountry);
        setAuthorDescription(authorDescription);
    }
}
