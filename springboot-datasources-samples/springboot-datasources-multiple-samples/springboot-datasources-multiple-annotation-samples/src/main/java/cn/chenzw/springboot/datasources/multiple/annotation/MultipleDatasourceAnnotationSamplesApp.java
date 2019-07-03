package cn.chenzw.springboot.datasources.multiple.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MultipleDatasourceAnnotationSamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatasourceAnnotationSamplesApp.class, args);
    }
}
