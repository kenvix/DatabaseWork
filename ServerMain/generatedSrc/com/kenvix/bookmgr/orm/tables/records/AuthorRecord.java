/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.Author;
import com.kenvix.bookmgr.orm.tables.interfaces.IAuthor;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 作者表
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorRecord extends UpdatableRecordImpl<AuthorRecord> implements Record5<Long, String, String, String, String>, IAuthor {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>author.id</code>. ID
     */
    @Override
    public AuthorRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>author.id</code>. ID
     */
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>author.name</code>. 作者通用名称，有索引，可重名
     */
    @Override
    public AuthorRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>author.name</code>. 作者通用名称，有索引，可重名
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>author.fullname</code>. 作者全名
     */
    @Override
    public AuthorRecord setFullname(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>author.fullname</code>. 作者全名
     */
    @Override
    public String getFullname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>author.country</code>. 作者国籍，使用
ISO 3166-1二位字母代码规范
     */
    @Override
    public AuthorRecord setCountry(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>author.country</code>. 作者国籍，使用
ISO 3166-1二位字母代码规范
     */
    @Override
    public String getCountry() {
        return (String) get(3);
    }

    /**
     * Setter for <code>author.description</code>. 作者简述
     */
    @Override
    public AuthorRecord setDescription(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>author.description</code>. 作者简述
     */
    @Override
    public String getDescription() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Author.AUTHOR.ID;
    }

    @Override
    public Field<String> field2() {
        return Author.AUTHOR.NAME;
    }

    @Override
    public Field<String> field3() {
        return Author.AUTHOR.FULLNAME;
    }

    @Override
    public Field<String> field4() {
        return Author.AUTHOR.COUNTRY;
    }

    @Override
    public Field<String> field5() {
        return Author.AUTHOR.DESCRIPTION;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getFullname();
    }

    @Override
    public String component4() {
        return getCountry();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getFullname();
    }

    @Override
    public String value4() {
        return getCountry();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public AuthorRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public AuthorRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public AuthorRecord value3(String value) {
        setFullname(value);
        return this;
    }

    @Override
    public AuthorRecord value4(String value) {
        setCountry(value);
        return this;
    }

    @Override
    public AuthorRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public AuthorRecord values(Long value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IAuthor from) {
        setId(from.getId());
        setName(from.getName());
        setFullname(from.getFullname());
        setCountry(from.getCountry());
        setDescription(from.getDescription());
    }

    @Override
    public <E extends IAuthor> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AuthorRecord
     */
    public AuthorRecord() {
        super(Author.AUTHOR);
    }

    /**
     * Create a detached, initialised AuthorRecord
     */
    public AuthorRecord(Long id, String name, String fullname, String country, String description) {
        super(Author.AUTHOR);

        setId(id);
        setName(name);
        setFullname(fullname);
        setCountry(country);
        setDescription(description);
    }
}
