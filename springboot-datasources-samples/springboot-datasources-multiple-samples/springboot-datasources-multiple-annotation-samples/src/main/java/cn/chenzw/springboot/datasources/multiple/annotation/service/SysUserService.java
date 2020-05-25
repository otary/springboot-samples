package cn.chenzw.springboot.datasources.multiple.annotation.service;

import cn.chenzw.springboot.datasources.multiple.annotation.config.DruidConfig;
import cn.chenzw.springboot.datasources.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.annotation.repository.SysUserH2Mapper;
import cn.chenzw.springboot.datasources.multiple.annotation.repository.SysUserMySqlMapper;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {


    @Autowired
    SysUserH2Mapper sysUserH2Mapper;

    @Autowired
    SysUserMySqlMapper sysUserMySqlMapper;

  //  @DataSource(DruidConfig.H2_DATASOURCE_NAME)
    public List<SysUser> listH2All() {
        return sysUserH2Mapper.selectAll();
    }


    @DataSource(DruidConfig.H2_DATASOURCE_NAME)
    public List<SysUser> listMySqlAll() {
        return sysUserMySqlMapper.selectAll();
    }

    public List<SysUser> listMySqlAll2(){
        return sysUserMySqlMapper.listAll();
    }


}
