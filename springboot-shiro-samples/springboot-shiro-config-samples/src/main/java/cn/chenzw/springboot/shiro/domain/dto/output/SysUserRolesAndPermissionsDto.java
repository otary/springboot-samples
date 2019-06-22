package cn.chenzw.springboot.shiro.domain.dto.output;


import cn.chenzw.springboot.shiro.domain.entity.SysUser;

import java.util.List;

public class SysUserRolesAndPermissionsDto extends SysUser {

    private List<SysRolesDto> sysRoles;


    public List<SysRolesDto> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRolesDto> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public String toString() {
        return "SysUserRolesAndPermissionsDto{" +
                "sysRoles=" + sysRoles +
                '}';
    }
}
