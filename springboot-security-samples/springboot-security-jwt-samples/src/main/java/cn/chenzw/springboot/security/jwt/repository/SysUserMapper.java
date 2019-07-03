package cn.chenzw.springboot.security.jwt.repository;

import cn.chenzw.springboot.security.jwt.domain.entity.SysUser;
import cn.chenzw.springboot.security.jwt.support.mybatis.TkMybatisRepository;
import org.apache.ibatis.annotations.Param;


@TkMybatisRepository
public interface SysUserMapper {

    SysUser findByUsername(@Param("username") String username);
}
