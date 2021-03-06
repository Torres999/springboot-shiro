/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.records;


import com.torres999.sprintboot.shiro.dao.jooq.tables.T9User;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class T9UserRecord extends UpdatableRecordImpl<T9UserRecord> implements Record8<UInteger, String, String, String, String, Timestamp, Timestamp, Timestamp> {

    private static final long serialVersionUID = -931634674;

    /**
     * Setter for <code>shiro.t9_user.user_id</code>.
     */
    public void setUserId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>shiro.t9_user.user_id</code>.
     */
    public UInteger getUserId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>shiro.t9_user.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>shiro.t9_user.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>shiro.t9_user.nickname</code>.
     */
    public void setNickname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>shiro.t9_user.nickname</code>.
     */
    public String getNickname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>shiro.t9_user.password</code>.
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>shiro.t9_user.password</code>.
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>shiro.t9_user.status</code>.
     */
    public void setStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>shiro.t9_user.status</code>.
     */
    public String getStatus() {
        return (String) get(4);
    }

    /**
     * Setter for <code>shiro.t9_user.last_login_time</code>.
     */
    public void setLastLoginTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>shiro.t9_user.last_login_time</code>.
     */
    public Timestamp getLastLoginTime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>shiro.t9_user.created_time</code>.
     */
    public void setCreatedTime(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>shiro.t9_user.created_time</code>.
     */
    public Timestamp getCreatedTime() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>shiro.t9_user.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>shiro.t9_user.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, String, String, String, String, Timestamp, Timestamp, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, String, String, String, String, Timestamp, Timestamp, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return T9User.T9_USER.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return T9User.T9_USER.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return T9User.T9_USER.NICKNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return T9User.T9_USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return T9User.T9_USER.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return T9User.T9_USER.LAST_LOGIN_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return T9User.T9_USER.CREATED_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return T9User.T9_USER.UPDATE_TIME;
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
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getLastLoginTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getCreatedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value1(UInteger value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value3(String value) {
        setNickname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value4(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value5(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value6(Timestamp value) {
        setLastLoginTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value7(Timestamp value) {
        setCreatedTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord value8(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T9UserRecord values(UInteger value1, String value2, String value3, String value4, String value5, Timestamp value6, Timestamp value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached T9UserRecord
     */
    public T9UserRecord() {
        super(T9User.T9_USER);
    }

    /**
     * Create a detached, initialised T9UserRecord
     */
    public T9UserRecord(UInteger userId, String username, String nickname, String password, String status, Timestamp lastLoginTime, Timestamp createdTime, Timestamp updateTime) {
        super(T9User.T9_USER);

        set(0, userId);
        set(1, username);
        set(2, nickname);
        set(3, password);
        set(4, status);
        set(5, lastLoginTime);
        set(6, createdTime);
        set(7, updateTime);
    }
}
