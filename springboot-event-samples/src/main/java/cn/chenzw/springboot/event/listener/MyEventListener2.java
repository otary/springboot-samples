package cn.chenzw.springboot.event.listener;

import cn.chenzw.springboot.event.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 通过实现ApplicationListener接口
 */
@Component
public class MyEventListener2 implements ApplicationListener<MyEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(MyEvent event) {
        logger.info("接收到消息2：{}", event.getSource());
    }
}
