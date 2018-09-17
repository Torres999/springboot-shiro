package com.torres999.sprintboot.shiro.service;

import com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.torres999.sprintboot.shiro.dao.jooq.tables.T9User.T9_USER;

/**
 * Created by t9 on 2018/9/15.
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    DSLContext sql;

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    public T9User login(String username, String password) {
        Record result = sql.select(
                T9_USER.USER_ID,
                T9_USER.USERNAME,
                T9_USER.PASSWORD)
                .from(T9_USER)
                .where(T9_USER.USERNAME.eq(username)
                        .and(T9_USER.PASSWORD.eq(password)))
                .fetchAny();
        if (result == null) {
            log.info("Query user by username&password result size is 0 while login.");
            return null;
        } else {
            log.info("Query user by username&password result size is {} while login.", result.fieldsRow().size());
            T9User user = new T9User();
            user.setUserId(result.get(T9_USER.USER_ID));
            user.setUsername(result.get(T9_USER.USERNAME));
            user.setPassword(result.get(T9_USER.PASSWORD));
            return user;
        }
    }

    /**
     * 修改最后一次登陆时间
     *
     * @param entity
     * @return
     */
    public int updateLastLoginTime(T9User entity) {
        log.info("Update last login time,update parameter {}." + ReflectionToStringBuilder.reflectionToString(entity));
        int i = sql.update(T9_USER).set(T9_USER.LAST_LOGIN_TIME, entity.getLastLoginTime())
                .where(T9_USER.USER_ID.eq(entity.getUserId())).execute();
        log.info("Updated row num:{}", i);
        return i;
    }
}
