package cn.chenzw.springboot.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

/**
 * MyBatis插件开发
 *
 * type: 要拦截的类(Executor/ParameterHandler/ResultSetHandler/StatementHandler)
 * method: 拦截的方法
 * args: 方法的参数
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class)
})
public class AMyBatisPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("---------invocation------------" + invocation);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("----------plugin-----------" + o);
        return o;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("---------------------" + properties);
    }
}
