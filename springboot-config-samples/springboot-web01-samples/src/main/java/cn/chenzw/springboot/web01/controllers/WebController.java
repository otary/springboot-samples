package cn.chenzw.springboot.web01.controllers;

import cn.chenzw.springboot.web01.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    ConfigBean configBean;

    @GetMapping("/config")
    public ConfigBean getConfig() {
        return configBean;
    }
}
