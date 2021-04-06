package cn.chenzw.springboot.mybatis.xml.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlSessionTests {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void testBasic() throws SQLException {
        Environment environment = sqlSessionFactory.getConfiguration().getEnvironment();
        TransactionFactory transactionFactory = environment.getTransactionFactory();
        DataSource dataSource = environment.getDataSource();

        // 开启事务
        Transaction transaction = transactionFactory.newTransaction(dataSource, null, false);

        // 创建执行器
        Executor executor = new SimpleExecutor(sqlSessionFactory.getConfiguration(), transaction);

        // 生成SqlSession
        DefaultSqlSession sqlSession = new DefaultSqlSession(sqlSessionFactory.getConfiguration(), executor, false);


        sqlSession.commit();

        transaction.close();
    }
}
