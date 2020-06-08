package cn.chenzw.springboot.security.cust.oauth2.server.controllers;

import cn.chenzw.springboot.security.cust.oauth2.server.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomUserService userService;

    @GetMapping("/me")
    public Authentication me(Authentication authentication) {
        return authentication;
    }

}
