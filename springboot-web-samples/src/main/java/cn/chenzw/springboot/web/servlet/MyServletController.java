package cn.chenzw.springboot.web.servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-servlet")
public class MyServletController {

    @GetMapping
    public String hello() {
        return "hello";
    }

}
