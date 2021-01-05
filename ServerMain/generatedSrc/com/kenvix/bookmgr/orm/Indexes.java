/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm;


import com.kenvix.bookmgr.orm.tables.Author;
import com.kenvix.bookmgr.orm.tables.Book;
import com.kenvix.bookmgr.orm.tables.BookAuthorMap;
import com.kenvix.bookmgr.orm.tables.BookBorrow;
import com.kenvix.bookmgr.orm.tables.Invoice;
import com.kenvix.bookmgr.orm.tables.InvoicePenalty;
import com.kenvix.bookmgr.orm.tables.LogSystem;
import com.kenvix.bookmgr.orm.tables.Publisher;
import com.kenvix.bookmgr.orm.tables.TaskQueue;
import com.kenvix.bookmgr.orm.tables.User;

import javax.annotation.processing.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index AUTHOR_INDEX_AUTHOR_NAME = Indexes0.AUTHOR_INDEX_AUTHOR_NAME;
    public static final Index BOOK_FK_BOOK_STATUS = Indexes0.BOOK_FK_BOOK_STATUS;
    public static final Index BOOK_FK_CREATOR_UID = Indexes0.BOOK_FK_CREATOR_UID;
    public static final Index BOOK_FK_PUBLISHER_ID = Indexes0.BOOK_FK_PUBLISHER_ID;
    public static final Index BOOK_AUTHOR_MAP_FK_BOOK_AUTHOR_MAP_AUTHOR_ID = Indexes0.BOOK_AUTHOR_MAP_FK_BOOK_AUTHOR_MAP_AUTHOR_ID;
    public static final Index BOOK_BORROW_FK_BOOK_ID = Indexes0.BOOK_BORROW_FK_BOOK_ID;
    public static final Index BOOK_BORROW_FK_BORROWER_UID = Indexes0.BOOK_BORROW_FK_BORROWER_UID;
    public static final Index INVOICE_FK_INVOCIE_STATUS = Indexes0.INVOICE_FK_INVOCIE_STATUS;
    public static final Index INVOICE_FK_OWNER_UID = Indexes0.INVOICE_FK_OWNER_UID;
    public static final Index INVOICE_FK_TYPE = Indexes0.INVOICE_FK_TYPE;
    public static final Index INVOICE_PENALTY_FK_BOOK_ID_INVOICE_PENALTY = Indexes0.INVOICE_PENALTY_FK_BOOK_ID_INVOICE_PENALTY;
    public static final Index INVOICE_PENALTY_FK_INVOICE_ID_INVOICE_PENALTY = Indexes0.INVOICE_PENALTY_FK_INVOICE_ID_INVOICE_PENALTY;
    public static final Index LOG_SYSTEM_FK_LOG_SYSTEM_TYPE = Indexes0.LOG_SYSTEM_FK_LOG_SYSTEM_TYPE;
    public static final Index PUBLISHER_UNIQUE_NAME = Indexes0.PUBLISHER_UNIQUE_NAME;
    public static final Index TASK_QUEUE_INDEX_TASK = Indexes0.TASK_QUEUE_INDEX_TASK;
    public static final Index USER_FK_ACCESS_LEVEL = Indexes0.USER_FK_ACCESS_LEVEL;
    public static final Index USER_UNIQUE_EMAIL = Indexes0.USER_UNIQUE_EMAIL;
    public static final Index USER_UNIQUE_SERIAL_ID = Indexes0.USER_UNIQUE_SERIAL_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index AUTHOR_INDEX_AUTHOR_NAME = Internal.createIndex("index_author_name", Author.AUTHOR, new OrderField[] { Author.AUTHOR.NAME }, false);
        public static Index BOOK_FK_BOOK_STATUS = Internal.createIndex("fk_book_status", Book.BOOK, new OrderField[] { Book.BOOK.STATUS }, false);
        public static Index BOOK_FK_CREATOR_UID = Internal.createIndex("fk_creator_uid", Book.BOOK, new OrderField[] { Book.BOOK.CREATOR_UID }, false);
        public static Index BOOK_FK_PUBLISHER_ID = Internal.createIndex("fk_publisher_id", Book.BOOK, new OrderField[] { Book.BOOK.PUBLISHER_ID }, false);
        public static Index BOOK_AUTHOR_MAP_FK_BOOK_AUTHOR_MAP_AUTHOR_ID = Internal.createIndex("fk_book_author_map_author_id", BookAuthorMap.BOOK_AUTHOR_MAP, new OrderField[] { BookAuthorMap.BOOK_AUTHOR_MAP.AUTHOR_ID }, false);
        public static Index BOOK_BORROW_FK_BOOK_ID = Internal.createIndex("fk_book_id", BookBorrow.BOOK_BORROW, new OrderField[] { BookBorrow.BOOK_BORROW.BOOK_ID }, false);
        public static Index BOOK_BORROW_FK_BORROWER_UID = Internal.createIndex("fk_borrower_uid", BookBorrow.BOOK_BORROW, new OrderField[] { BookBorrow.BOOK_BORROW.BORROWER_UID }, false);
        public static Index INVOICE_FK_INVOCIE_STATUS = Internal.createIndex("fk_invocie_status", Invoice.INVOICE, new OrderField[] { Invoice.INVOICE.STATUS }, false);
        public static Index INVOICE_FK_OWNER_UID = Internal.createIndex("fk_owner_uid", Invoice.INVOICE, new OrderField[] { Invoice.INVOICE.OWNER_UID }, false);
        public static Index INVOICE_FK_TYPE = Internal.createIndex("fk_type", Invoice.INVOICE, new OrderField[] { Invoice.INVOICE.TYPE }, false);
        public static Index INVOICE_PENALTY_FK_BOOK_ID_INVOICE_PENALTY = Internal.createIndex("fk_book_id_invoice_penalty", InvoicePenalty.INVOICE_PENALTY, new OrderField[] { InvoicePenalty.INVOICE_PENALTY.BOOK_ID }, false);
        public static Index INVOICE_PENALTY_FK_INVOICE_ID_INVOICE_PENALTY = Internal.createIndex("fk_invoice_id_invoice_penalty", InvoicePenalty.INVOICE_PENALTY, new OrderField[] { InvoicePenalty.INVOICE_PENALTY.INVOICE_ID }, false);
        public static Index LOG_SYSTEM_FK_LOG_SYSTEM_TYPE = Internal.createIndex("fk_log_system_type", LogSystem.LOG_SYSTEM, new OrderField[] { LogSystem.LOG_SYSTEM.EXCEPTION }, false);
        public static Index PUBLISHER_UNIQUE_NAME = Internal.createIndex("unique_name", Publisher.PUBLISHER, new OrderField[] { Publisher.PUBLISHER.NAME }, true);
        public static Index TASK_QUEUE_INDEX_TASK = Internal.createIndex("index_task", TaskQueue.TASK_QUEUE, new OrderField[] { TaskQueue.TASK_QUEUE.IS_FINISHED, TaskQueue.TASK_QUEUE.IS_SUCCESS, TaskQueue.TASK_QUEUE.IS_DOING, TaskQueue.TASK_QUEUE.TYPE }, false);
        public static Index USER_FK_ACCESS_LEVEL = Internal.createIndex("fk_access_level", User.USER, new OrderField[] { User.USER.ACCESS_LEVEL }, false);
        public static Index USER_UNIQUE_EMAIL = Internal.createIndex("unique_email", User.USER, new OrderField[] { User.USER.EMAIL }, true);
        public static Index USER_UNIQUE_SERIAL_ID = Internal.createIndex("unique_serial_id", User.USER, new OrderField[] { User.USER.SERIAL_ID }, true);
    }
}