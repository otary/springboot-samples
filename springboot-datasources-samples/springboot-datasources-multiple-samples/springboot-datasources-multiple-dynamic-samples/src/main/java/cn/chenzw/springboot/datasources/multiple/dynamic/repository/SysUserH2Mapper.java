package cn.chenzw.springboot.datasources.multiple.dynamic.repository;


import cn.chenzw.springboot.datasources.multiple.dynamic.domain.entity.SysUser;
import cn.chenzw.toolkit.mybatis.core.support.TkMyBatisRepository;
import cn.chenzw.toolkit.mybatis.dynamic.support.DynamicDataSource;
import tk.mybatis.mapper.common.BaseMapper;

@TkMyBatisRepository
@DynamicDataSource("h2")
public interface SysUserH2Mapper extends BaseMapper<SysUser> {
}
