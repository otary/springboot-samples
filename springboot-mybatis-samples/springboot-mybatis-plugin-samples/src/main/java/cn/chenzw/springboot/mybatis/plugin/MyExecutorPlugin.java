package cn.chenzw.springboot.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author chenzw
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MyExecutorPlugin implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("[intercept]:{}", invocation);


        System.out.println(invocation.getTarget());

        //    RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();


        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        // 获取 SQL 命令
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        // 获取参数
        Object parameter = invocation.getArgs()[1];

        if (parameter != null) {
            // 获取成员变量
            Field[] declaredFields = parameter.getClass().getDeclaredFields();

           /* for (Field field : declaredFields) {
                if (field.getAnnotation(CreateTime.class) != null) {
                    if (SqlCommandType.INSERT.equals(sqlCommandType)) { // insert 语句插入 createTime
                        field.setAccessible(true);
                        if (field.get(parameter) == null) {
                            field.set(parameter, new Date());
                        }
                    }
                }

                if (field.getAnnotation(UpdateTime.class) != null) { // insert 或 update 语句插入 updateTime
                    if (SqlCommandType.INSERT.equals(sqlCommandType) || SqlCommandType.UPDATE.equals(sqlCommandType)) {
                        field.setAccessible(true);
                        if (field.get(parameter) == null) {
                            field.set(parameter, new Date());
                        }
                    }
                }
            }*/
        }


        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        logger.info("[plugin]: {}", target);
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("[setProperties]:{}", properties);
    }
}
