package cn.chenzw.springboot.event.listener;

import cn.chenzw.springboot.event.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 通过@EventListener注解
 */
@Component
public class MyEventListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 监听MyEvent事件
     * 使用@Async时必须开启 @EnableAsync
     */
    @Async
    @Order
    @EventListener(MyEvent.class)
    public void execute(MyEvent event) {
        logger.info("接收到消息：{}", event.getSource());
    }
}
