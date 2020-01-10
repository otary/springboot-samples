package cn.chenzw.springboot.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * CommandLineRunner接口，启动时运行一次（带参数）
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("----CommandLineRunner with args:{}----", Arrays.toString(args));
    }
}
