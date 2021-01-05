/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.enums.LogSystemLevel;
import com.kenvix.bookmgr.orm.tables.interfaces.ILogSystem;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;


/**
 * 系统日志
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogSystem implements ILogSystem {

    private static final long serialVersionUID = 1995697257;

    private Long           id;
    private String         source;
    private LogSystemLevel level;
    private Timestamp      time;
    private String         message;
    private String         exception;

    public LogSystem() {}

    public LogSystem(ILogSystem value) {
        this.id = value.getId();
        this.source = value.getSource();
        this.level = value.getLevel();
        this.time = value.getTime();
        this.message = value.getMessage();
        this.exception = value.getException();
    }

    public LogSystem(
        Long           id,
        String         source,
        LogSystemLevel level,
        Timestamp      time,
        String         message,
        String         exception
    ) {
        this.id = id;
        this.source = source;
        this.level = level;
        this.time = time;
        this.message = message;
        this.exception = exception;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public LogSystem setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public LogSystem setSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public LogSystemLevel getLevel() {
        return this.level;
    }

    @Override
    public LogSystem setLevel(LogSystemLevel level) {
        this.level = level;
        return this;
    }

    @Override
    public Timestamp getTime() {
        return this.time;
    }

    @Override
    public LogSystem setTime(Timestamp time) {
        this.time = time;
        return this;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public LogSystem setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String getException() {
        return this.exception;
    }

    @Override
    public LogSystem setException(String exception) {
        this.exception = exception;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LogSystem (");

        sb.append(id);
        sb.append(", ").append(source);
        sb.append(", ").append(level);
        sb.append(", ").append(time);
        sb.append(", ").append(message);
        sb.append(", ").append(exception);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ILogSystem from) {
        setId(from.getId());
        setSource(from.getSource());
        setLevel(from.getLevel());
        setTime(from.getTime());
        setMessage(from.getMessage());
        setException(from.getException());
    }

    @Override
    public <E extends ILogSystem> E into(E into) {
        into.from(this);
        return into;
    }
}
