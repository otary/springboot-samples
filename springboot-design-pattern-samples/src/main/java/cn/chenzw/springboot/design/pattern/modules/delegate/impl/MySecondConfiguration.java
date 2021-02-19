package cn.chenzw.springboot.design.pattern.modules.delegate.impl;

import cn.chenzw.springboot.design.pattern.modules.delegate.MyConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MySecondConfiguration implements MyConfiguration {

    @Override
    public void doSomething() {
        log.info("Second doing...");
    }

    @Override
    public void doSomething2() {
        log.info("Second doing2...");
    }
}
