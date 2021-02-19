package cn.chenzw.springboot.design.pattern.modules.delegate.impl;

import cn.chenzw.springboot.design.pattern.modules.delegate.MyConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyFirstConfigruation implements MyConfiguration {


    @Override
    public void doSomething() {
        log.info("First doing...");
    }

    @Override
    public void doSomething2() {
        log.info("First doing2...");
    }
}
