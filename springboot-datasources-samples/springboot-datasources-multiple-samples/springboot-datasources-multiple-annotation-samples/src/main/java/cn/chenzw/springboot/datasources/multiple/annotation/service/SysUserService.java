package cn.chenzw.springboot.datasources.multiple.annotation.service;

import cn.chenzw.springboot.datasources.multiple.annotation.config.DruidConfig;
import cn.chenzw.springboot.datasources.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasources.multiple.annotation.repository.SysUserMapper;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {


    @Autowired
    SysUserMapper sysUserMapper;


    @DataSource(DruidConfig.H2_DATASOURCE_NAME)
    public List<SysUser> listAll() {
        return sysUserMapper.selectAll();
    }
}
