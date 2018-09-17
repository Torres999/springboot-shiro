package com.torres999.sprintboot.shiro.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.torres999.sprintboot.shiro.dao.jooq.Tables.*;

/**
 * Created by t9 on 2018/9/15.
 */
@Slf4j
@Service
public class PermissionService {

    @Autowired
    DSLContext sql;

    public Set<String> findPermissionByUserId(Integer userid) {
        Set<String> sets = new HashSet<>();
        sql.select(
                T9_PERMISSION.PERMISSION_NAME)
                .from(T9_PERMISSION)
                .leftJoin(T9_ROLE_PERMISSION).on(T9_ROLE_PERMISSION.ROLE_ID.eq(T9_PERMISSION.PERMISSION_ID))
                .leftJoin(T9_USER_ROLE).on(T9_USER_ROLE.USER_ID.eq(UInteger.valueOf(userid)))
                .forEach(value -> sets.add(value.get(T9_PERMISSION.PERMISSION_NAME)));
        log.info("Query permission by userid result set:{}", sets.toString());
        return sets;
    }
}
