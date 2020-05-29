package cn.chenzw.springboot.web.controllers;

import cn.chenzw.toolkit.spring.ratelimit.annotation.MethodRateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratelimit")
public class RateLimitController {

    /**
     * 默认是1s允许请求1次
     *
     * @return
     */
    @MethodRateLimit
    @GetMapping("/info")
    public String getInfo() {
        return "hello";
    }

    /**
     * 1s允许请求10次（每100ms允许请求一次）
     *
     * @return
     */
    @MethodRateLimit(permits = 10)
    @GetMapping("/info-10")
    public String getInfo2() {
        return "hello";
    }
}
