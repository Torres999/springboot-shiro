package com.torres999.sprintboot.shiro.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Shiro本身是用filter做的，现在提供两种方式进行验证，一种是realm（整个框架的一部分），另一种的集成AuthorizationFilter
 *
 * @author t9
 */
public class T9Realm extends AuthorizingRealm {

    // 盐
    private final static String SALT = "Mark";


    //模拟数据库或缓存的数据
    Map<String, String> userMap = new HashMap<>();

    {
//		Md5Hash md5 = new Md5Hash("123456");	//加密
        Md5Hash md5 = new Md5Hash("123456", SALT);//加盐
        userMap.put("Mark", md5.toString());
//		userMap.put("Mark", "123456");
        super.setName("customRealm--");
    }


    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库或者缓存中获得角色数据
        Set<String> roles = getRolesByUserName(username);
        Set<String> permissions = getPermissionsByUserName(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionsByUserName(String username) {
        Set<String> sets = new HashSet<>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }

    private Set<String> getRolesByUserName(String username) {
        Set<String> sets = new HashSet<>();
        sets.add("admin");
        sets.add("user");
        return sets;
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
        // 1.从主体传过来的认证信息中，获得用户名
        String username = (String) authenticationToken.getPrincipal();

        // 2.通过用户名到数据库中获取凭证
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("Mark", password,
                "customRealm--");
        //加盐
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return simpleAuthenticationInfo;
    }

    private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }
}
