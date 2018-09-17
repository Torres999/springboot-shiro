package com.torres999.sprintboot.shiro.framework;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * User: t9
 * Date: 2018/8/16
 */
@Slf4j
//@Component
//@ControllerAdvice
//@RestControllerAdvice
public class CardExceptionHandler {

    @ExceptionHandler(value = UnauthenticatedException.class)
    public Object defaultUnauthenticatedExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        log.warn("没有登陆", e);
        JsonObject object = new JsonObject();
        JsonObject errorData = new JsonObject();
        object.addProperty("code", Integer.parseInt(ExceptionCode.BACK_APPLY_ERROR_5002.getCode()));
        object.addProperty("info", ExceptionCode.BACK_APPLY_ERROR_5002.getMessage());
        object.add("data", errorData);
        return object.toString();
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public Object defaultAuthorizationExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        log.warn("没有访问权限", e);
        JsonObject object = new JsonObject();
        JsonObject errorData = new JsonObject();
        object.addProperty("code", Integer.parseInt(ExceptionCode.BACK_APPLY_ERROR_5001.getCode()));
        object.addProperty("info", ExceptionCode.BACK_APPLY_ERROR_5001.getMessage());
        object.add("data", errorData);
        return object.toString();
    }

    @ExceptionHandler(value = Exception.class)
    public Object defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        log.warn("服务端异常", e);
        JsonObject object = new JsonObject();
        JsonObject errorData = new JsonObject();
        object.addProperty("code", Integer.parseInt(ExceptionCode.BACK_SERVER_ERROR_5000.getCode()));
        object.addProperty("info", ExceptionCode.BACK_SERVER_ERROR_5000.getMessage());
        object.add("data", errorData);
        return object.toString();
    }
}