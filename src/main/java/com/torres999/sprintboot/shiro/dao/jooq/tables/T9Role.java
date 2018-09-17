/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables;


import com.torres999.sprintboot.shiro.dao.jooq.Keys;
import com.torres999.sprintboot.shiro.dao.jooq.Shiro;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.T9RoleRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class T9Role extends TableImpl<T9RoleRecord> {

    private static final long serialVersionUID = 952529539;

    /**
     * The reference instance of <code>shiro.t9_role</code>
     */
    public static final T9Role T9_ROLE = new T9Role();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<T9RoleRecord> getRecordType() {
        return T9RoleRecord.class;
    }

    /**
     * The column <code>shiro.t9_role.role_id</code>.
     */
    public final TableField<T9RoleRecord, UInteger> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>shiro.t9_role.role_name</code>.
     */
    public final TableField<T9RoleRecord, String> ROLE_NAME = createField("role_name", org.jooq.impl.SQLDataType.VARCHAR.length(64), this, "");

    /**
     * The column <code>shiro.t9_role.created_time</code>.
     */
    public final TableField<T9RoleRecord, Timestamp> CREATED_TIME = createField("created_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>shiro.t9_role.update_time</code>.
     */
    public final TableField<T9RoleRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>shiro.t9_role</code> table reference
     */
    public T9Role() {
        this("t9_role", null);
    }

    /**
     * Create an aliased <code>shiro.t9_role</code> table reference
     */
    public T9Role(String alias) {
        this(alias, T9_ROLE);
    }

    private T9Role(String alias, Table<T9RoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private T9Role(String alias, Table<T9RoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Shiro.SHIRO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<T9RoleRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T9_ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<T9RoleRecord> getPrimaryKey() {
        return Keys.KEY_T9_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<T9RoleRecord>> getKeys() {
        return Arrays.<UniqueKey<T9RoleRecord>>asList(Keys.KEY_T9_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9Role as(String alias) {
        return new T9Role(alias, this);
    }

    /**
     * Rename this table
     */
    public T9Role rename(String name) {
        return new T9Role(name, null);
    }
}