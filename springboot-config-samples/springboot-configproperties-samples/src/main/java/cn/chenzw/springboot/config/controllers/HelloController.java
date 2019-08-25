package cn.chenzw.springboot.config.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${rest.hello}")
public class HelloController {

    /**
     * 访问：http://localhost:8080/hello/index
     *
     * @return
     */
    @GetMapping("${rest.hello.index}")
    public String index() {
        return "hello";
    }
}
