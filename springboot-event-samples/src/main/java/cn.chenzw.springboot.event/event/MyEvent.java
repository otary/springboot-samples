package cn.chenzw.springboot.event.event;

import cn.chenzw.springboot.event.entity.User;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    public MyEvent(User user) {
        super(user);
    }
}
