package cn.chenzw.springboot.mbean;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * 可通過JConsole來连接访问
 */
@Component
@ManagedResource(
        objectName = "org.pc.jmx:type=HelloBean",
        description = "描述内容"
)
public class HelloBean {


    private long id;
    private String name;
    private int age;


    /**
     * 暴露属性
     */
    @ManagedAttribute(description = "这是属性id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 暴露属性
     */
    @ManagedAttribute(description = "这是属性name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 暴露属性
     */
    @ManagedAttribute(description = "这是属性age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 暴露方法
     */
    @ManagedOperation(description = "这里是操作")
    public String display() {
        return this.toString();
    }

}
