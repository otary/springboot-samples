package cn.chenzw.springboot.async.controllers;

import cn.chenzw.springboot.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/call")
    public String call() {

        logger.info("--------async start------------");

        long t1 = System.currentTimeMillis();
        // 耗时操作
        asyncService.update();
        long t2 = System.currentTimeMillis();

        logger.info("--------async finish, cost[{}]ms------------", (t2 - t1));

        // 立即返回
        return "success";
    }
}
