package cn.chenzw.springboot.datasource.multiple.annotation.service;

import cn.chenzw.springboot.datasource.multiple.annotation.domain.entity.SysUser;
import cn.chenzw.springboot.datasource.multiple.annotation.repository.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {


    @Autowired
    SysUserMapper sysUserMapper;


    public List<SysUser> listAll() {
        return sysUserMapper.selectAll();
    }
}
