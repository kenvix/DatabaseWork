/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.routines;


import com.kenvix.bookmgr.orm.DefaultSchema;

import javax.annotation.processing.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TruncateArchiveTable extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>truncate_archive_table.table_name</code>.
     */
    public static final Parameter<String> TABLE_NAME = Internal.createParameter("table_name", SQLDataType.VARCHAR(100), false, false);

    /**
     * Create a new routine call instance
     */
    public TruncateArchiveTable() {
        super("truncate_archive_table", DefaultSchema.DEFAULT_SCHEMA);

        addInParameter(TABLE_NAME);
    }

    /**
     * Set the <code>table_name</code> parameter IN value to the routine
     */
    public void setTableName(String value) {
        setValue(TABLE_NAME, value);
    }
}
