package cn.chenzw.springboot.datasources.multiple.annotation.aop;

import cn.chenzw.toolkit.commons.ReflectExtUtils;
import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Optional;

/**
 * 数据源切面
 */
@Aspect
@Component
@Order(-99)
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    private static final String POINT_CUT = "datasource()";


    @Pointcut("execution(* cn.chenzw.springboot.datasources.multiple.annotation.repository..*.*(..)) || @annotation(cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource)")
    // @Pointcut("@annotation(cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis.DataSource)")
    public void datasource() {

    }

    /**
     * 拦截DataSource注解,并注入数据源
     */
    @Before(POINT_CUT)
    public void before(JoinPoint joinPoint) throws Exception {

        System.out.println("--------------------------------------------------------");
        /*MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();


        System.out.println(method);

        Optional<DataSource> dataSourceOptl = findAnnotation(method, DataSource.class);
        if (!dataSourceOptl.isPresent()) {
            if(DataSourceHolder.get() == null){
                dataSourceOptl = getProxyTargetAnnotation(joinPoint.getTarget(), DataSource.class);

            }
        }
        if (dataSourceOptl.isPresent()) {
            DataSourceHolder.set(dataSourceOptl.get().value());
        }*/
    }


    private <T extends Annotation> Optional<T> findAnnotation(Method method, Class<T> annotationClass) {
        if (method.isAnnotationPresent(annotationClass)) {
            return Optional.of(method.getAnnotation(annotationClass));
        }

        if (method.getDeclaringClass().isAnnotationPresent(annotationClass)) {
            return Optional.of(method.getDeclaringClass().getAnnotation(annotationClass));
        }
        return Optional.empty();
    }

    private <T extends Annotation> Optional<T> getProxyTargetAnnotation(Object target, Class<T> annotationClass) {
        if (Proxy.isProxyClass(target.getClass())) {
            InvocationHandler proxy = Proxy.getInvocationHandler(target);

            if (MapperProxy.class.isInstance(proxy)) {
                Object targetMapper = null;
                try {
                    targetMapper = ReflectExtUtils.getFieldValueQuietly((MapperProxy) proxy, "mapperInterface");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (targetMapper != null) {
                    if (((Class) targetMapper).isAnnotationPresent(annotationClass)) {
                        return Optional.ofNullable((T) ((Class) targetMapper).getAnnotation(annotationClass));
                    }
                }
            }
        }

        return Optional.empty();

    }

}
