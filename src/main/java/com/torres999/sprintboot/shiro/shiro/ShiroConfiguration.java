package com.torres999.sprintboot.shiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author t9
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public DefaultSecurityManager getDefaultSecurityManager() { //该方式注解@RequiresRoles不会生效
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("Mark1", "1231", "admin");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        return defaultSecurityManager;
    }

//    @Bean
//    public SecurityManager securityManager() {
//        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
//        simpleAccountRealm.addAccount("Mark1", "1231", "admin");
//
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(simpleAccountRealm);
//
//        SecurityUtils.setSecurityManager(securityManager);
//
//        return securityManager;
//    }

    /**
     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
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


}
