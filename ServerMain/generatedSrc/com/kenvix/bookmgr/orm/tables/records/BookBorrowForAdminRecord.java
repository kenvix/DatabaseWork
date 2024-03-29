/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables.records;


import com.kenvix.bookmgr.orm.tables.BookBorrowForAdmin;
import com.kenvix.bookmgr.orm.tables.interfaces.IBookBorrowForAdmin;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record22;
import org.jooq.Row22;
import org.jooq.impl.TableRecordImpl;


/**
 * VIEW
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookBorrowForAdminRecord extends TableRecordImpl<BookBorrowForAdminRecord> implements Record22<Long, String, Long, Timestamp, Integer, Integer, Byte, String, Long, String, Integer, String, String, Long, Timestamp, Timestamp, Timestamp, Short, Long, String, String, String>, IBookBorrowForAdmin {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>book_borrow_for_admin.book_id</code>. 书本ID
     */
    @Override
    public BookBorrowForAdminRecord setBookId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_id</code>. 书本ID
     */
    @Override
    public Long getBookId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_title</code>. 书籍标题
     */
    @Override
    public BookBorrowForAdminRecord setBookTitle(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_title</code>. 书籍标题
     */
    @Override
    public String getBookTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_publisher_id</code>. 出版社ID
     */
    @Override
    public BookBorrowForAdminRecord setBookPublisherId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_publisher_id</code>. 出版社ID
     */
    @Override
    public Long getBookPublisherId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_created_at</code>. 条目创建时间
     */
    @Override
    public BookBorrowForAdminRecord setBookCreatedAt(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_created_at</code>. 条目创建时间
     */
    @Override
    public Timestamp getBookCreatedAt() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_num_total</code>. 书籍总数
     */
    @Override
    public BookBorrowForAdminRecord setBookNumTotal(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_num_total</code>. 书籍总数
     */
    @Override
    public Integer getBookNumTotal() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_num_available</code>. 可用书籍数
     */
    @Override
    public BookBorrowForAdminRecord setBookNumAvailable(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_num_available</code>. 可用书籍数
     */
    @Override
    public Integer getBookNumAvailable() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_status</code>. 书籍状态
     */
    @Override
    public BookBorrowForAdminRecord setBookStatus(Byte value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_status</code>. 书籍状态
     */
    @Override
    public Byte getBookStatus() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_publisher_name</code>. 出版社名称
     */
    @Override
    public BookBorrowForAdminRecord setBookPublisherName(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_publisher_name</code>. 出版社名称
     */
    @Override
    public String getBookPublisherName() {
        return (String) get(7);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_author_id</code>. 作者ID
     */
    @Override
    public BookBorrowForAdminRecord setBookAuthorId(Long value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_author_id</code>. 作者ID
     */
    @Override
    public Long getBookAuthorId() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_author_name</code>.
     */
    @Override
    public BookBorrowForAdminRecord setBookAuthorName(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_author_name</code>.
     */
    @Override
    public String getBookAuthorName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_type_id</code>. 图书类型ID
     */
    @Override
    public BookBorrowForAdminRecord setBookTypeId(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_type_id</code>. 图书类型ID
     */
    @Override
    public Integer getBookTypeId() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_type_name</code>. 类目名称
     */
    @Override
    public BookBorrowForAdminRecord setBookTypeName(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_type_name</code>. 类目名称
     */
    @Override
    public String getBookTypeName() {
        return (String) get(11);
    }

    /**
     * Setter for <code>book_borrow_for_admin.book_status_description</code>.
     */
    @Override
    public BookBorrowForAdminRecord setBookStatusDescription(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.book_status_description</code>.
     */
    @Override
    public String getBookStatusDescription() {
        return (String) get(12);
    }

    /**
     * Setter for <code>book_borrow_for_admin.borrower_uid</code>. 借书人UID
     */
    @Override
    public BookBorrowForAdminRecord setBorrowerUid(Long value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.borrower_uid</code>. 借书人UID
     */
    @Override
    public Long getBorrowerUid() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>book_borrow_for_admin.borrowed_at</code>. 借书日期
     */
    @Override
    public BookBorrowForAdminRecord setBorrowedAt(Timestamp value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.borrowed_at</code>. 借书日期
     */
    @Override
    public Timestamp getBorrowedAt() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>book_borrow_for_admin.expected_returned_at</code>. 期望的还书日期
     */
    @Override
    public BookBorrowForAdminRecord setExpectedReturnedAt(Timestamp value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.expected_returned_at</code>. 期望的还书日期
     */
    @Override
    public Timestamp getExpectedReturnedAt() {
        return (Timestamp) get(15);
    }

    /**
     * Setter for <code>book_borrow_for_admin.actual_returned_at</code>. 实际还书日期，NULL为没还
     */
    @Override
    public BookBorrowForAdminRecord setActualReturnedAt(Timestamp value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.actual_returned_at</code>. 实际还书日期，NULL为没还
     */
    @Override
    public Timestamp getActualReturnedAt() {
        return (Timestamp) get(16);
    }

    /**
     * Setter for <code>book_borrow_for_admin.renew_num</code>. 续借次数
     */
    @Override
    public BookBorrowForAdminRecord setRenewNum(Short value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.renew_num</code>. 续借次数
     */
    @Override
    public Short getRenewNum() {
        return (Short) get(17);
    }

    /**
     * Setter for <code>book_borrow_for_admin.borrow_id</code>.
     */
    @Override
    public BookBorrowForAdminRecord setBorrowId(Long value) {
        set(18, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.borrow_id</code>.
     */
    @Override
    public Long getBorrowId() {
        return (Long) get(18);
    }

    /**
     * Setter for <code>book_borrow_for_admin.borrower_real_name</code>. 真实姓名
     */
    @Override
    public BookBorrowForAdminRecord setBorrowerRealName(String value) {
        set(19, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.borrower_real_name</code>. 真实姓名
     */
    @Override
    public String getBorrowerRealName() {
        return (String) get(19);
    }

    /**
     * Setter for <code>book_borrow_for_admin.borrower_email</code>. 电子邮箱
     */
    @Override
    public BookBorrowForAdminRecord setBorrowerEmail(String value) {
        set(20, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.borrower_email</code>. 电子邮箱
     */
    @Override
    public String getBorrowerEmail() {
        return (String) get(20);
    }

    /**
     * Setter for <code>book_borrow_for_admin.borrower_serial_id</code>. 工号/序列号
     */
    @Override
    public BookBorrowForAdminRecord setBorrowerSerialId(String value) {
        set(21, value);
        return this;
    }

    /**
     * Getter for <code>book_borrow_for_admin.borrower_serial_id</code>. 工号/序列号
     */
    @Override
    public String getBorrowerSerialId() {
        return (String) get(21);
    }

    // -------------------------------------------------------------------------
    // Record22 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row22<Long, String, Long, Timestamp, Integer, Integer, Byte, String, Long, String, Integer, String, String, Long, Timestamp, Timestamp, Timestamp, Short, Long, String, String, String> fieldsRow() {
        return (Row22) super.fieldsRow();
    }

    @Override
    public Row22<Long, String, Long, Timestamp, Integer, Integer, Byte, String, Long, String, Integer, String, String, Long, Timestamp, Timestamp, Timestamp, Short, Long, String, String, String> valuesRow() {
        return (Row22) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_ID;
    }

    @Override
    public Field<String> field2() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_TITLE;
    }

    @Override
    public Field<Long> field3() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_PUBLISHER_ID;
    }

    @Override
    public Field<Timestamp> field4() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_CREATED_AT;
    }

    @Override
    public Field<Integer> field5() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_NUM_TOTAL;
    }

    @Override
    public Field<Integer> field6() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_NUM_AVAILABLE;
    }

    @Override
    public Field<Byte> field7() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_STATUS;
    }

    @Override
    public Field<String> field8() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_PUBLISHER_NAME;
    }

    @Override
    public Field<Long> field9() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_AUTHOR_ID;
    }

    @Override
    public Field<String> field10() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_AUTHOR_NAME;
    }

    @Override
    public Field<Integer> field11() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_TYPE_ID;
    }

    @Override
    public Field<String> field12() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_TYPE_NAME;
    }

    @Override
    public Field<String> field13() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BOOK_STATUS_DESCRIPTION;
    }

    @Override
    public Field<Long> field14() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BORROWER_UID;
    }

    @Override
    public Field<Timestamp> field15() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BORROWED_AT;
    }

    @Override
    public Field<Timestamp> field16() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.EXPECTED_RETURNED_AT;
    }

    @Override
    public Field<Timestamp> field17() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT;
    }

    @Override
    public Field<Short> field18() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.RENEW_NUM;
    }

    @Override
    public Field<Long> field19() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BORROW_ID;
    }

    @Override
    public Field<String> field20() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BORROWER_REAL_NAME;
    }

    @Override
    public Field<String> field21() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BORROWER_EMAIL;
    }

    @Override
    public Field<String> field22() {
        return BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN.BORROWER_SERIAL_ID;
    }

    @Override
    public Long component1() {
        return getBookId();
    }

    @Override
    public String component2() {
        return getBookTitle();
    }

    @Override
    public Long component3() {
        return getBookPublisherId();
    }

    @Override
    public Timestamp component4() {
        return getBookCreatedAt();
    }

    @Override
    public Integer component5() {
        return getBookNumTotal();
    }

    @Override
    public Integer component6() {
        return getBookNumAvailable();
    }

    @Override
    public Byte component7() {
        return getBookStatus();
    }

    @Override
    public String component8() {
        return getBookPublisherName();
    }

    @Override
    public Long component9() {
        return getBookAuthorId();
    }

    @Override
    public String component10() {
        return getBookAuthorName();
    }

    @Override
    public Integer component11() {
        return getBookTypeId();
    }

    @Override
    public String component12() {
        return getBookTypeName();
    }

    @Override
    public String component13() {
        return getBookStatusDescription();
    }

    @Override
    public Long component14() {
        return getBorrowerUid();
    }

    @Override
    public Timestamp component15() {
        return getBorrowedAt();
    }

    @Override
    public Timestamp component16() {
        return getExpectedReturnedAt();
    }

    @Override
    public Timestamp component17() {
        return getActualReturnedAt();
    }

    @Override
    public Short component18() {
        return getRenewNum();
    }

    @Override
    public Long component19() {
        return getBorrowId();
    }

    @Override
    public String component20() {
        return getBorrowerRealName();
    }

    @Override
    public String component21() {
        return getBorrowerEmail();
    }

    @Override
    public String component22() {
        return getBorrowerSerialId();
    }

    @Override
    public Long value1() {
        return getBookId();
    }

    @Override
    public String value2() {
        return getBookTitle();
    }

    @Override
    public Long value3() {
        return getBookPublisherId();
    }

    @Override
    public Timestamp value4() {
        return getBookCreatedAt();
    }

    @Override
    public Integer value5() {
        return getBookNumTotal();
    }

    @Override
    public Integer value6() {
        return getBookNumAvailable();
    }

    @Override
    public Byte value7() {
        return getBookStatus();
    }

    @Override
    public String value8() {
        return getBookPublisherName();
    }

    @Override
    public Long value9() {
        return getBookAuthorId();
    }

    @Override
    public String value10() {
        return getBookAuthorName();
    }

    @Override
    public Integer value11() {
        return getBookTypeId();
    }

    @Override
    public String value12() {
        return getBookTypeName();
    }

    @Override
    public String value13() {
        return getBookStatusDescription();
    }

    @Override
    public Long value14() {
        return getBorrowerUid();
    }

    @Override
    public Timestamp value15() {
        return getBorrowedAt();
    }

    @Override
    public Timestamp value16() {
        return getExpectedReturnedAt();
    }

    @Override
    public Timestamp value17() {
        return getActualReturnedAt();
    }

    @Override
    public Short value18() {
        return getRenewNum();
    }

    @Override
    public Long value19() {
        return getBorrowId();
    }

    @Override
    public String value20() {
        return getBorrowerRealName();
    }

    @Override
    public String value21() {
        return getBorrowerEmail();
    }

    @Override
    public String value22() {
        return getBorrowerSerialId();
    }

    @Override
    public BookBorrowForAdminRecord value1(Long value) {
        setBookId(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value2(String value) {
        setBookTitle(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value3(Long value) {
        setBookPublisherId(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value4(Timestamp value) {
        setBookCreatedAt(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value5(Integer value) {
        setBookNumTotal(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value6(Integer value) {
        setBookNumAvailable(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value7(Byte value) {
        setBookStatus(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value8(String value) {
        setBookPublisherName(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value9(Long value) {
        setBookAuthorId(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value10(String value) {
        setBookAuthorName(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value11(Integer value) {
        setBookTypeId(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value12(String value) {
        setBookTypeName(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value13(String value) {
        setBookStatusDescription(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value14(Long value) {
        setBorrowerUid(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value15(Timestamp value) {
        setBorrowedAt(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value16(Timestamp value) {
        setExpectedReturnedAt(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value17(Timestamp value) {
        setActualReturnedAt(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value18(Short value) {
        setRenewNum(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value19(Long value) {
        setBorrowId(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value20(String value) {
        setBorrowerRealName(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value21(String value) {
        setBorrowerEmail(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord value22(String value) {
        setBorrowerSerialId(value);
        return this;
    }

    @Override
    public BookBorrowForAdminRecord values(Long value1, String value2, Long value3, Timestamp value4, Integer value5, Integer value6, Byte value7, String value8, Long value9, String value10, Integer value11, String value12, String value13, Long value14, Timestamp value15, Timestamp value16, Timestamp value17, Short value18, Long value19, String value20, String value21, String value22) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        value22(value22);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBookBorrowForAdmin from) {
        setBookId(from.getBookId());
        setBookTitle(from.getBookTitle());
        setBookPublisherId(from.getBookPublisherId());
        setBookCreatedAt(from.getBookCreatedAt());
        setBookNumTotal(from.getBookNumTotal());
        setBookNumAvailable(from.getBookNumAvailable());
        setBookStatus(from.getBookStatus());
        setBookPublisherName(from.getBookPublisherName());
        setBookAuthorId(from.getBookAuthorId());
        setBookAuthorName(from.getBookAuthorName());
        setBookTypeId(from.getBookTypeId());
        setBookTypeName(from.getBookTypeName());
        setBookStatusDescription(from.getBookStatusDescription());
        setBorrowerUid(from.getBorrowerUid());
        setBorrowedAt(from.getBorrowedAt());
        setExpectedReturnedAt(from.getExpectedReturnedAt());
        setActualReturnedAt(from.getActualReturnedAt());
        setRenewNum(from.getRenewNum());
        setBorrowId(from.getBorrowId());
        setBorrowerRealName(from.getBorrowerRealName());
        setBorrowerEmail(from.getBorrowerEmail());
        setBorrowerSerialId(from.getBorrowerSerialId());
    }

    @Override
    public <E extends IBookBorrowForAdmin> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookBorrowForAdminRecord
     */
    public BookBorrowForAdminRecord() {
        super(BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN);
    }

    /**
     * Create a detached, initialised BookBorrowForAdminRecord
     */
    public BookBorrowForAdminRecord(Long bookId, String bookTitle, Long bookPublisherId, Timestamp bookCreatedAt, Integer bookNumTotal, Integer bookNumAvailable, Byte bookStatus, String bookPublisherName, Long bookAuthorId, String bookAuthorName, Integer bookTypeId, String bookTypeName, String bookStatusDescription, Long borrowerUid, Timestamp borrowedAt, Timestamp expectedReturnedAt, Timestamp actualReturnedAt, Short renewNum, Long borrowId, String borrowerRealName, String borrowerEmail, String borrowerSerialId) {
        super(BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN);

        setBookId(bookId);
        setBookTitle(bookTitle);
        setBookPublisherId(bookPublisherId);
        setBookCreatedAt(bookCreatedAt);
        setBookNumTotal(bookNumTotal);
        setBookNumAvailable(bookNumAvailable);
        setBookStatus(bookStatus);
        setBookPublisherName(bookPublisherName);
        setBookAuthorId(bookAuthorId);
        setBookAuthorName(bookAuthorName);
        setBookTypeId(bookTypeId);
        setBookTypeName(bookTypeName);
        setBookStatusDescription(bookStatusDescription);
        setBorrowerUid(borrowerUid);
        setBorrowedAt(borrowedAt);
        setExpectedReturnedAt(expectedReturnedAt);
        setActualReturnedAt(actualReturnedAt);
        setRenewNum(renewNum);
        setBorrowId(borrowId);
        setBorrowerRealName(borrowerRealName);
        setBorrowerEmail(borrowerEmail);
        setBorrowerSerialId(borrowerSerialId);
    }
}
