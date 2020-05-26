package cn.chenzw.springboot.aop.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SysLogAdvice implements MethodBeforeAdvice {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("----------------------------------------");
        System.out.println(method);
    }
}
