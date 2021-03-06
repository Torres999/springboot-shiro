/**
 * This class is generated by jOOQ
 */
package com.torres999.sprintboot.shiro.dao.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

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
public class T9User implements Serializable {

    private static final long serialVersionUID = 1936882252;

    private UInteger  userId;
    private String    username;
    private String    nickname;
    private String    password;
    private String    status;
    private Timestamp lastLoginTime;
    private Timestamp createdTime;
    private Timestamp updateTime;

    public T9User() {}

    public T9User(T9User value) {
        this.userId = value.userId;
        this.username = value.username;
        this.nickname = value.nickname;
        this.password = value.password;
        this.status = value.status;
        this.lastLoginTime = value.lastLoginTime;
        this.createdTime = value.createdTime;
        this.updateTime = value.updateTime;
    }

    public T9User(
        UInteger  userId,
        String    username,
        String    nickname,
        String    password,
        String    status,
        Timestamp lastLoginTime,
        Timestamp createdTime,
        Timestamp updateTime
    ) {
        this.userId = userId;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.status = status;
        this.lastLoginTime = lastLoginTime;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }

    public UInteger getUserId() {
        return this.userId;
    }

    public void setUserId(UInteger userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Timestamp getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("T9User (");

        sb.append(userId);
        sb.append(", ").append(username);
        sb.append(", ").append(nickname);
        sb.append(", ").append(password);
        sb.append(", ").append(status);
        sb.append(", ").append(lastLoginTime);
        sb.append(", ").append(createdTime);
        sb.append(", ").append(updateTime);

        sb.append(")");
        return sb.toString();
    }
}
