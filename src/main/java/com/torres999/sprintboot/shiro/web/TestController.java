package com.torres999.sprintboot.shiro.web;

import com.torres999.sprintboot.shiro.dao.jooq.tables.records.UsersRecord;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author t9
 */
@RestController
public class TestController {


    // http://localhost:6181/shiro/hi?userName=Mark1&password=1231
    // 具体的用户名和密码参考ShiroConfiguration中的SimpleAccountRealm
    @GetMapping(value = "/hi",
            produces = "application/json;charset=utf-8")
    public String findList(UsersRecord users) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUserName(), users.getPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return "没有权限!";
        }

        return "Hello World!";
    }
}
