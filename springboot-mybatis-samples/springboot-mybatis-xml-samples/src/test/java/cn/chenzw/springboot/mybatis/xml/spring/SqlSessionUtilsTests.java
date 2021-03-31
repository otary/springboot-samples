package cn.chenzw.springboot.mybatis.xml.spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlSessionUtilsTests {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void testGetSqlSession() {
        // 获取session
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionFactory);

        log.info("sqlSession => {}", sqlSession);
        log.info("isSqlSessionTransactional => {}", SqlSessionUtils.isSqlSessionTransactional(sqlSession, sqlSessionFactory));

        // 指定ExecutorType和PersistenceExceptionTranslator
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession(sqlSessionFactory, ExecutorType.BATCH, new MyBatisExceptionTranslator(
                sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(), true));


        // 关闭session
        SqlSessionUtils.closeSqlSession(sqlSession, sqlSessionFactory);
    }
}
