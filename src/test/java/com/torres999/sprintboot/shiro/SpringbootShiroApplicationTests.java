package com.torres999.sprintboot.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootShiroApplicationTests {

    @Test
    public void test() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setPermissionsLookupEnabled(true);//默认关闭不会查询权限数据
//        jdbcRealm.setDataSource(dataSource);

        String sql = "select password from users where user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // 以下是校验方法
//        Subject subject = SecurityUtils.getSubject();

//        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "1231");
//        subject.login(token);

//        subject.checkPermission("");
//        subject.checkRoles("admin", "admin1");
    }
}