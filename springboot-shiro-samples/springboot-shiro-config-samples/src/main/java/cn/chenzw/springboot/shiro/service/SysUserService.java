package cn.chenzw.springboot.shiro.service;

import cn.chenzw.springboot.shiro.domain.dto.output.SysUserRolesAndPermissionsDto;
import cn.chenzw.springboot.shiro.domain.entity.SysUser;
import cn.chenzw.springboot.shiro.repository.SysUserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    public SysUser findByName(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        return sysUserMapper.selectOne(sysUser);
    }

    public List<SysUser> listAll() {
        return sysUserMapper.selectAll();
    }

    public SysUserRolesAndPermissionsDto findUserRolesAndPermissions(String username) {
        return sysUserMapper.findUserRolesAndPermissions(username);
    }


}
