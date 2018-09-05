/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.daos;


import com.torres999.sprintboot.shiro.dao.jooq.tables.GirlEntity;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.GirlEntityRecord;

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
public class GirlEntityDao extends DAOImpl<GirlEntityRecord, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity, Integer> {

    /**
     * Create a new GirlEntityDao without any configuration
     */
    public GirlEntityDao() {
        super(GirlEntity.GIRL_ENTITY, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity.class);
    }

    /**
     * Create a new GirlEntityDao with an attached configuration
     */
    @Autowired
    public GirlEntityDao(Configuration configuration) {
        super(GirlEntity.GIRL_ENTITY, com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity> fetchById(Integer... values) {
        return fetch(GirlEntity.GIRL_ENTITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity fetchOneById(Integer value) {
        return fetchOne(GirlEntity.GIRL_ENTITY.ID, value);
    }

    /**
     * Fetch records that have <code>age IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity> fetchByAge(Integer... values) {
        return fetch(GirlEntity.GIRL_ENTITY.AGE, values);
    }

    /**
     * Fetch records that have <code>cup_size IN (values)</code>
     */
    public List<com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.GirlEntity> fetchByCupSize(String... values) {
        return fetch(GirlEntity.GIRL_ENTITY.CUP_SIZE, values);
    }
}