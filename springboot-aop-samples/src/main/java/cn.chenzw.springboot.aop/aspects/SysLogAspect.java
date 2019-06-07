package cn.chenzw.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面类(单例)
 */
@Aspect
@Component
public class SysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
    private static final String POINT_CUT = "sysLog()";

    @Pointcut("@annotation(cn.chenzw.springboot.aop.support.SysLog)")
    public void sysLog() {

    }

    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : {}", request.getRequestURL().toString());
        logger.info("HTTP_METHOD : {} ", request.getMethod());
        logger.info("IP : {}", request.getRemoteAddr());
        logger.info("CLASS_METHOD : {}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : {}", Arrays.toString(joinPoint.getArgs()));

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();
        logger.info("PARAMS: {}", Arrays.toString(parameterNames));
        logger.info("PARAM_TYPEs: {}", Arrays.toString(parameterTypes));

        logger.info("----------[{}] syslog before--------------", joinPoint.getSignature().getName());
    }

    @After(POINT_CUT)
    public void after(JoinPoint joinPoint) {
        logger.info("----------[{}] syslog after--------------", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = POINT_CUT, returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) {
        logger.info("----------[{}] syslog after returning:{}--------------", joinPoint.getSignature().getName(), ret);
    }

    @AfterThrowing(pointcut = POINT_CUT, throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.info("----------[{}] syslog after throwing:{}--------------", joinPoint.getSignature().getName(),
                ex.getMessage());
    }

}
