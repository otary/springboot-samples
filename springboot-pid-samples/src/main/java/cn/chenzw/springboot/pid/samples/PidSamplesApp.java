package cn.chenzw.springboot.pid.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class PidSamplesApp {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(PidSamplesApp.class);
        sa.addListeners(new ApplicationPidFileWriter());
        sa.run(args);
    }
}
