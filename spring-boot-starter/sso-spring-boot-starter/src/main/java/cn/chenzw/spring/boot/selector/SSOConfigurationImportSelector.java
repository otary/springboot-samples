package cn.chenzw.spring.boot.selector;

import cn.chenzw.spring.boot.annotation.EnableSSO;
import cn.chenzw.spring.boot.domain.entity.User;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.Set;

public class SSOConfigurationImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        if (annotationMetadata.hasAnnotation(EnableSSO.class.getName())) {
            // 获取注解所有的属性
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableSSO.class.getName());

            Object name = annotationAttributes.get("name"); //=> xxx
        }

        // 将类注册成bean
        return new String[]{
                User.class.getName()
        };
    }
}
