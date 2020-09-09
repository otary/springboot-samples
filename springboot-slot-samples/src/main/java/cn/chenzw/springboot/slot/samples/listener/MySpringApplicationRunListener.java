package cn.chenzw.springboot.slot.samples.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 必须注册到 META/spring.factories 文件中
 *
 * @author chenzw
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 必须有这个构造函数
     *
     * @param application
     * @param args
     */
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        logger.info("------------构造函数----------------");
    }

    @Override
    public void starting() {
        logger.info("------------starting----------------");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logger.info("------------environmentPrepared----------------");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logger.info("------------contextPrepared----------------");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        logger.info("------------contextLoaded----------------");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        logger.info("------------started----------------");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        logger.info("------------running----------------");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        logger.info("------------failed----------------");
    }
}
