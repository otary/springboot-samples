package cn.chenzw.springboot.sharding.jdbc.controllers;

import cn.chenzw.springboot.sharding.jdbc.domain.entity.User;
import cn.chenzw.springboot.sharding.jdbc.service.UserService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public void add(User user) {
        userService.add(user);
    }


    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
