package cn.chenzw.springboot.aop.service;

import cn.chenzw.springboot.aop.support.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AopService {

    @SysLog
    public static void doWithStaticMethod() {
        log.info("doWithStaticMethod....");
    }

    @SysLog
    public void doSomething() {
        log.info("dosomething....");
    }

    /**
     * 正常返回（before => after => afterReturning）
     *
     * @return
     */
    @SysLog
    public String doWithReturn() {
        log.info("doWithReturn....");
        return "hello world";
    }

    /**
     * 异常AOP示例（before => after => afterThrowing）
     */
    @SysLog
    public void doThrowExcetpion() {
        log.info("doThrowExcetpion....");
        throw new RuntimeException("自定义异常");
    }

    @SysLog
    public void doWithArgs(String query, int page, int limit) {
        log.info("doWithArgs....");
    }


}
