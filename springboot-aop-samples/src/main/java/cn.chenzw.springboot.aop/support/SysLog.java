package cn.chenzw.springboot.aop.support;

import java.lang.annotation.*;

/**
 * 日志切面注解
 *
 * @author chenzw
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface SysLog {


}
