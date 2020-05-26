package cn.chenzw.springboot.datasources.multiple.dynamic.service;


import cn.chenzw.springboot.datasources.multiple.dynamic.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.dynamic.repository.SysUserH2Mapper;
import cn.chenzw.springboot.datasources.multiple.dynamic.repository.SysUserMySqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {


    @Autowired
    SysUserH2Mapper sysUserH2Mapper;

    @Autowired
    SysUserMySqlMapper sysUserMySqlMapper;

    public List<SysUser> listH2All() {
        return sysUserH2Mapper.selectAll();
    }


    public List<SysUser> listMySqlAll() {
        return sysUserMySqlMapper.selectAll();
    }

    public List<SysUser> listMySqlAll2() {
        return sysUserMySqlMapper.listAll();
    }


}
