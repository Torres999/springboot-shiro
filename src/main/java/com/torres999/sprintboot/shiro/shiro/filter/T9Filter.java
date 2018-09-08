package com.torres999.sprintboot.shiro.shiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 拦截器.
 * rest：比如/admins/user/**=rest[user],根据请求的方法，相当于/admins/user/**=perms[user：method] ,其中method为post，get，delete等。
 * anon：比如/admins/**=anon 没有参数，表示可以匿名使用。
 * authcBasic：比如/admins/user/**=authcBasic没有参数表示httpBasic认证
 * authc：比如/admins/user/**=authc表示需要认证才能使用，没有参数
 * user：比如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查
 * <p>
 * perms：比如/admins/user/**=perms[user：add：*],perms参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，比如/admins/user/**=perms["user：add：*,user：modify：*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
 * roles：比如/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，比如/admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。//要实现or的效果看http://zgzty.blog.163.com/blog/static/83831226201302983358670/
 * port：比如/admins/user/**=port[8081],当请求的url的端口不是8081是跳转到schemal：* serverName：8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
 * ssl：比如/admins/user/**=ssl没有参数，表示安全的url请求，协议为https
 *
 * @author t9
 */
@Slf4j
public class T9Filter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse,
                                      Object o) throws Exception {
        log.info("=======================================");
        log.info("catch a request by T9Filter with Shiro!");
        log.info("=======================================");
        Subject subject = getSubject(servletRequest, servletResponse);

        String[] roles = (String[]) o;

        if (roles == null || roles.length == 0) {
            return true;
        }

        for (String role : roles) {
            if (subject.hasRole(role)) {
                return true;
            }
        }

        return true;
    }
}
