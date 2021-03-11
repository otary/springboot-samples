package cn.chenzw.springboot.mybatisplus.support;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义ID生成器
 *
 * @author chenzw
 */
public class CustIdGenerator implements IdentifierGenerator {

    private AtomicInteger counter = new AtomicInteger(0);

    /**
     * 对应于 IdType.ASSIGN_ID
     *
     * @param entity
     * @return
     */
    @Override
    public Number nextId(Object entity) {
        String bizKey = entity.getClass().getName();

        // 此处实现获取分布式ID

        return counter.incrementAndGet();
    }

    /**
     * 对应于 IdType.ASSIGN_UUID
     *
     * @param entity
     * @return
     */
    @Override
    public String nextUUID(Object entity) {
        String bizKey = entity.getClass().getName();

        return bizKey + counter.incrementAndGet();
    }
}
