package com.torres999.sprintboot.shiro.shiro;

import com.torres999.sprintboot.shiro.shiro.realm.T9Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t9
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 有了SecurityManager，好像整个方法不生效了
     * 主要的方法，但是可以使用意外一种形式：securityManager()
     *
     * @return
     */
//    @Bean
//    public DefaultSecurityManager getDefaultSecurityManager() { //该方式注解@RequiresRoles不会生效
//        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
//        simpleAccountRealm.addAccount("Mark1", "1231", "admin");
//
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(simpleAccountRealm);
//
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//
//
//        return defaultSecurityManager;
//    }

    /**
     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持
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

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }


    /**
     * 该方法启用后会强制跳转到/login页面，为了测试，加了put("/*", "anon")这句才通过的
     * 如果在controller的method上加@RequiresRoles 等注解的方式，只会返回错误
     * 如果使用该方法的ShiroFilterFactoryBean配置规则会进行页面的跳转
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
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");


        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
//        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/testPerms", "perms['/testPerms']");
        filterChainDefinitionMap.put("/testPerms", "roles[admin]");
//        filterChainDefinitionMap.put("/testPerms", "perms[user：get]");
//        //配置记住我或认证通过可以访问的地址
//        filterChainDefinitionMap.put("/testPerms1", "roles[admin1]");//这里验证时候用的角色是下面那个方法中的account不是第一个方法中的account
//        //开放的静态资源
        filterChainDefinitionMap.put("/favicon.ico", "anon");//网站图标
        filterChainDefinitionMap.put("/springboot-shiro/**", "anon");//配置static文件下资源能被访问的，这是个例子
        filterChainDefinitionMap.put("/**.jpg", "anon");//图片验证码(kaptcha框架)
        filterChainDefinitionMap.put("/submitLogin", "anon");
        filterChainDefinitionMap.put("/*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配合上一个方法使用，否则启动报错。
     * 但是不用上一个方法的时候，单独打开这个方法会报：SessionContext must be an HTTP compatible implementation.
     * 主要的方法，但是可以使用意外一种形式：getDefaultSecurityManager()
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        List list = new ArrayList<>();
        list.add(getT9Realm());

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(simpleAccountRealm);
        securityManager.setRealms(list);
        securityManager.setSessionManager(getSessionManager());
        securityManager.setRememberMeManager(rememberMeManager());

        SecurityUtils.setSecurityManager(securityManager);

        return securityManager;
    }

    @Bean
    public T9Realm getT9Realm() {
        T9Realm t9Realm = new T9Realm();
        return t9Realm;
    }

//    @Bean
//    public MyExceptionResolver getMyExceptionResolver() {
//        return new MyExceptionResolver();
//    }


    //========================================session=============================================
    @Bean
    public DefaultWebSessionManager getSessionManager() {
        // 配置Session DAO的操作处理
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");//设置session缓存的名字，这个名字可以任意
        sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());//定义该Session DAO操作中所使用的ID生成器


        // 配置需要向Cookie中保存数据的配置模版,定义session与客户端的之间的联系
        SimpleCookie sessionIdCookie = new SimpleCookie("mldn-session-id");//在Tomcat运行下默认使用的Cookie的名字为JSESSIONID
        sessionIdCookie.setHttpOnly(true);//保证该系统不会受到跨域的脚本操作攻击
        sessionIdCookie.setMaxAge(-1);//定义Cookie的过期时间，单位为秒，如果设置为-1表示浏览器关闭，则Cookie消失


        // 会话管理器
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1000000);//session 有效时间为半小时 （毫秒单位）
        sessionManager.setDeleteInvalidSessions(true);//删除所有无效的Session对象，此时的session被保存在了内存里面
//        sessionManager.setSessionValidationScheduler(getQuartzSessionValidationScheduler());//调度器间隔多少时间检查，不配置是60分钟
        sessionManager.setSessionValidationSchedulerEnabled(true);//需要让此session可以使用该定时调度器进行检测
        sessionManager.setSessionDAO(sessionDAO);//定义Session可以进行序列化的工具类
        sessionManager.setSessionIdCookie(sessionIdCookie);//所有的session一定要将id设置到Cookie之中，需要提供有Cookie的操作模版
        sessionManager.setSessionIdCookieEnabled(true);//定义sessionIdCookie模版可以进行操作的启用
        sessionManager.setDeleteInvalidSessions(true);//是否删除无效的，默认也是开启
        //sessionManager.setSessionListeners();//session 监听，可以多个


        return sessionManager;
    }

    /**
     * 所有的session一定要在用户正确离开之后才能够进行资源的释放，但是用户如果不点注销，不能够进行session的清空处理，
     * 所以为了防止这样的问题，还需要增加有一个会话的验证调度器。
     *
     * @return
     */
    @Bean
    public QuartzSessionValidationScheduler getQuartzSessionValidationScheduler() {
        QuartzSessionValidationScheduler scheduler = new QuartzSessionValidationScheduler();
        scheduler.setSessionValidationInterval(100000);//相隔多久检查一次session的有效性，单位为毫秒
        scheduler.setSessionManager(getSessionManager());//随后还需要定义有一个会话管理器的程序类的引用

        return scheduler;
    }


    //========================================cookie=============================================

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