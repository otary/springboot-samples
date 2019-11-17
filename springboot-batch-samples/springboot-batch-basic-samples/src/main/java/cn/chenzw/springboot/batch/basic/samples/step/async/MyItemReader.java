package cn.chenzw.springboot.batch.basic.samples.step.async;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import cn.chenzw.toolkit.commons.RandomStringExtUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.batch.item.ItemReader;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取器
 *
 * @author chenzw
 */
public class MyItemReader implements ItemReader<Person> {

    private List<Person> persons = new ArrayList<>();

    public MyItemReader() {
        for (int i = 0; i < 500; i++) {
            Person person = new Person();
            person.setId(Long.valueOf(i));
            person.setName(RandomStringExtUtils.randomName());
            person.setAge(RandomUtils.nextInt(1, 50));
            persons.add(person);
        }
    }

    private int count = 0;

    @Override
    public Person read() {
        if (count < persons.size()) {
            return persons.get(count++);
        }
        return null;
    }

}
