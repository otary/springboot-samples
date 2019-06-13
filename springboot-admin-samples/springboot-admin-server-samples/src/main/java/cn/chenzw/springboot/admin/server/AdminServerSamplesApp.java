package cn.chenzw.springboot.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminServerSamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerSamplesApp.class, args);
    }
}
