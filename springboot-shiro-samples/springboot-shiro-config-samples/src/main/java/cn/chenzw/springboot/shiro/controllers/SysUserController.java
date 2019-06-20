package cn.chenzw.springboot.shiro.controllers;

import cn.chenzw.springboot.shiro.domain.entity.SysUser;
import cn.chenzw.springboot.shiro.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/list")
    @RequiresPermissions("user:create")
    public List<SysUser> listAll() {
        return sysUserService.listAll();
    }
}
