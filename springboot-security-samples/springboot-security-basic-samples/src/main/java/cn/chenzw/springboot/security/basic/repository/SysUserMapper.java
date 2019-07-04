package cn.chenzw.springboot.security.basic.repository;

import cn.chenzw.springboot.security.basic.domain.entity.SysUser;
import cn.chenzw.springboot.security.basic.support.mybatis.TkMybatisRepository;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;


@TkMybatisRepository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(@Param("username") String username);
}
