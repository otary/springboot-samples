package cn.chenzw.springboot.mybatis.plugin;

import cn.chenzw.toolkit.commons.ReflectExtUtils;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

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

        //  MappedStatement ms = (MappedStatement) ReflectExtUtils.getFieldValue(delegate, "mappedStatement");

        BoundSql boundSql = delegate.getBoundSql();

        Object parameterObject = boundSql.getParameterObject();

        System.out.println(parameterObject.getClass());

      /*
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        ParameterMapping parameterMapping = new ParameterMapping.Builder().build();
        parameterMappings.add(parameterMapping);
        */

        System.out.println(boundSql.getParameterObject());


        System.out.println(boundSql.getSql());

        System.out.println(boundSql.getParameterMappings());


        String sql = boundSql.getSql();

        ReflectExtUtils.setFieldValue(boundSql, "sql", sql);

       /*
       if (!ms.getId().toUpperCase().matches(sqlIdRegex)) {
            return invocation.proceed();
        }
        */



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
}
