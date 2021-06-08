package cn.chenzw.springboot.sharding.jdbc.service.impl;

import cn.chenzw.springboot.sharding.jdbc.domain.entity.User;
import cn.chenzw.springboot.sharding.jdbc.repository.UserMapper;
import cn.chenzw.springboot.sharding.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }
}
