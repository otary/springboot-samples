package cn.chenzw.springboot.datasources.multiple.annotation.repository;

import cn.chenzw.springboot.datasources.multiple.annotation.config.DruidConfig;
import cn.chenzw.springboot.datasources.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.TkMybatisRepository;
import tk.mybatis.mapper.common.BaseMapper;

@TkMybatisRepository
@DataSource(DruidConfig.H2_DATASOURCE_NAME)
public interface SysUserH2Mapper extends BaseMapper<SysUser> {
}
