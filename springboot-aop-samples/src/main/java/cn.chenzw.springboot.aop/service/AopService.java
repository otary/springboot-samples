package cn.chenzw.springboot.aop.service;

import cn.chenzw.springboot.aop.support.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AopService {

    private static final Logger logger = LoggerFactory.getLogger(AopService.class);

    @SysLog
    public void doSomething() {
        logger.info("----------dosomething------------");
    }

    @SysLog
    public String doWithReturn() {
        logger.info("----------doWithReturn------------");
        return "hello world";
    }

    @SysLog
    public void doThrowExcetpion() {
        logger.info("----------doThrowExcetpion------------");
        throw new RuntimeException("自定义异常");
    }

    @SysLog
    public void doWithArgs(String query, int page, int limit) {
        logger.info("----------doWithArgs------------");
    }


}
