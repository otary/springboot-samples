package cn.chenzw.springboot.mybatisplus;

import cn.chenzw.toolkit.mybatis.core.support.MyBatisRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(annotationClass = MyBatisRepository.class)
public class MyBatisPlusApp {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApp.class, args);
    }
}
