package cn.chenzw.springboot.websocket.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebsocketBasicSamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketBasicSamplesApp.class);
    }
}
