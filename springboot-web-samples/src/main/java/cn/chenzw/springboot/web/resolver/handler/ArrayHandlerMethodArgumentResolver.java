package cn.chenzw.springboot.web.resolver.handler;

import cn.chenzw.springboot.web.annotation.ArrayParameter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 方法参数解析（数组）
 *
 * @author chenzw
 */
public class ArrayHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println(parameter.getParameter().isVarArgs());
        System.out.println(parameter.getParameter().getType());
        System.out.println(parameter.getParameter().getParameterizedType());

        Field[] fields = parameter.getParameter().getType().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
        //  return parameter.hasParameterAnnotation(ArrayParameter.class);
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("----------------xxx---" + parameter);


        return null;
    }
}
