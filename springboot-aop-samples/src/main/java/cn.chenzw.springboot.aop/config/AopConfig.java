package cn.chenzw.springboot.aop.config;

import cn.chenzw.springboot.aop.ext.SysLogAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 非必须，springboot自动开启AOP（spring.aop.auto=true）
 */
@Configuration
//@EnableAspectJAutoProxy
public class AopConfig {

    /**
     * 自定义通知
     *
     * @return
     */
    @Bean
    public MethodBeforeAdvice sysLogAdvice() {
        return new SysLogAdvice();
    }


}
