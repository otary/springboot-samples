package cn.chenzw.springboot.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtSwagger2SamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(JwtSwagger2SamplesApp.class, new String[]{
                "--spring.profiles.active=jwt"
        });
    }
}
