package cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  指定使用的数据源
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {

    /**
     * 数据源名称
     * @return
     */
    String value();
}
