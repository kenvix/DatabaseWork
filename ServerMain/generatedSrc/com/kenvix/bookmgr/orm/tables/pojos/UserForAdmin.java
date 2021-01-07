/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IUserForAdmin;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;


/**
 * VIEW
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserForAdmin implements IUserForAdmin {

    private static final long serialVersionUID = -1883771226;

    private Long      uid;
    private String    serialId;
    private String    email;
    private String    realName;
    private String    password;
    private Byte      accessLevel;
    private String    accessLevelDescription;
    private Timestamp createdAt;
    private Long      phone;
    private Integer   money;
    private Long      cardSerialId;
    private Short     startYear;
    private String    department;
    private String    comment;
    private String    ipCreation;
    private String    ipLogin;

    public UserForAdmin() {}

    public UserForAdmin(IUserForAdmin value) {
        this.uid = value.getUid();
        this.serialId = value.getSerialId();
        this.email = value.getEmail();
        this.realName = value.getRealName();
        this.password = value.getPassword();
        this.accessLevel = value.getAccessLevel();
        this.accessLevelDescription = value.getAccessLevelDescription();
        this.createdAt = value.getCreatedAt();
        this.phone = value.getPhone();
        this.money = value.getMoney();
        this.cardSerialId = value.getCardSerialId();
        this.startYear = value.getStartYear();
        this.department = value.getDepartment();
        this.comment = value.getComment();
        this.ipCreation = value.getIpCreation();
        this.ipLogin = value.getIpLogin();
    }

    public UserForAdmin(
        Long      uid,
        String    serialId,
        String    email,
        String    realName,
        String    password,
        Byte      accessLevel,
        String    accessLevelDescription,
        Timestamp createdAt,
        Long      phone,
        Integer   money,
        Long      cardSerialId,
        Short     startYear,
        String    department,
        String    comment,
        String    ipCreation,
        String    ipLogin
    ) {
        this.uid = uid;
        this.serialId = serialId;
        this.email = email;
        this.realName = realName;
        this.password = password;
        this.accessLevel = accessLevel;
        this.accessLevelDescription = accessLevelDescription;
        this.createdAt = createdAt;
        this.phone = phone;
        this.money = money;
        this.cardSerialId = cardSerialId;
        this.startYear = startYear;
        this.department = department;
        this.comment = comment;
        this.ipCreation = ipCreation;
        this.ipLogin = ipLogin;
    }

    @Override
    public Long getUid() {
        return this.uid;
    }

    @Override
    public UserForAdmin setUid(Long uid) {
        this.uid = uid;
        return this;
    }

    @Override
    public String getSerialId() {
        return this.serialId;
    }

    @Override
    public UserForAdmin setSerialId(String serialId) {
        this.serialId = serialId;
        return this;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public UserForAdmin setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getRealName() {
        return this.realName;
    }

    @Override
    public UserForAdmin setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public UserForAdmin setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public Byte getAccessLevel() {
        return this.accessLevel;
    }

    @Override
    public UserForAdmin setAccessLevel(Byte accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    @Override
    public String getAccessLevelDescription() {
        return this.accessLevelDescription;
    }

    @Override
    public UserForAdmin setAccessLevelDescription(String accessLevelDescription) {
        this.accessLevelDescription = accessLevelDescription;
        return this;
    }

    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public UserForAdmin setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public Long getPhone() {
        return this.phone;
    }

    @Override
    public UserForAdmin setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Integer getMoney() {
        return this.money;
    }

    @Override
    public UserForAdmin setMoney(Integer money) {
        this.money = money;
        return this;
    }

    @Override
    public Long getCardSerialId() {
        return this.cardSerialId;
    }

    @Override
    public UserForAdmin setCardSerialId(Long cardSerialId) {
        this.cardSerialId = cardSerialId;
        return this;
    }

    @Override
    public Short getStartYear() {
        return this.startYear;
    }

    @Override
    public UserForAdmin setStartYear(Short startYear) {
        this.startYear = startYear;
        return this;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public UserForAdmin setDepartment(String department) {
        this.department = department;
        return this;
    }

    @Override
    public String getComment() {
        return this.comment;
    }

    @Override
    public UserForAdmin setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String getIpCreation() {
        return this.ipCreation;
    }

    @Override
    public UserForAdmin setIpCreation(String ipCreation) {
        this.ipCreation = ipCreation;
        return this;
    }

    @Override
    public String getIpLogin() {
        return this.ipLogin;
    }

    @Override
    public UserForAdmin setIpLogin(String ipLogin) {
        this.ipLogin = ipLogin;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserForAdmin (");

        sb.append(uid);
        sb.append(", ").append(serialId);
        sb.append(", ").append(email);
        sb.append(", ").append(realName);
        sb.append(", ").append(password);
        sb.append(", ").append(accessLevel);
        sb.append(", ").append(accessLevelDescription);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(phone);
        sb.append(", ").append(money);
        sb.append(", ").append(cardSerialId);
        sb.append(", ").append(startYear);
        sb.append(", ").append(department);
        sb.append(", ").append(comment);
        sb.append(", ").append(ipCreation);
        sb.append(", ").append(ipLogin);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUserForAdmin from) {
        setUid(from.getUid());
        setSerialId(from.getSerialId());
        setEmail(from.getEmail());
        setRealName(from.getRealName());
        setPassword(from.getPassword());
        setAccessLevel(from.getAccessLevel());
        setAccessLevelDescription(from.getAccessLevelDescription());
        setCreatedAt(from.getCreatedAt());
        setPhone(from.getPhone());
        setMoney(from.getMoney());
        setCardSerialId(from.getCardSerialId());
        setStartYear(from.getStartYear());
        setDepartment(from.getDepartment());
        setComment(from.getComment());
        setIpCreation(from.getIpCreation());
        setIpLogin(from.getIpLogin());
    }

    @Override
    public <E extends IUserForAdmin> E into(E into) {
        into.from(this);
        return into;
    }
}
