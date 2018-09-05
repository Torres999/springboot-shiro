/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.daos;


import com.torres999.sprintboot.shiro.dao.jooq.tables.Author;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.AuthorRecord;

import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
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
public class AuthorDao extends DAOImpl<AuthorRecord, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author, Integer> {

    /**
     * Create a new AuthorDao without any configuration
     */
    public AuthorDao() {
        super(Author.AUTHOR, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author.class);
    }

    /**
     * Create a new AuthorDao with an attached configuration
     */
    @Autowired
    public AuthorDao(Configuration configuration) {
        super(Author.AUTHOR, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author> fetchById(Integer... values) {
        return fetch(Author.AUTHOR.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author fetchOneById(Integer value) {
        return fetchOne(Author.AUTHOR.ID, value);
    }

    /**
     * Fetch records that have <code>first_name IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author> fetchByFirstName(String... values) {
        return fetch(Author.AUTHOR.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>last_name IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author> fetchByLastName(String... values) {
        return fetch(Author.AUTHOR.LAST_NAME, values);
    }

    /**
     * Fetch records that have <code>date_of_birth IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author> fetchByDateOfBirth(Date... values) {
        return fetch(Author.AUTHOR.DATE_OF_BIRTH, values);
    }

    /**
     * Fetch records that have <code>year_of_birth IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author> fetchByYearOfBirth(Integer... values) {
        return fetch(Author.AUTHOR.YEAR_OF_BIRTH, values);
    }

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.Author> fetchByAddress(String... values) {
        return fetch(Author.AUTHOR.ADDRESS, values);
    }
}