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
public class BookBorrowRenew extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = -774064303;

    /**
     * The parameter <code>book_borrow_renew.borrow_id</code>.
     */
    public static final Parameter<Long> BORROW_ID = Internal.createParameter("borrow_id", org.jooq.impl.SQLDataType.BIGINT, false, false);

    /**
     * The parameter <code>book_borrow_renew.next_expected_return</code>.
     */
    public static final Parameter<Timestamp> NEXT_EXPECTED_RETURN = Internal.createParameter("next_expected_return", org.jooq.impl.SQLDataType.TIMESTAMP, false, false);

    /**
     * Create a new routine call instance
     */
    public BookBorrowRenew() {
        super("book_borrow_renew", DefaultSchema.DEFAULT_SCHEMA);

        addInParameter(BORROW_ID);
        addOutParameter(NEXT_EXPECTED_RETURN);
    }

    /**
     * Set the <code>borrow_id</code> parameter IN value to the routine
     */
    public void setBorrowId(Long value) {
        setValue(BORROW_ID, value);
    }

    /**
     * Get the <code>next_expected_return</code> parameter OUT value from the routine
     */
    public Timestamp getNextExpectedReturn() {
        return get(NEXT_EXPECTED_RETURN);
    }
}
