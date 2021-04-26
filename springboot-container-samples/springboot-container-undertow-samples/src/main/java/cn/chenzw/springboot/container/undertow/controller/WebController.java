package cn.chenzw.springboot.container.undertow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
