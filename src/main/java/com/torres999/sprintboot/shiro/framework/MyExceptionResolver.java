//package com.torres999.sprintboot.shiro.framework;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authz.UnauthorizedException;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author t9
// */
//@Slf4j
//public class MyExceptionResolver implements HandlerExceptionResolver {
//
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
//                                         Object handler, Exception ex) {
//        log.info("==============shiro权限异常开始=============");
//        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
//        if (ex instanceof UnauthorizedException) {
//            ModelAndView mv = new ModelAndView("/403");
//            return mv;
//        }
//        log.error("found exception while resolve", ex);
//        log.info("==============shiro权限异常结束=============");
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
//        return mv;
//    }
//
//}