/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.records;


import com.torres999.sprintboot.shiro.dao.jooq.tables.Users;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record5<UInteger, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -2093055177;

    /**
     * Setter for <code>shiro.users.user_id</code>.
     */
    public void setUserId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>shiro.users.user_id</code>.
     */
    public UInteger getUserId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>shiro.users.user_name</code>.
     */
    public void setUserName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shiro.users.user_name</code>.
     */
    public String getUserName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shiro.users.password</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shiro.users.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shiro.users.created_time</code>.
     */
    public void setCreatedTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>shiro.users.created_time</code>.
     */
    public Timestamp getCreatedTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>shiro.users.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>shiro.users.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<UInteger, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<UInteger, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Users.USERS.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Users.USERS.USER_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Users.USERS.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Users.USERS.CREATED_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Users.USERS.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUserName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getCreatedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(UInteger value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(String value) {
        setUserName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(Timestamp value) {
        setCreatedTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(UInteger value1, String value2, String value3, Timestamp value4, Timestamp value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(UInteger userId, String userName, String password, Timestamp createdTime, Timestamp updateTime) {
        super(Users.USERS);

        set(0, userId);
        set(1, userName);
        set(2, password);
        set(3, createdTime);
        set(4, updateTime);
    }
}
