package cn.chenzw.springboot.aop.aspects;

import cn.chenzw.toolkit.spring.aop.JoinPointWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类(单例)
 */
@Aspect
@Component
public class SysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
    private static final String POINT_CUT = "sysLog()";

    private ThreadLocal<JoinPointWrapper> joinPointWrapper = new ThreadLocal<>();

    @Pointcut("@annotation(cn.chenzw.springboot.aop.support.SysLog)")
    public void sysLog() {

    }

    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {
        joinPointWrapper.set(new JoinPointWrapper(joinPoint));

        logger.info("URL : {}", joinPointWrapper.get().getURI());
        logger.info("HTTP_METHOD : {} ", joinPointWrapper.get().getHttpMethod());
        logger.info("IP : {}", joinPointWrapper.get().getClientIp());
        logger.info("CLASS_METHOD : {}", joinPointWrapper.get().getCanonicalClassMethod());
        logger.info("METHOD_ARGS : {}", Arrays.toString(joinPointWrapper.get().getMethodArgs()));

        logger.info("AOP @SysLog before => {}", joinPoint.getSignature().getName());
    }

    /**
     * 无论是否抛出异常，都会被执行到
     *
     * @param joinPoint
     */
    @After(POINT_CUT)
    public void after(JoinPoint joinPoint) {
        logger.info("AOP @SysLog after => {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = POINT_CUT, returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        logger.info("AOP @SysLog after returning => {}", joinPoint.getSignature().getName(), ret);
    }

    @AfterThrowing(pointcut = POINT_CUT, throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.info("AOP @SysLog after throwing => {}", joinPoint.getSignature().getName(),
                ex.getMessage());
    }

}
