package com.torres999.sprintboot.shiro.web;

import com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User;
import com.torres999.sprintboot.shiro.shiro.token.TokenManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by t9 on 2018/9/14.
 */
@Slf4j
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login() {
        log.info("Receive a request redirect to Login page!");
        return "login";
    }

    @RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
    public String submitLogin(T9User entity, Boolean rememberMe, HttpServletRequest request) {
        String result;
        try {
            entity = TokenManager.login(entity, rememberMe);
            log.info("Check login user,check parameter {}.:{}", ReflectionToStringBuilder.toString(entity));

            SecurityUtils.getSubject().getSession().touch();
            log.info("Update session success!");

            //获取用户未登录之前的地址
            result = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
            log.info("获取登录之前的URL:{}", result);
            //如果登录之前没有地址，那么就跳转到首页。
            if (StringUtils.isBlank(result)) {
                result = "/index";
            }
        } catch (DisabledAccountException e) {
            log.error("帐号已经禁用。", e);
            result = "帐号已经禁用。";
        } catch (Exception e) {
            log.error("帐号或密码错误。", e);
            result = "帐号或密码错误。";
        }

        return "redirect:" + result;
    }
}
