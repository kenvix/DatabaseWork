/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm;


import com.kenvix.bookmgr.orm.tables.Author;
import com.kenvix.bookmgr.orm.tables.Book;
import com.kenvix.bookmgr.orm.tables.BookAuthor;
import com.kenvix.bookmgr.orm.tables.BookAuthorMap;
import com.kenvix.bookmgr.orm.tables.BookBorrow;
import com.kenvix.bookmgr.orm.tables.BookBorrowExpired;
import com.kenvix.bookmgr.orm.tables.BookBorrowForAdmin;
import com.kenvix.bookmgr.orm.tables.BookBorrowForUser;
import com.kenvix.bookmgr.orm.tables.BookForUser;
import com.kenvix.bookmgr.orm.tables.BookStatus;
import com.kenvix.bookmgr.orm.tables.Invoice;
import com.kenvix.bookmgr.orm.tables.InvoiceForUser;
import com.kenvix.bookmgr.orm.tables.InvoicePenalty;
import com.kenvix.bookmgr.orm.tables.InvoiceStatus;
import com.kenvix.bookmgr.orm.tables.InvoiceType;
import com.kenvix.bookmgr.orm.tables.LogCardAccess;
import com.kenvix.bookmgr.orm.tables.LogCardAccessForAdmin;
import com.kenvix.bookmgr.orm.tables.LogSystem;
import com.kenvix.bookmgr.orm.tables.LogUserLogin;
import com.kenvix.bookmgr.orm.tables.LogUserLoginForAdmin;
import com.kenvix.bookmgr.orm.tables.Publisher;
import com.kenvix.bookmgr.orm.tables.TaskQueue;
import com.kenvix.bookmgr.orm.tables.User;
import com.kenvix.bookmgr.orm.tables.UserAccessLevel;
import com.kenvix.bookmgr.orm.tables.UserExtra;
import com.kenvix.bookmgr.orm.tables.UserForAdmin;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1995560990;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * 作者表
     */
    public final Author AUTHOR = Author.AUTHOR;

    /**
     * 书籍表
     */
    public final Book BOOK = Book.BOOK;

    /**
     * VIEW
     */
    public final BookAuthor BOOK_AUTHOR = BookAuthor.BOOK_AUTHOR;

    /**
     * 书籍-作者关系映射表
     */
    public final BookAuthorMap BOOK_AUTHOR_MAP = BookAuthorMap.BOOK_AUTHOR_MAP;

    /**
     * 借书表
     */
    public final BookBorrow BOOK_BORROW = BookBorrow.BOOK_BORROW;

    /**
     * VIEW
     */
    public final BookBorrowExpired BOOK_BORROW_EXPIRED = BookBorrowExpired.BOOK_BORROW_EXPIRED;

    /**
     * VIEW
     */
    public final BookBorrowForAdmin BOOK_BORROW_FOR_ADMIN = BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN;

    /**
     * VIEW
     */
    public final BookBorrowForUser BOOK_BORROW_FOR_USER = BookBorrowForUser.BOOK_BORROW_FOR_USER;

    /**
     * VIEW
     */
    public final BookForUser BOOK_FOR_USER = BookForUser.BOOK_FOR_USER;

    /**
     * 书籍状态表
     */
    public final BookStatus BOOK_STATUS = BookStatus.BOOK_STATUS;

    /**
     * 账单，包括罚款
     */
    public final Invoice INVOICE = Invoice.INVOICE;

    /**
     * VIEW
     */
    public final InvoiceForUser INVOICE_FOR_USER = InvoiceForUser.INVOICE_FOR_USER;

    /**
     * 罚款型订单扩展信息
     */
    public final InvoicePenalty INVOICE_PENALTY = InvoicePenalty.INVOICE_PENALTY;

    /**
     * 订单状态
     */
    public final InvoiceStatus INVOICE_STATUS = InvoiceStatus.INVOICE_STATUS;

    /**
     * 订单类型
     */
    public final InvoiceType INVOICE_TYPE = InvoiceType.INVOICE_TYPE;

    /**
     * 刷卡日志（不可修改和删除）
     */
    public final LogCardAccess LOG_CARD_ACCESS = LogCardAccess.LOG_CARD_ACCESS;

    /**
     * VIEW
     */
    public final LogCardAccessForAdmin LOG_CARD_ACCESS_FOR_ADMIN = LogCardAccessForAdmin.LOG_CARD_ACCESS_FOR_ADMIN;

    /**
     * 系统日志
     */
    public final LogSystem LOG_SYSTEM = LogSystem.LOG_SYSTEM;

    /**
     * 用户登录日志（不可修改和删除）
     */
    public final LogUserLogin LOG_USER_LOGIN = LogUserLogin.LOG_USER_LOGIN;

    /**
     * VIEW
     */
    public final LogUserLoginForAdmin LOG_USER_LOGIN_FOR_ADMIN = LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN;

    /**
     * 出版社
     */
    public final Publisher PUBLISHER = Publisher.PUBLISHER;

    /**
     * 任务队列（程序可读）
     */
    public final TaskQueue TASK_QUEUE = TaskQueue.TASK_QUEUE;

    /**
     * 用户基本信息
     */
    public final User USER = User.USER;

    /**
     * 用户访问级别定义
     */
    public final UserAccessLevel USER_ACCESS_LEVEL = UserAccessLevel.USER_ACCESS_LEVEL;

    /**
     * 用户扩展信息
     */
    public final UserExtra USER_EXTRA = UserExtra.USER_EXTRA;

    /**
     * VIEW
     */
    public final UserForAdmin USER_FOR_ADMIN = UserForAdmin.USER_FOR_ADMIN;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Author.AUTHOR,
            Book.BOOK,
            BookAuthor.BOOK_AUTHOR,
            BookAuthorMap.BOOK_AUTHOR_MAP,
            BookBorrow.BOOK_BORROW,
            BookBorrowExpired.BOOK_BORROW_EXPIRED,
            BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN,
            BookBorrowForUser.BOOK_BORROW_FOR_USER,
            BookForUser.BOOK_FOR_USER,
            BookStatus.BOOK_STATUS,
            Invoice.INVOICE,
            InvoiceForUser.INVOICE_FOR_USER,
            InvoicePenalty.INVOICE_PENALTY,
            InvoiceStatus.INVOICE_STATUS,
            InvoiceType.INVOICE_TYPE,
            LogCardAccess.LOG_CARD_ACCESS,
            LogCardAccessForAdmin.LOG_CARD_ACCESS_FOR_ADMIN,
            LogSystem.LOG_SYSTEM,
            LogUserLogin.LOG_USER_LOGIN,
            LogUserLoginForAdmin.LOG_USER_LOGIN_FOR_ADMIN,
            Publisher.PUBLISHER,
            TaskQueue.TASK_QUEUE,
            User.USER,
            UserAccessLevel.USER_ACCESS_LEVEL,
            UserExtra.USER_EXTRA,
            UserForAdmin.USER_FOR_ADMIN);
    }
}
