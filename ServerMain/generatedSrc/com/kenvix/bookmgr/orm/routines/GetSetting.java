/*
 * This file is generated by jOOQ.
 */
package com.kenvix.bookmgr.orm.routines;


import com.kenvix.bookmgr.orm.DefaultSchema;

import javax.annotation.processing.Generated;

import org.jooq.Field;
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
public class GetSetting extends AbstractRoutine<String> {

    private static final long serialVersionUID = 910100409;

    /**
     * The parameter <code>get_setting.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>get_setting.key_v</code>.
     */
    public static final Parameter<String> KEY_V = Internal.createParameter("key_v", org.jooq.impl.SQLDataType.VARCHAR(30), false, false);

    /**
     * Create a new routine call instance
     */
    public GetSetting() {
        super("get_setting", DefaultSchema.DEFAULT_SCHEMA, org.jooq.impl.SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(KEY_V);
    }

    /**
     * Set the <code>key_v</code> parameter IN value to the routine
     */
    public void setKeyV(String value) {
        setValue(KEY_V, value);
    }

    /**
     * Set the <code>key_v</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    public GetSetting setKeyV(Field<String> field) {
        setField(KEY_V, field);
        return this;
    }
}
