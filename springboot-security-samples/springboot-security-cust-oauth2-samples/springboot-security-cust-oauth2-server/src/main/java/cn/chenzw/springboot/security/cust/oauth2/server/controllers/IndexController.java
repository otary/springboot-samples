package cn.chenzw.springboot.security.cust.oauth2.server.controllers;

import cn.chenzw.springboot.security.cust.oauth2.server.domain.entity.SysUser;
import cn.chenzw.springboot.security.cust.oauth2.server.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


    @Autowired
    CustomUserService userService;

    @ResponseBody
    @GetMapping("/listAll")
    public List<SysUser> list() {
        return userService.listAll();
    }
}
