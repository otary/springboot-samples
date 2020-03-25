package cn.chenzw.springboot.websocket.sockjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebsocketSamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketSamplesApp.class);
    }
}
