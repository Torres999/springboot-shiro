/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class TestIdx implements Serializable {

    private static final long serialVersionUID = 296251624;

    private Short  type;
    private String object;
    private String value;

    public TestIdx() {}

    public TestIdx(TestIdx value) {
        this.type = value.type;
        this.object = value.object;
        this.value = value.value;
    }

    public TestIdx(
        Short  type,
        String object,
        String value
    ) {
        this.type = type;
        this.object = object;
        this.value = value;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getObject() {
        return this.object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TestIdx (");

        sb.append(type);
        sb.append(", ").append(object);
        sb.append(", ").append(value);

        sb.append(")");
        return sb.toString();
    }
}
