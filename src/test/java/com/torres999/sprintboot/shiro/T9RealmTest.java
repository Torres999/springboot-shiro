//package com.torres999.sprintboot.shiro.shiro.realm;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.subject.Subject;
////import org.junit.Test;
//
///**
// * @author t9
// */
//public class T9RealmTest {
//
//    T9Realm customRealm = new T9Realm();
//
//
////    @Test
//    public void testAuthentication() {
//        // 1.构建SecurityManager环境
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        defaultSecurityManager.setRealm(customRealm);
//
//        //声明CustomRealm使用了Md5加密，加密管理器对象
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//        matcher.setHashAlgorithmName("md5");
//        matcher.setHashIterations(1);
//        customRealm.setCredentialsMatcher(matcher);
//
//        // 2.主题提交认证请求
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//        Subject subject = SecurityUtils.getSubject();
//
//        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
//        subject.login(token);
//        System.out.println("是否登录:" + subject.isAuthenticated());
//
//        subject.checkRoles("admin");	//授权
//        subject.checkPermission("user:delete");
//
//        subject.logout();
//        System.out.println("是否登录:" + subject.isAuthenticated());
//    }
//
//}