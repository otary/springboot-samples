package cn.chenzw.springboot.shiro.realm;

import cn.chenzw.springboot.shiro.service.SysUserService;
import cn.chenzw.springboot.shiro.domain.entity.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //SysUser userInfo  = (SysUser)principals.getPrimaryPrincipal();

        System.out.println("------------doGetAuthorizationInfo1-----------------");

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("--------------doGetAuthenticationInfo2---------------------");
        // 获取用户名
        String username = (String) token.getPrincipal();

        // 获取用户名对应的用户对象
        SysUser sysUser = sysUserService.findByName(username);

        if (sysUser == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,  // 用户对象
                sysUser.getPassword(),  // 密码
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()),  //
                getName()  // realm name
        );
        return authenticationInfo;
    }
}
