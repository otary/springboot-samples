package cn.chenzw.springboot.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    /**
     * @Async注解在方法上表示该方法是个异步方法，如果注解在类上，则表示该类所有方法都是异步方法
     */
    @Async
    public void update() {
        try {
            // 模拟耗时10秒操作
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("--------async complete------------");
    }
}
