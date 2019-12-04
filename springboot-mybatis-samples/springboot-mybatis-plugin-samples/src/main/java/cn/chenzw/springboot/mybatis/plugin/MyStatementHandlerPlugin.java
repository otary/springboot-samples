package cn.chenzw.springboot.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * MyBatis插件开发
 * <p>
 * type: 要拦截的类(Executor/ParameterHandler/ResultSetHandler/StatementHandler)
 * method: 拦截的方法
 * args: 方法的参数
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class)
})
public class MyStatementHandlerPlugin implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        System.out.println(
                mappedStatement
        );

        logger.info("[intercept]:{}", invocation);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        logger.info("[plugin]:{}", o);
        return o;
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("[setProperties]:{}", properties);
    }
}
