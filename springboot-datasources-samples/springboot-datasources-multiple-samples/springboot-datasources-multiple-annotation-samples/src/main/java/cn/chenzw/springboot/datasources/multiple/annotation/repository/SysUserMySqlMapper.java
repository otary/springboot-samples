package cn.chenzw.springboot.datasources.multiple.annotation.repository;

import cn.chenzw.springboot.datasources.multiple.annotation.config.DruidConfig;
import cn.chenzw.springboot.datasources.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.TkMybatisRepository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@DataSource(DruidConfig.MYSQL_DATASOURCE_NAME)
@TkMybatisRepository
public interface SysUserMySqlMapper extends BaseMapper<SysUser> {

    List<SysUser> listAll();
}
