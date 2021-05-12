package cn.chenzw.springboot.datasources.multiple.dynamic.repository;


import cn.chenzw.springboot.datasources.multiple.dynamic.domain.entity.SysUser;
import cn.chenzw.toolkit.mybatis.core.support.TkMyBatisRepository;
import cn.chenzw.toolkit.mybatis.dynamic.annotation.DynamicDS;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@DynamicDS("mysql")
@TkMyBatisRepository
public interface SysUserMySqlMapper extends BaseMapper<SysUser> {

    List<SysUser> listAll();
}
