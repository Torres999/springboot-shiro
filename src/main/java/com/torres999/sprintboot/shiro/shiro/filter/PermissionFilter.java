//package com.torres999.sprintboot.shiro.shiro.filter;
//
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.util.StringUtils;
//import org.apache.shiro.web.filter.AccessControlFilter;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author t9
// */
//public class PermissionFilter extends AccessControlFilter {
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,
//                                      Object mappedValue) throws Exception {
//
//        //先判断带参数的权限判断
//        Subject subject = getSubject(request, response);
//        if(null != mappedValue){
//            String[] arra = (String[])mappedValue;
//            for (String permission : arra) {
//                if(subject.isPermitted(permission)){
//                    return Boolean.TRUE;
//                }
//            }
//        }
//        //取到请求的uri ，进行权限判断
//        String uri = ((HttpServletRequest)request).getRequestURI();
//        if(subject.isPermitted(uri)){
//            return Boolean.TRUE;
//        }
//        return Boolean.FALSE;
//    }
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//
//        Subject subject = getSubject(request, response);
//        if (null == subject.getPrincipal()) {//表示没有登录，重定向到登录页面
//            saveRequest(request);
//            WebUtils.issueRedirect(request, response, ShiroFilterUtils.LOGIN_URL);
//        } else {
//            if (StringUtils.hasText(ShiroFilterUtils.UNAUTHORIZED)) {//如果有未授权页面跳转过去
//                WebUtils.issueRedirect(request, response, ShiroFilterUtils.UNAUTHORIZED);
//            } else {//否则返回401未授权状态码
//                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            }
//        }
//        return Boolean.FALSE;
//    }
//}