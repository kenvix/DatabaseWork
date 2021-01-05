/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.routines;


import com.kenvix.bookmgr.orm.DefaultSchema;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookBorrow extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 371272190;

    /**
     * The parameter <code>book_borrow.borrower_uid_v</code>.
     */
    public static final Parameter<Long> BORROWER_UID_V = Internal.createParameter("borrower_uid_v", org.jooq.impl.SQLDataType.BIGINT, false, false);

    /**
     * The parameter <code>book_borrow.book_id_v</code>.
     */
    public static final Parameter<Long> BOOK_ID_V = Internal.createParameter("book_id_v", org.jooq.impl.SQLDataType.BIGINT, false, false);

    /**
     * The parameter <code>book_borrow.expected_returned_at_v</code>.
     */
    public static final Parameter<Timestamp> EXPECTED_RETURNED_AT_V = Internal.createParameter("expected_returned_at_v", org.jooq.impl.SQLDataType.TIMESTAMP, false, false);

    /**
     * Create a new routine call instance
     */
    public BookBorrow() {
        super("book_borrow", DefaultSchema.DEFAULT_SCHEMA);

        addInParameter(BORROWER_UID_V);
        addInParameter(BOOK_ID_V);
        addInParameter(EXPECTED_RETURNED_AT_V);
    }

    /**
     * Set the <code>borrower_uid_v</code> parameter IN value to the routine
     */
    public void setBorrowerUidV(Long value) {
        setValue(BORROWER_UID_V, value);
    }

    /**
     * Set the <code>book_id_v</code> parameter IN value to the routine
     */
    public void setBookIdV(Long value) {
        setValue(BOOK_ID_V, value);
    }

    /**
     * Set the <code>expected_returned_at_v</code> parameter IN value to the routine
     */
    public void setExpectedReturnedAtV(Timestamp value) {
        setValue(EXPECTED_RETURNED_AT_V, value);
    }
}
