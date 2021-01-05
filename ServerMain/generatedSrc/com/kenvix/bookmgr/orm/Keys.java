/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm;


import com.kenvix.bookmgr.orm.tables.Author;
import com.kenvix.bookmgr.orm.tables.Book;
import com.kenvix.bookmgr.orm.tables.BookAuthorMap;
import com.kenvix.bookmgr.orm.tables.BookBorrow;
import com.kenvix.bookmgr.orm.tables.BookStatus;
import com.kenvix.bookmgr.orm.tables.Invoice;
import com.kenvix.bookmgr.orm.tables.InvoicePenalty;
import com.kenvix.bookmgr.orm.tables.InvoiceStatus;
import com.kenvix.bookmgr.orm.tables.InvoiceType;
import com.kenvix.bookmgr.orm.tables.LogCardAccess;
import com.kenvix.bookmgr.orm.tables.LogSystem;
import com.kenvix.bookmgr.orm.tables.LogUserLogin;
import com.kenvix.bookmgr.orm.tables.Publisher;
import com.kenvix.bookmgr.orm.tables.TaskQueue;
import com.kenvix.bookmgr.orm.tables.User;
import com.kenvix.bookmgr.orm.tables.UserAccessLevel;
import com.kenvix.bookmgr.orm.tables.UserExtra;
import com.kenvix.bookmgr.orm.tables.records.AuthorRecord;
import com.kenvix.bookmgr.orm.tables.records.BookAuthorMapRecord;
import com.kenvix.bookmgr.orm.tables.records.BookBorrowRecord;
import com.kenvix.bookmgr.orm.tables.records.BookRecord;
import com.kenvix.bookmgr.orm.tables.records.BookStatusRecord;
import com.kenvix.bookmgr.orm.tables.records.InvoicePenaltyRecord;
import com.kenvix.bookmgr.orm.tables.records.InvoiceRecord;
import com.kenvix.bookmgr.orm.tables.records.InvoiceStatusRecord;
import com.kenvix.bookmgr.orm.tables.records.InvoiceTypeRecord;
import com.kenvix.bookmgr.orm.tables.records.LogCardAccessRecord;
import com.kenvix.bookmgr.orm.tables.records.LogSystemRecord;
import com.kenvix.bookmgr.orm.tables.records.LogUserLoginRecord;
import com.kenvix.bookmgr.orm.tables.records.PublisherRecord;
import com.kenvix.bookmgr.orm.tables.records.TaskQueueRecord;
import com.kenvix.bookmgr.orm.tables.records.UserAccessLevelRecord;
import com.kenvix.bookmgr.orm.tables.records.UserExtraRecord;
import com.kenvix.bookmgr.orm.tables.records.UserRecord;

