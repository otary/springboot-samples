package cn.chenzw.springboot.batch.basic.samples.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Person implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String nation;
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", birth=" + birth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return id.equals(person.id) && name.equals(person.name) && age.equals(person.age) && birth.equals(person.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, birth);
    }
}
