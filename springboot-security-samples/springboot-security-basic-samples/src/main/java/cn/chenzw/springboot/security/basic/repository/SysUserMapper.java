package cn.chenzw.springboot.security.basic.repository;

import cn.chenzw.springboot.security.basic.domain.entity.SysUser;
import cn.chenzw.springboot.security.basic.support.mybatis.TkMybatisRepository;
import org.apache.ibatis.annotations.Param;


@TkMybatisRepository
public interface SysUserMapper {

    SysUser findByUsername(@Param("username") String username);
}
