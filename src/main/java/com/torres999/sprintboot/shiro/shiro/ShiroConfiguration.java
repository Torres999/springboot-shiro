package com.torres999.sprintboot.shiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author t9
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public DefaultSecurityManager getDefaultSecurityManager() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("Mark1", "1231");

//        JdbcRealm jdbcRealm = new JdbcRealm();
//        jdbcRealm.setPermissionsLookupEnabled(true);//默认关闭不会查询权限数据
//        jdbcRealm.setDataSource(null);
//
//        String sql = "select password from t9_user where user_name = ?";
//        jdbcRealm.setAuthenticationQuery(sql);

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // 以下是校验方法
//        Subject subject = SecurityUtils.getSubject();

//        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "1231");
//        subject.login(token);

//        subject.checkPermission("");
//        subject.checkRoles("admin", "admin1");

        return defaultSecurityManager;
    }
}
