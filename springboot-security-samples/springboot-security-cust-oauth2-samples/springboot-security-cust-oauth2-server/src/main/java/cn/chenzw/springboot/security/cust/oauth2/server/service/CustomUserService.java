package cn.chenzw.springboot.security.cust.oauth2.server.service;

import cn.chenzw.springboot.security.cust.oauth2.server.domain.entity.SysUser;
import cn.chenzw.springboot.security.cust.oauth2.server.repository.SysUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }
        return user;
    }

    public List<SysUser> listAll() {
        return sysUserMapper.selectAll();
    }
}
