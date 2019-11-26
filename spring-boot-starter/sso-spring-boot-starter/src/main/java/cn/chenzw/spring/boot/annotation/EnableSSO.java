package cn.chenzw.spring.boot.annotation;

import cn.chenzw.spring.boot.autoconfigure.SSOAutoConfiguration;
import cn.chenzw.spring.boot.registrar.SSORegistrar;
import cn.chenzw.spring.boot.selector.SSOConfigurationImportSelector;
import cn.chenzw.spring.boot.selector.SSOConfigurationSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({SSOAutoConfiguration.class, SSOConfigurationImportSelector.class, SSOConfigurationSelector.class, SSORegistrar.class})
public @interface EnableSSO {

    String name() default "";

    /**
     * for AdviceModeImportSelector(必须)
     * @return
     */
    AdviceMode mode() default AdviceMode.PROXY;
}
