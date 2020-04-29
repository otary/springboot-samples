package cn.chenzw.springboot.security.basic.controllers;

import cn.chenzw.springboot.security.basic.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    CustomUserService userService;

    /**
     * 指定角色权限才能操作方法
     *
     * @param modelAndView
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/list")
    public ModelAndView delete(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.listAll());
        modelAndView.setViewName("/users/list");
        return modelAndView;
    }
}
