package cn.chenzw.springboot.web.resolver.handler;

import cn.chenzw.springboot.web.annotation.ArrayParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 方法参数解析（数组）
 *
 * @author chenzw
 */
@Slf4j
public class ArrayMethodArgumentResolver extends AbstractNamedValueMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        log.info("methodParameter args => {}", methodParameter.getParameter().isVarArgs());
        log.info("methodParameter type => {}", methodParameter.getParameter().getType());
        log.info("methodParameter ParameterizedType => {}", methodParameter.getParameter().getParameterizedType());
        log.info("methodParameter GenericParameterType => {}", methodParameter.getGenericParameterType());
        log.info("methodParameter ContainingClass => {}", methodParameter.getContainingClass());

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
    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
        ArrayParameter anno = parameter.getParameterAnnotation(ArrayParameter.class);
        return new ArrayParameterNamedValueInfo(anno);
    }

    /**
     * 解析指定参数（返回指定参数的实际值）
     *
     * @param name
     * @param parameter
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        log.info("解析参数 => [{}]", name);

        // 获取HttpServletRequest对象
        // HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);

        Object arg = null;
        String[] paramValues = request.getParameterValues(name);

        if (paramValues != null) {
            arg = (paramValues.length == 1 ? paramValues[0] : paramValues);
        }

        return arg;
    }

    @Override
    protected void handleMissingValue(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        super.handleMissingValue(name, parameter, request);

        // 可以自定义缺失时抛出的异常
    }

    public static class ArrayParameterNamedValueInfo extends NamedValueInfo {

        public ArrayParameterNamedValueInfo() {
            super("", false, ValueConstants.DEFAULT_NONE);
        }

        public ArrayParameterNamedValueInfo(String name, boolean required, String defaultValue) {
            super(name, required, defaultValue);
        }

        public ArrayParameterNamedValueInfo(ArrayParameter arrayParameter) {
            super(arrayParameter.value(), arrayParameter.required(), ValueConstants.DEFAULT_NONE);
        }

    }
}
