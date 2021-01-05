/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm;


import com.kenvix.bookmgr.orm.routines.BookBorrow;
import com.kenvix.bookmgr.orm.routines.RaiseError;
import com.kenvix.bookmgr.orm.routines.UserAdd;
import com.kenvix.bookmgr.orm.routines.UserDelete;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;


/**
 * Convenience access to all stored procedures and functions in 
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>book_borrow</code>
     */
    public static void bookBorrow(Configuration configuration, Long borrowerUidV, Long bookIdV, Timestamp expectedReturnedAtV) {
        BookBorrow p = new BookBorrow();
        p.setBorrowerUidV(borrowerUidV);
        p.setBookIdV(bookIdV);
        p.setExpectedReturnedAtV(expectedReturnedAtV);

        p.execute(configuration);
    }

    /**
     * Call <code>raise_error</code>
     */
    public static void raiseError(Configuration configuration, String errorMessage, Integer errorId) {
        RaiseError p = new RaiseError();
        p.setErrorMessage(errorMessage);
        p.setErrorId(errorId);

        p.execute(configuration);
    }

    /**
     * Call <code>user_add</code>
     */
    public static void userAdd(Configuration configuration, String vSerialId, String vEmail, String vRealName, String vPassword, Byte vAccessLevel, String vIpCreation) {
        UserAdd p = new UserAdd();
        p.setVSerialId(vSerialId);
        p.setVEmail(vEmail);
        p.setVRealName(vRealName);
        p.setVPassword(vPassword);
        p.setVAccessLevel(vAccessLevel);
        p.setVIpCreation(vIpCreation);

        p.execute(configuration);
    }

    /**
     * Call <code>user_delete</code>
     */
    public static void userDelete(Configuration configuration, Long uidV) {
        UserDelete p = new UserDelete();
        p.setUidV(uidV);

        p.execute(configuration);
    }
}
