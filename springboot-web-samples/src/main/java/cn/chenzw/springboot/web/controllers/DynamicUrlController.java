package cn.chenzw.springboot.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用配置的url（dynamic-url可配置）
 *
 * 访问地址: /test/query
 */
@RestController
@RequestMapping("/${dynamic-url}")
public class DynamicUrlController {

    @GetMapping("/${dynamic-query-url}")
    public String query() {
        return "ok";
    }
}
