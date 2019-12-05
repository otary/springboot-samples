package cn.chenzw.springboot.mybatis.plugin;

import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;
import cn.chenzw.toolkit.commons.ReflectExtUtils;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.h2.store.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.*;

/**
 * MyBatis插件开发
 * <p>
 * type: 要拦截的类(Executor/ParameterHandler/ResultSetHandler/StatementHandler)
 * method: 拦截的方法
 * args: 方法的参数
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyStatementHandlerPlugin implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        BaseStatementHandler delegate = (BaseStatementHandler) ReflectExtUtils.getFieldValue(handler, "delegate");

       // MappedStatement ms = (MappedStatement) ReflectExtUtils.getFieldValue(delegate, "mappedStatement");

        BoundSql boundSql = delegate.getBoundSql();
        Optional<Pageable> pageableOptional = getPageableParameter(boundSql.getParameterObject());
        if(!pageableOptional.isPresent()){
            return invocation.proceed();
        }

      //  pageableOptional.get()

        System.out.println(boundSql.getSql());

        System.out.println(boundSql.getParameterMappings());


        String sql = boundSql.getSql();

        ReflectExtUtils.setFieldValue(boundSql, "sql", sql);




       /*
       MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
       */

        logger.info("[intercept]:{}", invocation);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        logger.info("[plugin]:{}", target);
        // return (target instanceof StatementHandler) ? Plugin.wrap(target, this) : target;
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("[setProperties]:{}", properties);
    }


    private Optional<Pageable> getPageableParameter(Object parameter) {
        if (parameter != null) {
            if (parameter instanceof Map) {
                Map paramMap = (Map) parameter;
                for (Object param : paramMap.values()) {
                    if (param instanceof Pageable) {
                        return Optional.ofNullable((Pageable) param);
                    }
                }
            }
        }
        return Optional.empty();
    }
}
