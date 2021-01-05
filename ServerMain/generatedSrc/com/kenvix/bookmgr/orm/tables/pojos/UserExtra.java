/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IUserExtra;

import javax.annotation.processing.Generated;


/**
 * 用户扩展信息
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserExtra implements IUserExtra {

    private static final long serialVersionUID = -1237498268;

    private Long   uid;
    private Long   phone;
    private Long   cardSerialId;
    private Short  startYear;
    private String department;
    private String comment;

    public UserExtra() {}

    public UserExtra(IUserExtra value) {
        this.uid = value.getUid();
        this.phone = value.getPhone();
        this.cardSerialId = value.getCardSerialId();
        this.startYear = value.getStartYear();
        this.department = value.getDepartment();
        this.comment = value.getComment();
    }

    public UserExtra(
        Long   uid,
        Long   phone,
        Long   cardSerialId,
        Short  startYear,
        String department,
        String comment
    ) {
        this.uid = uid;
        this.phone = phone;
        this.cardSerialId = cardSerialId;
        this.startYear = startYear;
        this.department = department;
        this.comment = comment;
    }

    @Override
    public Long getUid() {
        return this.uid;
    }

    @Override
    public UserExtra setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    @Override
    public Long getPhone() {
        return this.phone;
    }

    @Override
    public UserExtra setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Long getCardSerialId() {
        return this.cardSerialId;
    }

    @Override
    public UserExtra setCardSerialId(Long cardSerialId) {
        this.cardSerialId = cardSerialId;
        return this;
    }

    @Override
    public Short getStartYear() {
        return this.startYear;
    }

    @Override
    public UserExtra setStartYear(Short startYear) {
        this.startYear = startYear;
        return this;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public UserExtra setDepartment(String department) {
        this.department = department;
        return this;
    }

    @Override
    public String getComment() {
        return this.comment;
    }

    @Override
    public UserExtra setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserExtra (");

        sb.append(uid);
        sb.append(", ").append(phone);
        sb.append(", ").append(cardSerialId);
        sb.append(", ").append(startYear);
        sb.append(", ").append(department);
        sb.append(", ").append(comment);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUserExtra from) {
        setUid(from.getUid());
        setPhone(from.getPhone());
        setCardSerialId(from.getCardSerialId());
        setStartYear(from.getStartYear());
        setDepartment(from.getDepartment());
        setComment(from.getComment());
    }

    @Override
    public <E extends IUserExtra> E into(E into) {
        into.from(this);
        return into;
    }
}
