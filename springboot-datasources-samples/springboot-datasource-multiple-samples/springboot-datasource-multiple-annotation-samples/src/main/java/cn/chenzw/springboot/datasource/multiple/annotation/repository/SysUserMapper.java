package cn.chenzw.springboot.datasource.multiple.annotation.repository;

import cn.chenzw.springboot.datasource.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasource.multiple.annotation.support.mybatis.TkMybatisRepository;
import tk.mybatis.mapper.common.BaseMapper;

@TkMybatisRepository
public interface SysUserMapper extends BaseMapper<SysUser> {
}
