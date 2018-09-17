//package com.torres999.sprintboot.shiro.shiro.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.jooq.tools.json.JSONObject;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
//@Slf4j
//public class ShiroFilterUtils {
//    //登录页面
//    static final String LOGIN_URL = "/login";
//    //踢出登录提示
//    final static String KICKED_OUT = "/open/kickedOut.shtml";
//    //没有权限提醒
//    final static String UNAUTHORIZED = "login";
//
//    /**
//     * 是否是Ajax请求
//     *
//     * @param request
//     * @return
//     */
//    public static boolean isAjax(ServletRequest request) {
//        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
//    }
//
//    /**
//     * response 输出JSON
//     *
//     * @param response
//     * @param resultMap
//     * @throws IOException
//     */
//    public static void out(ServletResponse response, Map<String, String> resultMap) {
//
//        PrintWriter out = null;
//        try {
//            response.setCharacterEncoding("UTF-8");
//            out = response.getWriter();
//            out.println(JSONObject.toJSONString(resultMap).toString());
//        } catch (Exception e) {
//            log.error("输出JSON报错。", e);
//        } finally {
//            if (null != out) {
//                out.flush();
//                out.close();
//            }
//        }
//    }
//}
