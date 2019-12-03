package cn.chenzw.springboot.integration.lock.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@RestController
@RequestMapping("/lock")
public class LockController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisLockRegistry redisLockRegistry;

    @GetMapping("/get")
    public void get() throws InterruptedException {
        Lock lock = redisLockRegistry.obtain("lock");
        boolean b1 = lock.tryLock(3, TimeUnit.SECONDS);
        logger.info("b1 is : {}", b1);

        TimeUnit.SECONDS.sleep(5);

        boolean b2 = lock.tryLock(3, TimeUnit.SECONDS);
        logger.info("b2 is : {}", b2);

        lock.unlock();
        lock.unlock();

    }

}
