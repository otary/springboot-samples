package cn.chenzw.springboot.batch.basic.samples.step.file.mapper;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PersonFieldsetMapper implements FieldSetMapper<Person> {
    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        Person person = new Person();
        person.setId(fieldSet.readLong("id"));
        person.setName(fieldSet.readString("name"));
        person.setAge(fieldSet.readInt("age"));
        return person;
    }
}
