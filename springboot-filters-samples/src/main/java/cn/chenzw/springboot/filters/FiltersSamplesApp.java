package cn.chenzw.springboot.filters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FiltersSamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(FiltersSamplesApp.class, args);
    }
}
