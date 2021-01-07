/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm;


import com.kenvix.bookmgr.orm.routines.BookBorrow;
import com.kenvix.bookmgr.orm.routines.BookBorrowRenew;
import com.kenvix.bookmgr.orm.routines.BookBorrowReturn;
import com.kenvix.bookmgr.orm.routines.BookBorrowUnreturnedNum;
import com.kenvix.bookmgr.orm.routines.BookBorrowerHasExpired;
import com.kenvix.bookmgr.orm.routines.GetLastInsertId;
import com.kenvix.bookmgr.orm.routines.GetSetting;
import com.kenvix.bookmgr.orm.routines.RaiseError;
import com.kenvix.bookmgr.orm.routines.Test;
import com.kenvix.bookmgr.orm.routines.UserAdd;
import com.kenvix.bookmgr.orm.routines.UserDelete;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.Field;


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
    public static Long bookBorrow(Configuration configuration, Long bookIdV, Long borrowerUidV, Timestamp expectedReturnedAtV) {
        BookBorrow p = new BookBorrow();
        p.setBookIdV(bookIdV);
        p.setBorrowerUidV(borrowerUidV);
        p.setExpectedReturnedAtV(expectedReturnedAtV);

        p.execute(configuration);
        return p.getInsertId();
    }

    /**
     * Call <code>book_borrow_renew</code>
     */
    public static Timestamp bookBorrowRenew(Configuration configuration, Long borrowId) {
        BookBorrowRenew p = new BookBorrowRenew();
        p.setBorrowId(borrowId);

        p.execute(configuration);
        return p.getNextExpectedReturn();
    }

    /**
     * Call <code>book_borrow_return</code>
     */
    public static void bookBorrowReturn(Configuration configuration, Long borrowId, Integer requiredMoney) {
        BookBorrowReturn p = new BookBorrowReturn();
        p.setBorrowId(borrowId);
        p.setRequiredMoney(requiredMoney);

        p.execute(configuration);
    }

    /**
     * Call <code>book_borrow_unreturned_num</code>
     */
    public static Integer bookBorrowUnreturnedNum(Configuration configuration, Long borrowerUid) {
        BookBorrowUnreturnedNum f = new BookBorrowUnreturnedNum();
        f.setBorrowerUid(borrowerUid);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>book_borrow_unreturned_num</code> as a field.
     */
    public static Field<Integer> bookBorrowUnreturnedNum(Long borrowerUid) {
        BookBorrowUnreturnedNum f = new BookBorrowUnreturnedNum();
        f.setBorrowerUid(borrowerUid);

        return f.asField();
    }

    /**
     * Get <code>book_borrow_unreturned_num</code> as a field.
     */
    public static Field<Integer> bookBorrowUnreturnedNum(Field<Long> borrowerUid) {
        BookBorrowUnreturnedNum f = new BookBorrowUnreturnedNum();
        f.setBorrowerUid(borrowerUid);

        return f.asField();
    }

    /**
     * Call <code>book_borrower_has_expired</code>
     */
    public static Boolean bookBorrowerHasExpired(Configuration configuration, Long userUid) {
        BookBorrowerHasExpired f = new BookBorrowerHasExpired();
        f.setUserUid(userUid);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>book_borrower_has_expired</code> as a field.
     */
    public static Field<Boolean> bookBorrowerHasExpired(Long userUid) {
        BookBorrowerHasExpired f = new BookBorrowerHasExpired();
        f.setUserUid(userUid);

        return f.asField();
    }

    /**
     * Get <code>book_borrower_has_expired</code> as a field.
     */
    public static Field<Boolean> bookBorrowerHasExpired(Field<Long> userUid) {
        BookBorrowerHasExpired f = new BookBorrowerHasExpired();
        f.setUserUid(userUid);

        return f.asField();
    }

    /**
     * Call <code>get_last_insert_id</code>
     */
    public static Long getLastInsertId(Configuration configuration) {
        GetLastInsertId f = new GetLastInsertId();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>get_last_insert_id</code> as a field.
     */
    public static Field<Long> getLastInsertId() {
        GetLastInsertId f = new GetLastInsertId();

        return f.asField();
    }

    /**
     * Call <code>get_setting</code>
     */
    public static String getSetting(Configuration configuration, String keyV) {
        GetSetting f = new GetSetting();
        f.setKeyV(keyV);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>get_setting</code> as a field.
     */
    public static Field<String> getSetting(String keyV) {
        GetSetting f = new GetSetting();
        f.setKeyV(keyV);

        return f.asField();
    }

    /**
     * Get <code>get_setting</code> as a field.
     */
    public static Field<String> getSetting(Field<String> keyV) {
        GetSetting f = new GetSetting();
        f.setKeyV(keyV);

        return f.asField();
    }

    /**
     * Call <code>raise_error</code>
     */
    public static void raiseError(Configuration configuration, String errorMessage, Short errorId) {
        RaiseError p = new RaiseError();
        p.setErrorMessage(errorMessage);
        p.setErrorId(errorId);

        p.execute(configuration);
    }

    /**
     * Call <code>test</code>
     */
    public static Short test(Configuration configuration) {
        Test p = new Test();

        p.execute(configuration);
        return p.getMaxRenewNum();
    }

    /**
     * Call <code>user_add</code>
     */
    public static Long userAdd(Configuration configuration, String vSerialId, String vEmail, String vRealName, String vPassword, Byte vAccessLevel, String vIpCreation) {
        UserAdd p = new UserAdd();
        p.setVSerialId(vSerialId);
        p.setVEmail(vEmail);
        p.setVRealName(vRealName);
        p.setVPassword(vPassword);
        p.setVAccessLevel(vAccessLevel);
        p.setVIpCreation(vIpCreation);

        p.execute(configuration);
        return p.getInsertId();
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
