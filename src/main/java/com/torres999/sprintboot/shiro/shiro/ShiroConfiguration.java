package com.torres999.sprintboot.shiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author t9
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 有了SecurityManager，好像整个方法不生效了
     *
     * @return
     */
    @Bean
    public DefaultSecurityManager getDefaultSecurityManager() { //该方式注解@RequiresRoles不会生效
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("Mark1", "1231", "admin");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);


        return defaultSecurityManager;
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;但是测试没成功
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * 该方法启用后会强制跳转到/login页面，为了测试，加了put("/*", "anon")这句才通过的
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/errorView/403_error.html");//不生效(详情原因看MyExceptionResolver)


        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/testPerms", "perms[user：get]");
        //配置记住我或认证通过可以访问的地址
        filterChainDefinitionMap.put("/testPerms1", "roles[admin1]");//这里验证时候用的角色是下面那个方法中的account不是第一个方法中的account
//        //开放的静态资源
//        filterChainDefinitionMap.put("/favicon.ico", "anon");//网站图标
//        filterChainDefinitionMap.put("/springboot-shiro/**", "anon");//配置static文件下资源能被访问的，这是个例子
//        filterChainDefinitionMap.put("/kaptcha.jpg", "anon");//图片验证码(kaptcha框架)
        filterChainDefinitionMap.put("/*", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 配合上一个方法使用，否则启动报错。
     * 但是不用上一个方法的时候，单独打开这个方法会报：SessionContext must be an HTTP compatible implementation.
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("Mark1", "1231", "admin1");

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(securityManager);

        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }


    //=====================================================================================

    /**
     * cookie管理对象;
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * cookie对象;
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //记住我cookie生效时间，经过测试大概是两天多
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

}
