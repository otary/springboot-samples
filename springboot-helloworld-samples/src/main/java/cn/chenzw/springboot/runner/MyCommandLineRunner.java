package cn.chenzw.springboot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * CommandLineRunner接口，启动时运行一次（带参数）
 * 应用场景： 初始化数据库、rpc服务等
 */
@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner with args => {}", Arrays.toString(args));
    }
}
