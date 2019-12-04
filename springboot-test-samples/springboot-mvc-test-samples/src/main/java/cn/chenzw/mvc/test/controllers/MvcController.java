package cn.chenzw.mvc.test.controllers;

import cn.chenzw.mvc.test.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MvcController {

    @Autowired
    RestService restService;

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return restService.getUserInfo();
    }
}
