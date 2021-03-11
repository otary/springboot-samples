package cn.chenzw.springboot.mybatisplus.service;

import cn.chenzw.springboot.mybatisplus.domain.entity.User;
import cn.chenzw.springboot.mybatisplus.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void save() {
        User user = new User();
        user.setName("张三");
        userMapper.insert(user);

        List<User> users = userMapper.selectList(null);
        log.info("插入结果 => {}", users);

    }
}
