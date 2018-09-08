package com.torres999.sprintboot.shiro.web;

import com.torres999.sprintboot.shiro.dao.jooq.tables.records.UsersRecord;
import com.torres999.sprintboot.shiro.utils.Roles;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author t9
 */
@Slf4j
@RestController
public class TestController {


    // http://localhost:6181/shiro/hi?userName=Mark1&password=1231
    // 具体的用户名和密码参考ShiroConfiguration中的SimpleAccountRealm
    @GetMapping(value = "/hi", produces = "application/json;charset=utf-8")
    public String findList(UsersRecord users) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        log.info("*********************************");
        log.info("get a request, subject is " + subject.toString());
        log.info("*********************************");
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUserName(), users.getPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return "没有权限!";
        } catch (IllegalArgumentException e) {
            return "没有权限! SessionContext must be an HTTP compatible implementation.";
        }

        if (subject.hasRole(Roles.ADMIN)) {
            return "有admin权限!";
        }

        if (subject.hasRole(Roles.MANAGER)) {
            return "有manager权限!";
        }


        return "Hello World!";
    }


    /**
     * 通过注解设置角色权限为admin才可访问，但是没有成功
     * 用来测试这个url和ShiroConfiguration中的account的role不一样，永远不能访问成功
     *
     * @return
     */
    @RequiresRoles(Roles.ADMIN)
    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
    @ResponseBody
    public String testRole() {
        return "test role success";
    }


    /**
     * 以下两个方法是用来测试ShiroConfiguration中的ShiroFilterFactoryBean
     *
     * @return
     */
    @RequestMapping(value = "/testPerms", method = RequestMethod.GET)
    @ResponseBody
    public String testPerms() {
        return "test roles success";
    }

    @RequestMapping(value = "/testPerms1", method = RequestMethod.GET)
    @ResponseBody
    public String testPerms1() {
        return "test roles1 success";
    }


    @GetMapping(value = "/remember", produces = "application/json;charset=utf-8")
    public String testRemember(UsersRecord users, boolean remember) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUserName(), users.getPassword());

        try {
            token.setRememberMe(remember);
            subject.login(token);
        } catch (AuthenticationException e) {
            return "没有权限!";
        } catch (IllegalArgumentException e) {
            return "没有权限! SessionContext must be an HTTP compatible implementation.";
        }


        return "Hello World!";
    }
}
