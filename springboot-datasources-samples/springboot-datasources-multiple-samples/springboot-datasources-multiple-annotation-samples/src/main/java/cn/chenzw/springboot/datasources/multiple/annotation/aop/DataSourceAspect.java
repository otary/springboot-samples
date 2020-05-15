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
import java.lang.reflect.Proxy;

/**
 * 数据源切面
 */
@Aspect
@Component
@Order(-99)
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    private static final String POINT_CUT = "datasource()";


    @Pointcut("execution(* cn.chenzw.springboot.datasources.multiple.annotation.repository..*.*(..))")
    //@Pointcut("@annotation(cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource)")
    public void datasource() {

    }

    /**
     * 拦截DataSource注解,并注入数据源
     */
    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();


      /*  System.out.println(joinPoint.getThis().getClass().getAnnotation(DataSource.class));
        Object aThis = joinPoint.getTarget();
        System.out.println(aThis.getClass().getAnnotation(DataSource.class));*/

        Class<?> declaringClass = method.getDeclaringClass();
        System.out.println(declaringClass);

        Class<?> proxyClass = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), declaringClass.getInterfaces());

        System.out.println(proxyClass);

        System.out.println(declaringClass.getAnnotation(DataSource.class));
     //   Class<?> aClass = joinPoint.getTarget().getClass();
     //   System.out.println(aClass.getComponentType());
     //   System.out.println(aClass);

      /*  Class<?> proxyClass = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), joinPoint.getTarget().getClass().getInterfaces());
        System.out.println(proxyClass);*/


        if (method.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            DataSourceHolder.set(dataSource.value());


        } else {
            System.out.println("----------------------------");
        }

    }


}
