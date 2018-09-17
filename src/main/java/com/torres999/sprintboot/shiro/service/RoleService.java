package com.torres999.sprintboot.shiro.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.torres999.sprintboot.shiro.dao.jooq.Tables.T9_ROLE;
import static com.torres999.sprintboot.shiro.dao.jooq.Tables.T9_USER_ROLE;

/**
 * Created by t9 on 2018/9/15.
 */
@Slf4j
@Service
public class RoleService {

    @Autowired
    DSLContext sql;


    public Set<String> findRoleByUserId(Integer userId) {
        Set<String> sets = new HashSet<>();
        sql.select(
                T9_ROLE.ROLE_NAME)
                .from(T9_ROLE)
                .leftJoin(T9_USER_ROLE).on(T9_USER_ROLE.ROLE_ID.eq(T9_ROLE.ROLE_ID)
                .and(
                        T9_USER_ROLE.USER_ID.eq(UInteger.valueOf(userId))
                ))
                .forEach(value -> sets.add(value.get(T9_ROLE.ROLE_NAME)));
        log.info("Query role result set is:{}", sets.toString());
        return sets;
    }
}
