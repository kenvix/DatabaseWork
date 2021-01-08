/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IBookType;

import javax.annotation.processing.Generated;


/**
 * 图书类目
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookType implements IBookType {

    private static final long serialVersionUID = 262221278;

    private Integer id;
    private String  name;
    private Integer parentId;

    public BookType() {}

    public BookType(IBookType value) {
        this.id = value.getId();
        this.name = value.getName();
        this.parentId = value.getParentId();
    }

    public BookType(
        Integer id,
        String  name,
        Integer parentId
    ) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public BookType setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BookType setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Integer getParentId() {
        return this.parentId;
    }

    @Override
    public BookType setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BookType (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(parentId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBookType from) {
        setId(from.getId());
        setName(from.getName());
        setParentId(from.getParentId());
    }

    @Override
    public <E extends IBookType> E into(E into) {
        into.from(this);
        return into;
    }
}
