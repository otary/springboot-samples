package cn.chenzw.springboot.datasources.multiple.annotation.aop;

import cn.chenzw.springboot.datasources.multiple.annotation.repository.SysUserMySqlMapper;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource;
import cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSourceHolder;
import cn.chenzw.toolkit.commons.ReflectExtUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 数据源切面
 */
@Aspect
@Component
@Order(-99)
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    private static final String POINT_CUT = "datasource()";


    @Pointcut("@annotation(cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource) || execution(* cn.chenzw.springboot.datasources.multiple.annotation.repository..*.*(..))")
   // @Pointcut("@annotation(cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource)")
    public void datasource() {

    }

    /**
     * 拦截DataSource注解,并注入数据源
     */
    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) throws Exception {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();


        System.out.println(method);


        if (method.getDeclaringClass().isAnnotationPresent(DataSource.class)) {
            DataSource dataSourceAnnotation = method.getDeclaringClass().getAnnotation(DataSource.class);
            DataSourceHolder.set(dataSourceAnnotation.value());
        } else {

            if(method.isAnnotationPresent(DataSource.class)){
                method.getDeclaringClass().getAnnotation(DataSource.class);
            }




            System.out.println("不存在注解");
        }

        if(Proxy.isProxyClass(joinPoint.getTarget().getClass())){
            InvocationHandler proxy =
                    Proxy.getInvocationHandler(joinPoint.getTarget());

            Object o = ReflectExtUtils.getFieldValueQuietly((MapperProxy) proxy, "mapperInterface");


            System.out.println(((Class)o).isAnnotationPresent(DataSource.class));


            System.out.println(SysUserMySqlMapper.class);
            System.out.println(SysUserMySqlMapper.class.isAnnotationPresent(DataSource.class));
        }




      /*  System.out.println(joinPoint.getThis().getClass().getAnnotation(DataSource.class));
        Object aThis = joinPoint.getTarget();
        System.out.println(aThis.getClass().getAnnotation(DataSource.class));*/

       /* Class<?> declaringClass = method.getDeclaringClass();
        System.out.println(declaringClass);

        Class<?> proxyClass = Proxy.getProxyClass(Thread.currentThread().getContextClassLoader(), declaringClass.getInterfaces());

        System.out.println(proxyClass);

        System.out.println(declaringClass.getAnnotation(DataSource.class));*/
        //   Class<?> aClass = joinPoint.getTarget().getClass();
        //   System.out.println(aClass.getComponentType());
        //   System.out.println(aClass);

      /*  Class<?> proxyClass = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), joinPoint.getTarget().getClass().getInterfaces());
        System.out.println(proxyClass);*/


      /*  if (method.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            DataSourceHolder.set(dataSource.value());


        } else {
            System.out.println("----------------------------");
        }*/



    }


    //private <T extends Annotation> get

}
