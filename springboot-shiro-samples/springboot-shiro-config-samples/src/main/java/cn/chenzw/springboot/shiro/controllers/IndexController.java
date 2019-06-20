package cn.chenzw.springboot.shiro.controllers;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {

        // shiroLoginFailure:shiro异常类的全类名（登录失败时从request中获取shiro处理的异常信息）
        String exception = (String) request.getAttribute("shiroLoginFailure");

        if (!StringUtils.isBlank(exception)) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                map.put("msg", "帐号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                map.put("msg", "密码不正确");
            } else if ("kaptchaValidateFailed".equals(exception)) {
                map.put("msg", "验证码错误");
            } else {
                map.put("msg", exception);
            }
        }

        return "/login";
    }
}
