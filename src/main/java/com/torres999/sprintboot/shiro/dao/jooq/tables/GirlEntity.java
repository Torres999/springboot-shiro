/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables;


import com.torres999.sprintboot.shiro.dao.jooq.Keys;
import com.torres999.sprintboot.shiro.dao.jooq.Shiro;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.GirlEntityRecord;

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
public class GirlEntity extends TableImpl<GirlEntityRecord> {

    private static final long serialVersionUID = 47574528;

    /**
     * The reference instance of <code>shiro.girl_entity</code>
     */
    public static final GirlEntity GIRL_ENTITY = new GirlEntity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GirlEntityRecord> getRecordType() {
        return GirlEntityRecord.class;
    }

    /**
     * The column <code>shiro.girl_entity.id</code>.
     */
    public final TableField<GirlEntityRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>shiro.girl_entity.age</code>.
     */
    public final TableField<GirlEntityRecord, Integer> AGE = createField("age", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>shiro.girl_entity.cup_size</code>.
     */
    public final TableField<GirlEntityRecord, String> CUP_SIZE = createField("cup_size", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * Create a <code>shiro.girl_entity</code> table reference
     */
    public GirlEntity() {
        this("girl_entity", null);
    }

    /**
     * Create an aliased <code>shiro.girl_entity</code> table reference
     */
    public GirlEntity(String alias) {
        this(alias, GIRL_ENTITY);
    }

    private GirlEntity(String alias, Table<GirlEntityRecord> aliased) {
        this(alias, aliased, null);
    }

    private GirlEntity(String alias, Table<GirlEntityRecord> aliased, Field<?>[] parameters) {
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
    public Identity<GirlEntityRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GIRL_ENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GirlEntityRecord> getPrimaryKey() {
        return Keys.KEY_GIRL_ENTITY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GirlEntityRecord>> getKeys() {
        return Arrays.<UniqueKey<GirlEntityRecord>>asList(Keys.KEY_GIRL_ENTITY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GirlEntity as(String alias) {
        return new GirlEntity(alias, this);
    }

    /**
     * Rename this table
     */
    public GirlEntity rename(String name) {
        return new GirlEntity(name, null);
    }
}
