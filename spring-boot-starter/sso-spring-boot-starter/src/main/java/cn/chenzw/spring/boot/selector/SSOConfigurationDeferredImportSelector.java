package cn.chenzw.spring.boot.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 动态注册Bean（延迟执行- 在@Configuration其他逻辑都执行之后才执行）
 * @author chenzw
 */
public class SSOConfigurationDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }
}
