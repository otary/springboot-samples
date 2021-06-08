package cn.chenzw.springboot.sharding.jdbc.service;

import cn.chenzw.springboot.sharding.jdbc.domain.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> list();
}
