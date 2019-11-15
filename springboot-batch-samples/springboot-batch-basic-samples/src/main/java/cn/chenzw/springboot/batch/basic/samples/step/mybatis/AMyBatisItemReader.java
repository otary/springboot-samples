package cn.chenzw.springboot.batch.basic.samples.step.mybatis;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import cn.chenzw.springboot.batch.basic.samples.repository.PersonMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AMyBatisItemReader extends MyBatisPagingItemReader<Person> {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public AMyBatisItemReader(SqlSessionFactory sqlSessionFactory) {
        this.setSqlSessionFactory(sqlSessionFactory);
        this.setQueryId(PersonMapper.class.getName() + ".select");
        // this.setParameterValues();
        this.setPageSize(50);
    }


}