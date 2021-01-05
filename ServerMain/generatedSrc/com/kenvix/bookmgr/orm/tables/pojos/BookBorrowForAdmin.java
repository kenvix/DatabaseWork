/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.pojos;


import com.kenvix.bookmgr.orm.tables.interfaces.IBookBorrowForAdmin;

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
public class BookBorrowForAdmin implements IBookBorrowForAdmin {

    private static final long serialVersionUID = 886524247;

    private Long      bookId;
    private String    bookTitle;
    private Long      borrowerUid;
    private Timestamp borrowedAt;
    private Timestamp expectedReturnedAt;
    private Timestamp actualReturnedAt;
    private String    borrowerRealName;
    private String    borrowerSerialId;

    public BookBorrowForAdmin() {}

    public BookBorrowForAdmin(IBookBorrowForAdmin value) {
        this.bookId = value.getBookId();
        this.bookTitle = value.getBookTitle();
        this.borrowerUid = value.getBorrowerUid();
        this.borrowedAt = value.getBorrowedAt();
        this.expectedReturnedAt = value.getExpectedReturnedAt();
        this.actualReturnedAt = value.getActualReturnedAt();
        this.borrowerRealName = value.getBorrowerRealName();
        this.borrowerSerialId = value.getBorrowerSerialId();
    }

    public BookBorrowForAdmin(
        Long      bookId,
        String    bookTitle,
        Long      borrowerUid,
        Timestamp borrowedAt,
        Timestamp expectedReturnedAt,
        Timestamp actualReturnedAt,
        String    borrowerRealName,
        String    borrowerSerialId
    ) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowerUid = borrowerUid;
        this.borrowedAt = borrowedAt;
        this.expectedReturnedAt = expectedReturnedAt;
        this.actualReturnedAt = actualReturnedAt;
        this.borrowerRealName = borrowerRealName;
        this.borrowerSerialId = borrowerSerialId;
    }

    @Override
    public Long getBookId() {
        return this.bookId;
    }

    @Override
    public BookBorrowForAdmin setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    @Override
    public String getBookTitle() {
        return this.bookTitle;
    }

    @Override
    public BookBorrowForAdmin setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }

    @Override
    public Long getBorrowerUid() {
        return this.borrowerUid;
    }

    @Override
    public BookBorrowForAdmin setBorrowerUid(Long borrowerUid) {
        this.borrowerUid = borrowerUid;
        return this;
    }

    @Override
    public Timestamp getBorrowedAt() {
        return this.borrowedAt;
    }

    @Override
    public BookBorrowForAdmin setBorrowedAt(Timestamp borrowedAt) {
        this.borrowedAt = borrowedAt;
        return this;
    }

    @Override
    public Timestamp getExpectedReturnedAt() {
        return this.expectedReturnedAt;
    }

    @Override
    public BookBorrowForAdmin setExpectedReturnedAt(Timestamp expectedReturnedAt) {
        this.expectedReturnedAt = expectedReturnedAt;
        return this;
    }

    @Override
    public Timestamp getActualReturnedAt() {
        return this.actualReturnedAt;
    }

    @Override
    public BookBorrowForAdmin setActualReturnedAt(Timestamp actualReturnedAt) {
        this.actualReturnedAt = actualReturnedAt;
        return this;
    }

    @Override
    public String getBorrowerRealName() {
        return this.borrowerRealName;
    }

    @Override
    public BookBorrowForAdmin setBorrowerRealName(String borrowerRealName) {
        this.borrowerRealName = borrowerRealName;
        return this;
    }

    @Override
    public String getBorrowerSerialId() {
        return this.borrowerSerialId;
    }

    @Override
    public BookBorrowForAdmin setBorrowerSerialId(String borrowerSerialId) {
        this.borrowerSerialId = borrowerSerialId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BookBorrowForAdmin (");

        sb.append(bookId);
        sb.append(", ").append(bookTitle);
        sb.append(", ").append(borrowerUid);
        sb.append(", ").append(borrowedAt);
        sb.append(", ").append(expectedReturnedAt);
        sb.append(", ").append(actualReturnedAt);
        sb.append(", ").append(borrowerRealName);
        sb.append(", ").append(borrowerSerialId);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBookBorrowForAdmin from) {
        setBookId(from.getBookId());
        setBookTitle(from.getBookTitle());
        setBorrowerUid(from.getBorrowerUid());
        setBorrowedAt(from.getBorrowedAt());
        setExpectedReturnedAt(from.getExpectedReturnedAt());
        setActualReturnedAt(from.getActualReturnedAt());
        setBorrowerRealName(from.getBorrowerRealName());
        setBorrowerSerialId(from.getBorrowerSerialId());
    }

    @Override
    public <E extends IBookBorrowForAdmin> E into(E into) {
        into.from(this);
        return into;
    }
}
