package cn.chenzw.springboot.batch.basic.samples.repository;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import cn.chenzw.springboot.batch.basic.samples.support.mybatis.TkMyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@TkMyBatisRepository
public interface PersonMapper {

    void insertBatch(@Param("persons") List<Person> persons);

    List<Person> select();
}