import javax.annotation.processing.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AuthorRecord, Long> IDENTITY_AUTHOR = Identities0.IDENTITY_AUTHOR;
    public static final Identity<BookRecord, Long> IDENTITY_BOOK = Identities0.IDENTITY_BOOK;
    public static final Identity<InvoiceRecord, Long> IDENTITY_INVOICE = Identities0.IDENTITY_INVOICE;
    public static final Identity<InvoicePenaltyRecord, Long> IDENTITY_INVOICE_PENALTY = Identities0.IDENTITY_INVOICE_PENALTY;
    public static final Identity<LogCardAccessRecord, Long> IDENTITY_LOG_CARD_ACCESS = Identities0.IDENTITY_LOG_CARD_ACCESS;
    public static final Identity<LogSystemRecord, Long> IDENTITY_LOG_SYSTEM = Identities0.IDENTITY_LOG_SYSTEM;
    public static final Identity<LogUserLoginRecord, Long> IDENTITY_LOG_USER_LOGIN = Identities0.IDENTITY_LOG_USER_LOGIN;
    public static final Identity<PublisherRecord, Long> IDENTITY_PUBLISHER = Identities0.IDENTITY_PUBLISHER;
    public static final Identity<TaskQueueRecord, Long> IDENTITY_TASK_QUEUE = Identities0.IDENTITY_TASK_QUEUE;
    public static final Identity<UserRecord, Long> IDENTITY_USER = Identities0.IDENTITY_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = UniqueKeys0.KEY_AUTHOR_PRIMARY;
    public static final UniqueKey<BookRecord> KEY_BOOK_PRIMARY = UniqueKeys0.KEY_BOOK_PRIMARY;
    public static final UniqueKey<BookAuthorMapRecord> KEY_BOOK_AUTHOR_MAP_PRIMARY = UniqueKeys0.KEY_BOOK_AUTHOR_MAP_PRIMARY;
    public static final UniqueKey<BookBorrowRecord> KEY_BOOK_BORROW_PRIMARY = UniqueKeys0.KEY_BOOK_BORROW_PRIMARY;
    public static final UniqueKey<BookStatusRecord> KEY_BOOK_STATUS_PRIMARY = UniqueKeys0.KEY_BOOK_STATUS_PRIMARY;
    public static final UniqueKey<InvoiceRecord> KEY_INVOICE_PRIMARY = UniqueKeys0.KEY_INVOICE_PRIMARY;
    public static final UniqueKey<InvoicePenaltyRecord> KEY_INVOICE_PENALTY_PRIMARY = UniqueKeys0.KEY_INVOICE_PENALTY_PRIMARY;
    public static final UniqueKey<InvoiceStatusRecord> KEY_INVOICE_STATUS_PRIMARY = UniqueKeys0.KEY_INVOICE_STATUS_PRIMARY;
    public static final UniqueKey<InvoiceTypeRecord> KEY_INVOICE_TYPE_PRIMARY = UniqueKeys0.KEY_INVOICE_TYPE_PRIMARY;
    public static final UniqueKey<LogCardAccessRecord> KEY_LOG_CARD_ACCESS_PRIMARY = UniqueKeys0.KEY_LOG_CARD_ACCESS_PRIMARY;
    public static final UniqueKey<LogSystemRecord> KEY_LOG_SYSTEM_PRIMARY = UniqueKeys0.KEY_LOG_SYSTEM_PRIMARY;
    public static final UniqueKey<LogUserLoginRecord> KEY_LOG_USER_LOGIN_PRIMARY = UniqueKeys0.KEY_LOG_USER_LOGIN_PRIMARY;
    public static final UniqueKey<PublisherRecord> KEY_PUBLISHER_PRIMARY = UniqueKeys0.KEY_PUBLISHER_PRIMARY;
    public static final UniqueKey<PublisherRecord> KEY_PUBLISHER_UNIQUE_NAME = UniqueKeys0.KEY_PUBLISHER_UNIQUE_NAME;
    public static final UniqueKey<TaskQueueRecord> KEY_TASK_QUEUE_PRIMARY = UniqueKeys0.KEY_TASK_QUEUE_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_UNIQUE_SERIAL_ID = UniqueKeys0.KEY_USER_UNIQUE_SERIAL_ID;
    public static final UniqueKey<UserRecord> KEY_USER_UNIQUE_EMAIL = UniqueKeys0.KEY_USER_UNIQUE_EMAIL;
    public static final UniqueKey<UserAccessLevelRecord> KEY_USER_ACCESS_LEVEL_PRIMARY = UniqueKeys0.KEY_USER_ACCESS_LEVEL_PRIMARY;
    public static final UniqueKey<UserExtraRecord> KEY_USER_EXTRA_PRIMARY = UniqueKeys0.KEY_USER_EXTRA_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BookRecord, UserRecord> FK_CREATOR_UID = ForeignKeys0.FK_CREATOR_UID;
    public static final ForeignKey<BookRecord, PublisherRecord> FK_PUBLISHER_ID = ForeignKeys0.FK_PUBLISHER_ID;
    public static final ForeignKey<BookRecord, BookStatusRecord> FK_BOOK_STATUS = ForeignKeys0.FK_BOOK_STATUS;
    public static final ForeignKey<BookAuthorMapRecord, BookRecord> FK_BOOK_AUTHOR_MAP_BOOK_ID = ForeignKeys0.FK_BOOK_AUTHOR_MAP_BOOK_ID;
    public static final ForeignKey<BookAuthorMapRecord, AuthorRecord> FK_BOOK_AUTHOR_MAP_AUTHOR_ID = ForeignKeys0.FK_BOOK_AUTHOR_MAP_AUTHOR_ID;
    public static final ForeignKey<BookBorrowRecord, BookRecord> FK_BOOK_ID = ForeignKeys0.FK_BOOK_ID;
    public static final ForeignKey<BookBorrowRecord, UserRecord> FK_BORROWER_UID = ForeignKeys0.FK_BORROWER_UID;
    public static final ForeignKey<InvoiceRecord, InvoiceTypeRecord> FK_TYPE = ForeignKeys0.FK_TYPE;
    public static final ForeignKey<InvoiceRecord, UserRecord> FK_OWNER_UID = ForeignKeys0.FK_OWNER_UID;
    public static final ForeignKey<InvoiceRecord, InvoiceStatusRecord> FK_INVOCIE_STATUS = ForeignKeys0.FK_INVOCIE_STATUS;
    public static final ForeignKey<InvoicePenaltyRecord, InvoiceRecord> FK_INVOICE_ID_INVOICE_PENALTY = ForeignKeys0.FK_INVOICE_ID_INVOICE_PENALTY;
    public static final ForeignKey<InvoicePenaltyRecord, BookRecord> FK_BOOK_ID_INVOICE_PENALTY = ForeignKeys0.FK_BOOK_ID_INVOICE_PENALTY;
    public static final ForeignKey<UserRecord, UserAccessLevelRecord> FK_ACCESS_LEVEL = ForeignKeys0.FK_ACCESS_LEVEL;
    public static final ForeignKey<UserExtraRecord, UserRecord> FK_UID = ForeignKeys0.FK_UID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AuthorRecord, Long> IDENTITY_AUTHOR = Internal.createIdentity(Author.AUTHOR, Author.AUTHOR.ID);
        public static Identity<BookRecord, Long> IDENTITY_BOOK = Internal.createIdentity(Book.BOOK, Book.BOOK.ID);
        public static Identity<InvoiceRecord, Long> IDENTITY_INVOICE = Internal.createIdentity(Invoice.INVOICE, Invoice.INVOICE.ID);
        public static Identity<InvoicePenaltyRecord, Long> IDENTITY_INVOICE_PENALTY = Internal.createIdentity(InvoicePenalty.INVOICE_PENALTY, InvoicePenalty.INVOICE_PENALTY.ID);
        public static Identity<LogCardAccessRecord, Long> IDENTITY_LOG_CARD_ACCESS = Internal.createIdentity(LogCardAccess.LOG_CARD_ACCESS, LogCardAccess.LOG_CARD_ACCESS.ID);
        public static Identity<LogSystemRecord, Long> IDENTITY_LOG_SYSTEM = Internal.createIdentity(LogSystem.LOG_SYSTEM, LogSystem.LOG_SYSTEM.ID);
        public static Identity<LogUserLoginRecord, Long> IDENTITY_LOG_USER_LOGIN = Internal.createIdentity(LogUserLogin.LOG_USER_LOGIN, LogUserLogin.LOG_USER_LOGIN.ID);
        public static Identity<PublisherRecord, Long> IDENTITY_PUBLISHER = Internal.createIdentity(Publisher.PUBLISHER, Publisher.PUBLISHER.ID);
        public static Identity<TaskQueueRecord, Long> IDENTITY_TASK_QUEUE = Internal.createIdentity(TaskQueue.TASK_QUEUE, TaskQueue.TASK_QUEUE.ID);
        public static Identity<UserRecord, Long> IDENTITY_USER = Internal.createIdentity(User.USER, User.USER.UID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = Internal.createUniqueKey(Author.AUTHOR, "KEY_author_PRIMARY", new TableField[] { Author.AUTHOR.ID }, true);
        public static final UniqueKey<BookRecord> KEY_BOOK_PRIMARY = Internal.createUniqueKey(Book.BOOK, "KEY_book_PRIMARY", new TableField[] { Book.BOOK.ID }, true);
        public static final UniqueKey<BookAuthorMapRecord> KEY_BOOK_AUTHOR_MAP_PRIMARY = Internal.createUniqueKey(BookAuthorMap.BOOK_AUTHOR_MAP, "KEY_book_author_map_PRIMARY", new TableField[] { BookAuthorMap.BOOK_AUTHOR_MAP.BOOK_ID, BookAuthorMap.BOOK_AUTHOR_MAP.AUTHOR_ID }, true);
        public static final UniqueKey<BookBorrowRecord> KEY_BOOK_BORROW_PRIMARY = Internal.createUniqueKey(BookBorrow.BOOK_BORROW, "KEY_book_borrow_PRIMARY", new TableField[] { BookBorrow.BOOK_BORROW.ID }, true);
        public static final UniqueKey<BookStatusRecord> KEY_BOOK_STATUS_PRIMARY = Internal.createUniqueKey(BookStatus.BOOK_STATUS, "KEY_book_status_PRIMARY", new TableField[] { BookStatus.BOOK_STATUS.ID }, true);
        public static final UniqueKey<InvoiceRecord> KEY_INVOICE_PRIMARY = Internal.createUniqueKey(Invoice.INVOICE, "KEY_invoice_PRIMARY", new TableField[] { Invoice.INVOICE.ID }, true);
        public static final UniqueKey<InvoicePenaltyRecord> KEY_INVOICE_PENALTY_PRIMARY = Internal.createUniqueKey(InvoicePenalty.INVOICE_PENALTY, "KEY_invoice_penalty_PRIMARY", new TableField[] { InvoicePenalty.INVOICE_PENALTY.ID }, true);
        public static final UniqueKey<InvoiceStatusRecord> KEY_INVOICE_STATUS_PRIMARY = Internal.createUniqueKey(InvoiceStatus.INVOICE_STATUS, "KEY_invoice_status_PRIMARY", new TableField[] { InvoiceStatus.INVOICE_STATUS.ID }, true);
        public static final UniqueKey<InvoiceTypeRecord> KEY_INVOICE_TYPE_PRIMARY = Internal.createUniqueKey(InvoiceType.INVOICE_TYPE, "KEY_invoice_type_PRIMARY", new TableField[] { InvoiceType.INVOICE_TYPE.ID }, true);
        public static final UniqueKey<LogCardAccessRecord> KEY_LOG_CARD_ACCESS_PRIMARY = Internal.createUniqueKey(LogCardAccess.LOG_CARD_ACCESS, "KEY_log_card_access_PRIMARY", new TableField[] { LogCardAccess.LOG_CARD_ACCESS.ID }, true);
        public static final UniqueKey<LogSystemRecord> KEY_LOG_SYSTEM_PRIMARY = Internal.createUniqueKey(LogSystem.LOG_SYSTEM, "KEY_log_system_PRIMARY", new TableField[] { LogSystem.LOG_SYSTEM.ID }, true);
        public static final UniqueKey<LogUserLoginRecord> KEY_LOG_USER_LOGIN_PRIMARY = Internal.createUniqueKey(LogUserLogin.LOG_USER_LOGIN, "KEY_log_user_login_PRIMARY", new TableField[] { LogUserLogin.LOG_USER_LOGIN.ID }, true);
        public static final UniqueKey<PublisherRecord> KEY_PUBLISHER_PRIMARY = Internal.createUniqueKey(Publisher.PUBLISHER, "KEY_publisher_PRIMARY", new TableField[] { Publisher.PUBLISHER.ID }, true);
        public static final UniqueKey<PublisherRecord> KEY_PUBLISHER_UNIQUE_NAME = Internal.createUniqueKey(Publisher.PUBLISHER, "KEY_publisher_unique_name", new TableField[] { Publisher.PUBLISHER.NAME }, true);
        public static final UniqueKey<TaskQueueRecord> KEY_TASK_QUEUE_PRIMARY = Internal.createUniqueKey(TaskQueue.TASK_QUEUE, "KEY_task_queue_PRIMARY", new TableField[] { TaskQueue.TASK_QUEUE.ID }, true);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", new TableField[] { User.USER.UID }, true);
        public static final UniqueKey<UserRecord> KEY_USER_UNIQUE_SERIAL_ID = Internal.createUniqueKey(User.USER, "KEY_user_unique_serial_id", new TableField[] { User.USER.SERIAL_ID }, true);
        public static final UniqueKey<UserRecord> KEY_USER_UNIQUE_EMAIL = Internal.createUniqueKey(User.USER, "KEY_user_unique_email", new TableField[] { User.USER.EMAIL }, true);
        public static final UniqueKey<UserAccessLevelRecord> KEY_USER_ACCESS_LEVEL_PRIMARY = Internal.createUniqueKey(UserAccessLevel.USER_ACCESS_LEVEL, "KEY_user_access_level_PRIMARY", new TableField[] { UserAccessLevel.USER_ACCESS_LEVEL.ID }, true);
        public static final UniqueKey<UserExtraRecord> KEY_USER_EXTRA_PRIMARY = Internal.createUniqueKey(UserExtra.USER_EXTRA, "KEY_user_extra_PRIMARY", new TableField[] { UserExtra.USER_EXTRA.UID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<BookRecord, UserRecord> FK_CREATOR_UID = Internal.createForeignKey(Keys.KEY_USER_PRIMARY, Book.BOOK, "fk_creator_uid", new TableField[] { Book.BOOK.CREATOR_UID }, true);
        public static final ForeignKey<BookRecord, PublisherRecord> FK_PUBLISHER_ID = Internal.createForeignKey(Keys.KEY_PUBLISHER_PRIMARY, Book.BOOK, "fk_publisher_id", new TableField[] { Book.BOOK.PUBLISHER_ID }, true);
        public static final ForeignKey<BookRecord, BookStatusRecord> FK_BOOK_STATUS = Internal.createForeignKey(Keys.KEY_BOOK_STATUS_PRIMARY, Book.BOOK, "fk_book_status", new TableField[] { Book.BOOK.STATUS }, true);
        public static final ForeignKey<BookAuthorMapRecord, BookRecord> FK_BOOK_AUTHOR_MAP_BOOK_ID = Internal.createForeignKey(Keys.KEY_BOOK_PRIMARY, BookAuthorMap.BOOK_AUTHOR_MAP, "fk_book_author_map_book_id", new TableField[] { BookAuthorMap.BOOK_AUTHOR_MAP.BOOK_ID }, true);
        public static final ForeignKey<BookAuthorMapRecord, AuthorRecord> FK_BOOK_AUTHOR_MAP_AUTHOR_ID = Internal.createForeignKey(Keys.KEY_AUTHOR_PRIMARY, BookAuthorMap.BOOK_AUTHOR_MAP, "fk_book_author_map_author_id", new TableField[] { BookAuthorMap.BOOK_AUTHOR_MAP.AUTHOR_ID }, true);
        public static final ForeignKey<BookBorrowRecord, BookRecord> FK_BOOK_ID = Internal.createForeignKey(Keys.KEY_BOOK_PRIMARY, BookBorrow.BOOK_BORROW, "fk_book_id", new TableField[] { BookBorrow.BOOK_BORROW.BOOK_ID }, true);
        public static final ForeignKey<BookBorrowRecord, UserRecord> FK_BORROWER_UID = Internal.createForeignKey(Keys.KEY_USER_PRIMARY, BookBorrow.BOOK_BORROW, "fk_borrower_uid", new TableField[] { BookBorrow.BOOK_BORROW.BORROWER_UID }, true);
        public static final ForeignKey<InvoiceRecord, InvoiceTypeRecord> FK_TYPE = Internal.createForeignKey(Keys.KEY_INVOICE_TYPE_PRIMARY, Invoice.INVOICE, "fk_type", new TableField[] { Invoice.INVOICE.TYPE }, true);
        public static final ForeignKey<InvoiceRecord, UserRecord> FK_OWNER_UID = Internal.createForeignKey(Keys.KEY_USER_PRIMARY, Invoice.INVOICE, "fk_owner_uid", new TableField[] { Invoice.INVOICE.OWNER_UID }, true);
        public static final ForeignKey<InvoiceRecord, InvoiceStatusRecord> FK_INVOCIE_STATUS = Internal.createForeignKey(Keys.KEY_INVOICE_STATUS_PRIMARY, Invoice.INVOICE, "fk_invocie_status", new TableField[] { Invoice.INVOICE.STATUS }, true);
        public static final ForeignKey<InvoicePenaltyRecord, InvoiceRecord> FK_INVOICE_ID_INVOICE_PENALTY = Internal.createForeignKey(Keys.KEY_INVOICE_PRIMARY, InvoicePenalty.INVOICE_PENALTY, "fk_invoice_id_invoice_penalty", new TableField[] { InvoicePenalty.INVOICE_PENALTY.INVOICE_ID }, true);
        public static final ForeignKey<InvoicePenaltyRecord, BookRecord> FK_BOOK_ID_INVOICE_PENALTY = Internal.createForeignKey(Keys.KEY_BOOK_PRIMARY, InvoicePenalty.INVOICE_PENALTY, "fk_book_id_invoice_penalty", new TableField[] { InvoicePenalty.INVOICE_PENALTY.BOOK_ID }, true);
        public static final ForeignKey<UserRecord, UserAccessLevelRecord> FK_ACCESS_LEVEL = Internal.createForeignKey(Keys.KEY_USER_ACCESS_LEVEL_PRIMARY, User.USER, "fk_access_level", new TableField[] { User.USER.ACCESS_LEVEL }, true);
        public static final ForeignKey<UserExtraRecord, UserRecord> FK_UID = Internal.createForeignKey(Keys.KEY_USER_PRIMARY, UserExtra.USER_EXTRA, "fk_uid", new TableField[] { UserExtra.USER_EXTRA.UID }, true);
    }
}