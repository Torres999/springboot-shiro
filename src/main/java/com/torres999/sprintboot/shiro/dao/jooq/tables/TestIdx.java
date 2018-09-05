/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables;


import com.torres999.sprintboot.shiro.dao.jooq.Shiro;
import com.torres999.sprintboot.shiro.dao.jooq.tables.records.TestIdxRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * test table
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestIdx extends TableImpl<TestIdxRecord> {

    private static final long serialVersionUID = 61453053;

    /**
     * The reference instance of <code>shiro.test_idx</code>
     */
    public static final TestIdx TEST_IDX = new TestIdx();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TestIdxRecord> getRecordType() {
        return TestIdxRecord.class;
    }

    /**
     * The column <code>shiro.test_idx.type</code>. 类型
     */
    public final TableField<TestIdxRecord, Short> TYPE = createField("type", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "类型");

    /**
     * The column <code>shiro.test_idx.object</code>. key
     */
    public final TableField<TestIdxRecord, String> OBJECT = createField("object", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this, "key");

    /**
     * The column <code>shiro.test_idx.value</code>. value
     */
    public final TableField<TestIdxRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR.length(512).nullable(false), this, "value");

    /**
     * Create a <code>shiro.test_idx</code> table reference
     */
    public TestIdx() {
        this("test_idx", null);
    }

    /**
     * Create an aliased <code>shiro.test_idx</code> table reference
     */
    public TestIdx(String alias) {
        this(alias, TEST_IDX);
    }

    private TestIdx(String alias, Table<TestIdxRecord> aliased) {
        this(alias, aliased, null);
    }

    private TestIdx(String alias, Table<TestIdxRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "test table");
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
    public TestIdx as(String alias) {
        return new TestIdx(alias, this);
    }

    /**
     * Rename this table
     */
    public TestIdx rename(String name) {
        return new TestIdx(name, null);
    }
}