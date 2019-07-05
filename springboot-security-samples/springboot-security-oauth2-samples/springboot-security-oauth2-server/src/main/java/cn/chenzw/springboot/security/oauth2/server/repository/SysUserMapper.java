package cn.chenzw.springboot.security.oauth2.server.repository;

import cn.chenzw.springboot.security.oauth2.server.domain.entity.SysUser;
import cn.chenzw.springboot.security.oauth2.server.support.mybatis.TkMybatisRepository;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;


@TkMybatisRepository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(@Param("username") String username);
}
