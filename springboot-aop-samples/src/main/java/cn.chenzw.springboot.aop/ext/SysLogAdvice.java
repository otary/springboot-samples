package cn.chenzw.springboot.aop.ext;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class SysLogAdvice implements MethodBeforeAdvice {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("method => {}", method);
    }
}
