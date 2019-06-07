package cn.chenzw.springboot.aop.support;

import java.lang.annotation.*;

/**
 * 日志切面注解
 *
 * @author chenzw
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface SysLog {


}
