package cn.chenzw.springboot.security.oauth2.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    /**
     * 自定义登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
