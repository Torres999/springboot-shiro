package com.torres999.sprintboot.shiro.shiro.realm;

import com.torres999.sprintboot.shiro.dao.jooq.tables.pojos.T9User;
import com.torres999.sprintboot.shiro.service.PermissionService;
import com.torres999.sprintboot.shiro.service.RoleService;
import com.torres999.sprintboot.shiro.service.UserService;
import com.torres999.sprintboot.shiro.shiro.token.TokenManager;
import com.torres999.sprintboot.shiro.utils.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Shiro本身是用filter做的，现在提供两种方式进行验证，一种是realm（整个框架的一部分），另一种的集成AuthorizationFilter
 *
 * @author t9
 */
@Slf4j
public class T9Realm extends AuthorizingRealm {

    @Autowired
    public PermissionService permissionService;

    @Autowired
    public RoleService roleService;

    @Autowired
    public UserService userService;

    // 盐
    private final static String SALT = "TTTTT999999";

    //模拟数据库或缓存的数据
    Map<String, String> userMap = new HashMap<>();

    {
//		Md5Hash md5 = new Md5Hash("123456");	//加密
//		userMap.put("Mark", "123456");
        Md5Hash md5 = new Md5Hash("1234567", SALT);//加盐
        userMap.put("Mark", md5.toString());
        super.setName("customRealm--");
    }

    public static void main(String[] args) {
        Md5Hash md5 = new Md5Hash("1234567", SALT);//加盐
        System.out.println("args = [" + md5 + "]");
    }

    /**
     * 授权
     * 默认是从缓存中获取
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("---------------------------------------------");
        log.info("Method doGetAuthorizationInfo been executed!");
        log.info("---------------------------------------------");

//        String username = (String) principalCollection.getPrimaryPrincipal();
        Integer userId = TokenManager.getUserId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //根据用户ID查询角色（role），放入到Authorization里。
        Set<String> roles = roleService.findRoleByUserId(userId);
        if (CollectionUtils.isNotEmpty(roles)) {
            info.setRoles(roles);
        }

        //根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = permissionService.findPermissionByUserId(userId);
        if (CollectionUtils.isNotEmpty(roles)) {
            info.setStringPermissions(permissions);
        }
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("【doGetAuthenticationInfo】Method doGetAuthenticationInfo been executed!");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        log.info("【doGetAuthenticationInfo】 token:" + ReflectionToStringBuilder.reflectionToString(token));

        if (null == token.getPassword()) {
            log.info("帐号或密码不正确！");
            throw new AccountException("帐号或密码不正确！");
        }

        T9User user = userService.login(token.getUsername(), String.copyValueOf(token.getPassword()));
        log.info("【doGetAuthenticationInfo】 user:" + ReflectionToStringBuilder.reflectionToString(user));
        if (null == user) {
            log.info("【doGetAuthenticationInfo】 帐号或密码不正确！");
            throw new AccountException("帐号或密码不正确！");
        } else if (Users.STATUS_0.equals(user.getStatus())) {
            log.info("【doGetAuthenticationInfo】 帐号已经禁止登录！");
            throw new DisabledAccountException("帐号已经禁止登录！");
        } else {
            //更新登录时间 last login time
            log.info("【doGetAuthenticationInfo】 登陆成功，修改最后登陆时间！");
            user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            userService.updateLastLoginTime(user);
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        //加盐
//        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return simpleAuthenticationInfo;
    }

    //TODO
    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    //TODO
    /**
     * 指定principalCollection清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
