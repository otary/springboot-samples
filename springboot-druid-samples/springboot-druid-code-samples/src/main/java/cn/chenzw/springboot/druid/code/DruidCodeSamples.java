package cn.chenzw.springboot.druid.code;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DruidCodeSamples {

    public static void main(String[] args) {
        SpringApplication.run(DruidDataSource.class);
    }
}
