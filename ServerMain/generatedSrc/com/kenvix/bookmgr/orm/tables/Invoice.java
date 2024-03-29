/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.tables;


import com.kenvix.bookmgr.orm.DefaultSchema;
import com.kenvix.bookmgr.orm.Keys;
import com.kenvix.bookmgr.orm.tables.records.InvoiceRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.JSON;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 账单，包括罚款
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Invoice extends TableImpl<InvoiceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>invoice</code>
     */
    public static final Invoice INVOICE = new Invoice();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InvoiceRecord> getRecordType() {
        return InvoiceRecord.class;
    }

    /**
     * The column <code>invoice.id</code>. 订单ID
     */
    public final TableField<InvoiceRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "订单ID");

    /**
     * The column <code>invoice.name</code>. 订单名称
     */
    public final TableField<InvoiceRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "订单名称");

    /**
     * The column <code>invoice.type</code>. 订单类型
     */
    public final TableField<InvoiceRecord, Short> TYPE = createField(DSL.name("type"), SQLDataType.SMALLINT.nullable(false), this, "订单类型");

    /**
     * The column <code>invoice.owner_uid</code>. 付款人UID
     */
    public final TableField<InvoiceRecord, Long> OWNER_UID = createField(DSL.name("owner_uid"), SQLDataType.BIGINT.nullable(false), this, "付款人UID");

    /**
     * The column <code>invoice.should_pay</code>. 应付金额
     */
    public final TableField<InvoiceRecord, Integer> SHOULD_PAY = createField(DSL.name("should_pay"), SQLDataType.INTEGER.nullable(false), this, "应付金额");

    /**
     * The column <code>invoice.created_at</code>. 创建时间
     */
    public final TableField<InvoiceRecord, Timestamp> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.TIMESTAMP(0).nullable(false).defaultValue(DSL.inline("0000-00-00 00:00:00", SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>invoice.status</code>. 订单状态
     */
    public final TableField<InvoiceRecord, Byte> STATUS = createField(DSL.name("status"), SQLDataType.TINYINT.nullable(false), this, "订单状态");

    /**
     * The column <code>invoice.expire_at</code>. 订单过期时间
     */
    public final TableField<InvoiceRecord, Timestamp> EXPIRE_AT = createField(DSL.name("expire_at"), SQLDataType.TIMESTAMP(0).nullable(false).defaultValue(DSL.inline("2038-01-19 00:00:00", SQLDataType.TIMESTAMP)), this, "订单过期时间");

    /**
     * The column <code>invoice.paid_at</code>. 订单支付时间,NULL为没付
     */
    public final TableField<InvoiceRecord, Timestamp> PAID_AT = createField(DSL.name("paid_at"), SQLDataType.TIMESTAMP(0), this, "订单支付时间,NULL为没付");

    /**
     * The column <code>invoice.comment</code>. 订单备注
     */
    public final TableField<InvoiceRecord, String> COMMENT = createField(DSL.name("comment"), SQLDataType.CLOB, this, "订单备注");

    /**
     * The column <code>invoice.extra_data</code>. 保留备用。特定订单驱动可读的数据信息
     */
    public final TableField<InvoiceRecord, JSON> EXTRA_DATA = createField(DSL.name("extra_data"), SQLDataType.JSON, this, "保留备用。特定订单驱动可读的数据信息");

    private Invoice(Name alias, Table<InvoiceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Invoice(Name alias, Table<InvoiceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("账单，包括罚款"), TableOptions.table());
    }

    /**
     * Create an aliased <code>invoice</code> table reference
     */
    public Invoice(String alias) {
        this(DSL.name(alias), INVOICE);
    }

    /**
     * Create an aliased <code>invoice</code> table reference
     */
    public Invoice(Name alias) {
        this(alias, INVOICE);
    }

    /**
     * Create a <code>invoice</code> table reference
     */
    public Invoice() {
        this(DSL.name("invoice"), null);
    }

    public <O extends Record> Invoice(Table<O> child, ForeignKey<O, InvoiceRecord> key) {
        super(child, key, INVOICE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<InvoiceRecord, Long> getIdentity() {
        return (Identity<InvoiceRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<InvoiceRecord> getPrimaryKey() {
        return Keys.KEY_INVOICE_PRIMARY;
    }

    @Override
    public List<UniqueKey<InvoiceRecord>> getKeys() {
        return Arrays.<UniqueKey<InvoiceRecord>>asList(Keys.KEY_INVOICE_PRIMARY);
    }

    @Override
    public List<ForeignKey<InvoiceRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<InvoiceRecord, ?>>asList(Keys.FK_TYPE, Keys.FK_OWNER_UID, Keys.FK_INVOCIE_STATUS);
    }

    public InvoiceType invoiceType() {
        return new InvoiceType(this, Keys.FK_TYPE);
    }

    public User user() {
        return new User(this, Keys.FK_OWNER_UID);
    }

    public InvoiceStatus invoiceStatus() {
        return new InvoiceStatus(this, Keys.FK_INVOCIE_STATUS);
    }

    @Override
    public Invoice as(String alias) {
        return new Invoice(DSL.name(alias), this);
    }

    @Override
    public Invoice as(Name alias) {
        return new Invoice(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Invoice rename(String name) {
        return new Invoice(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Invoice rename(Name name) {
        return new Invoice(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, String, Short, Long, Integer, Timestamp, Byte, Timestamp, Timestamp, String, JSON> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}
