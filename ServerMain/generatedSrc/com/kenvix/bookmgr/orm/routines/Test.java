/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.routines;


import com.kenvix.bookmgr.orm.DefaultSchema;

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
public class Test extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 224858653;

    /**
     * The parameter <code>test.max_renew_num</code>.
     */
    public static final Parameter<Short> MAX_RENEW_NUM = Internal.createParameter("max_renew_num", org.jooq.impl.SQLDataType.SMALLINT, false, false);

    /**
     * Create a new routine call instance
     */
    public Test() {
        super("test", DefaultSchema.DEFAULT_SCHEMA);

        addOutParameter(MAX_RENEW_NUM);
    }

    /**
     * Get the <code>max_renew_num</code> parameter OUT value from the routine
     */
    public Short getMaxRenewNum() {
        return get(MAX_RENEW_NUM);
    }
}
