package cn.chenzw.springboot.web.resolver.handler;

import cn.chenzw.springboot.web.annotation.ArrayParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 方法参数解析（数组）
 *
 * @author chenzw
 */
@Slf4j
public class ArrayHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        log.info("methodParameter args => {}", methodParameter.getParameter().isVarArgs());
        log.info("methodParameter type => {}", methodParameter.getParameter().getType());
        log.info("parameterized type => {}", methodParameter.getParameter().getParameterizedType());

        Field[] fields = methodParameter.getParameter().getType().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                log.info("找到注解 => {}", annotation);
            }
        }

        return methodParameter.hasParameterAnnotation(ArrayParameter.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        // @TODO 解析参数

        return null;
    }
}
