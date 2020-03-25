package cn.chenzw.springboot.websocket.basic.controllers;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WsController {

    /**
     * 接收消息的同时进行广播发送
     *
     * @return
     */
    @MessageMapping("/hello")
    @SendTo("/topic/hello2")
    public Map<String, String> hello(Map<String, String> map) {
        return map;
    }


    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 后台推送
     */
    @Scheduled(fixedRate = 3000)
    public void sendTopicMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("name", RandomStringUtils.randomAlphabetic(5));
        this.template.convertAndSend("/topic/hello2", map);
    }


}
