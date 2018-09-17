/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.daos;


import com.torres999.sprintboot.shiro.dao.jooq.tables.T9User;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.T9UserRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
@Repository
public class T9UserDao extends DAOImpl<T9UserRecord, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User, UInteger> {

    /**
     * Create a new T9UserDao without any configuration
     */
    public T9UserDao() {
        super(T9User.T9_USER, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User.class);
    }

    /**
     * Create a new T9UserDao with an attached configuration
     */
    @Autowired
    public T9UserDao(Configuration configuration) {
        super(T9User.T9_USER, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UInteger getId(com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User object) {
        return object.getUserId();
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByUserId(UInteger... values) {
        return fetch(T9User.T9_USER.USER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>user_id = value</code>
     */
    public com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User fetchOneByUserId(UInteger value) {
        return fetchOne(T9User.T9_USER.USER_ID, value);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByUsername(String... values) {
        return fetch(T9User.T9_USER.USERNAME, values);
    }

    /**
     * Fetch records that have <code>nickname IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByNickname(String... values) {
        return fetch(T9User.T9_USER.NICKNAME, values);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByPassword(String... values) {
        return fetch(T9User.T9_USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByStatus(String... values) {
        return fetch(T9User.T9_USER.STATUS, values);
    }

    /**
     * Fetch records that have <code>last_login_time IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByLastLoginTime(Timestamp... values) {
        return fetch(T9User.T9_USER.LAST_LOGIN_TIME, values);
    }

    /**
     * Fetch records that have <code>created_time IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByCreatedTime(Timestamp... values) {
        return fetch(T9User.T9_USER.CREATED_TIME, values);
    }

    /**
     * Fetch records that have <code>update_time IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User> fetchByUpdateTime(Timestamp... values) {
        return fetch(T9User.T9_USER.UPDATE_TIME, values);
    }
}
