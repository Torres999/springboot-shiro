/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

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
public class T9RolePermission implements Serializable {

    private static final long serialVersionUID = 1933464598;

    private UInteger id;
    private UInteger permissionId;
    private UInteger roleId;

    public T9RolePermission() {}

    public T9RolePermission(T9RolePermission value) {
        this.id = value.id;
        this.permissionId = value.permissionId;
        this.roleId = value.roleId;
    }

    public T9RolePermission(
        UInteger id,
        UInteger permissionId,
        UInteger roleId
    ) {
        this.id = id;
        this.permissionId = permissionId;
        this.roleId = roleId;
    }

    public UInteger getId() {
        return this.id;
    }

    public void setId(UInteger id) {
        this.id = id;
    }

    public UInteger getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(UInteger permissionId) {
        this.permissionId = permissionId;
    }

    public UInteger getRoleId() {
        return this.roleId;
    }

    public void setRoleId(UInteger roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("T9RolePermission (");

        sb.append(id);
        sb.append(", ").append(permissionId);
        sb.append(", ").append(roleId);

        sb.append(")");
        return sb.toString();
    }
}