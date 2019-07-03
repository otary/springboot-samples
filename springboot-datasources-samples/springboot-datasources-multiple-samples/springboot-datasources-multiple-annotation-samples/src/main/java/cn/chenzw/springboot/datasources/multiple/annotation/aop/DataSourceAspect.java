package cn.chenzw.springboot.datasources.multiple.annotation.aop;

import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源切面
 */
@Aspect
@Component
@Order(-99)
public class DataSourceAspect {


    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
    private static final String POINT_CUT = "datasource()";


    @Pointcut("@annotation(cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource)")
    public void datasource() {

    }

    /**
     * 拦截DataSource注解,并注入数据源
     */
    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        // @TODO 为空判断？
        DataSourceHolder.set(dataSource.value());
    }


}
