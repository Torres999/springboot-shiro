/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables;


import com.torres999.sprintboot.shiro.dao.jooq.Keys;
import com.torres999.sprintboot.shiro.dao.jooq.Shiro;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.T9UserRoleRecord;

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
public class T9UserRole extends TableImpl<T9UserRoleRecord> {

    private static final long serialVersionUID = 2071458477;

    /**
     * The reference instance of <code>shiro.t9_user_role</code>
     */
    public static final T9UserRole T9_USER_ROLE = new T9UserRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<T9UserRoleRecord> getRecordType() {
        return T9UserRoleRecord.class;
    }

    /**
     * The column <code>shiro.t9_user_role.id</code>.
     */
    public final TableField<T9UserRoleRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>shiro.t9_user_role.user_id</code>.
     */
    public final TableField<T9UserRoleRecord, UInteger> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>shiro.t9_user_role.role_id</code>.
     */
    public final TableField<T9UserRoleRecord, UInteger> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * Create a <code>shiro.t9_user_role</code> table reference
     */
    public T9UserRole() {
        this("t9_user_role", null);
    }

    /**
     * Create an aliased <code>shiro.t9_user_role</code> table reference
     */
    public T9UserRole(String alias) {
        this(alias, T9_USER_ROLE);
    }

    private T9UserRole(String alias, Table<T9UserRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private T9UserRole(String alias, Table<T9UserRoleRecord> aliased, Field<?>[] parameters) {
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
    public Identity<T9UserRoleRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T9_USER_ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<T9UserRoleRecord> getPrimaryKey() {
        return Keys.KEY_T9_USER_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<T9UserRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<T9UserRoleRecord>>asList(Keys.KEY_T9_USER_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRole as(String alias) {
        return new T9UserRole(alias, this);
    }

    /**
     * Rename this table
     */
    public T9UserRole rename(String name) {
        return new T9UserRole(name, null);
    }
}
