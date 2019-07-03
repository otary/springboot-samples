package cn.chenzw.springboot.shiro.repository;

import cn.chenzw.springboot.shiro.domain.dto.output.SysUserRolesAndPermissionsDto;
import cn.chenzw.springboot.shiro.domain.entity.SysUser;
import cn.chenzw.springboot.shiro.support.mybatis.TkMybatisRepository;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

@TkMybatisRepository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUserRolesAndPermissionsDto findUserRolesAndPermissions(@Param("username") String username);

}
