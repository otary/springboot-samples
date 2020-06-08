package cn.chenzw.springboot.security.cust.oauth2.client01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class SecurityCustOauth2Client01App {

    public static void main(String[] args) {
       SpringApplication.run(SecurityCustOauth2Client01App.class, args);
    }
}
