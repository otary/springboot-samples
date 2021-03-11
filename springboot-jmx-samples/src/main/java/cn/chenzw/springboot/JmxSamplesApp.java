package cn.chenzw.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMBeanExport
@EnableScheduling
public class JmxSamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(JmxSamplesApp.class, args);
    }
}
