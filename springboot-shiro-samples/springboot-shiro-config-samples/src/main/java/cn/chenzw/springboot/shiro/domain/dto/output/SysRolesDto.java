package cn.chenzw.springboot.shiro.domain.dto.output;

import cn.chenzw.springboot.shiro.domain.entity.SysPermission;
import cn.chenzw.springboot.shiro.domain.entity.SysRole;

import java.util.List;

public class SysRolesDto extends SysRole {

    private List<SysPermission> sysPermissions;


    public List<SysPermission> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(List<SysPermission> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }

    @Override
    public String toString() {
        return "SysRolesDto{" +
                "sysPermissions=" + sysPermissions +
                '}';
    }
}
