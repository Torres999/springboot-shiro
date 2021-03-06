/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.records;


import com.torres999.sprintboot.shiro.dao.jooq.tables.T9UserRole;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
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
public class T9UserRoleRecord extends UpdatableRecordImpl<T9UserRoleRecord> implements Record3<UInteger, UInteger, UInteger> {

    private static final long serialVersionUID = 1461718002;

    /**
     * Setter for <code>shiro.t9_user_role.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>shiro.t9_user_role.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>shiro.t9_user_role.user_id</code>.
     */
    public void setUserId(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>shiro.t9_user_role.user_id</code>.
     */
    public UInteger getUserId() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>shiro.t9_user_role.role_id</code>.
     */
    public void setRoleId(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>shiro.t9_user_role.role_id</code>.
     */
    public UInteger getRoleId() {
        return (UInteger) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UInteger, UInteger, UInteger> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UInteger, UInteger, UInteger> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return T9UserRole.T9_USER_ROLE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field2() {
        return T9UserRole.T9_USER_ROLE.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return T9UserRole.T9_USER_ROLE.ROLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRoleRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRoleRecord value2(UInteger value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRoleRecord value3(UInteger value) {
        setRoleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRoleRecord values(UInteger value1, UInteger value2, UInteger value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached T9UserRoleRecord
     */
    public T9UserRoleRecord() {
        super(T9UserRole.T9_USER_ROLE);
    }

    /**
     * Create a detached, initialised T9UserRoleRecord
     */
    public T9UserRoleRecord(UInteger id, UInteger userId, UInteger roleId) {
        super(T9UserRole.T9_USER_ROLE);

        set(0, id);
        set(1, userId);
        set(2, roleId);
    }
}
