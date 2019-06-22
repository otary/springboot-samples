package cn.chenzw.springboot.shiro.realm;

import cn.chenzw.springboot.shiro.domain.dto.output.SysRolesDto;
import cn.chenzw.springboot.shiro.domain.dto.output.SysUserRolesAndPermissionsDto;
import cn.chenzw.springboot.shiro.domain.entity.SysPermission;
import cn.chenzw.springboot.shiro.service.SysUserService;
import cn.chenzw.springboot.shiro.domain.entity.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    /**
     * 权限认证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();

        SysUserRolesAndPermissionsDto userRolesAndPermission = sysUserService.findUserRolesAndPermissions(sysUser.getUsername());

        List<SysRolesDto> sysRoles = userRolesAndPermission.getSysRoles();
        for (SysRolesDto sysRole : sysRoles) {
            authorizationInfo.addRole(sysRole.getName());

            for (SysPermission sysPermission : sysRole.getSysPermissions()) {
                authorizationInfo.addStringPermission(sysPermission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
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
