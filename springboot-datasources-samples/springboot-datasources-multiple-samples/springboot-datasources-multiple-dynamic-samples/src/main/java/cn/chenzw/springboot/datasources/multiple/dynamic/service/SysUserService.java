package cn.chenzw.springboot.datasources.multiple.dynamic.service;


import cn.chenzw.springboot.datasources.multiple.dynamic.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.dynamic.repository.SysUserH2Mapper;
import cn.chenzw.springboot.datasources.multiple.dynamic.repository.SysUserMySqlMapper;
import cn.chenzw.toolkit.mybatis.dynamic.annotation.DynamicDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {


    @Autowired
    SysUserH2Mapper sysUserH2Mapper;

    @Autowired
    SysUserMySqlMapper sysUserMySqlMapper;

    @DynamicDS("h2")
    public List<SysUser> listH2All() {
        return sysUserH2Mapper.selectAll();
    }

    @DynamicDS("mysql")
    public List<SysUser> listMySqlAll() {
        return sysUserMySqlMapper.selectAll();
    }

    @DynamicDS("mysql")
    public List<SysUser> listMySqlAll2() {
        return sysUserMySqlMapper.listAll();
    }


}
