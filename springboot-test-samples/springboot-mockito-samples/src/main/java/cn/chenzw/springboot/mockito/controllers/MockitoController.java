package cn.chenzw.springboot.mockito.controllers;

import cn.chenzw.springboot.mockito.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mockito")
public class MockitoController {

    @Autowired
    RestService restService;

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return restService.getUserInfo();
    }

}
