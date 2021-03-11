package cn.chenzw.springboot.tkmybatis.support.generator;

import tk.mybatis.mapper.genid.GenId;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义ID生成器
 */
public class CustIdGenerator implements GenId<String> {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public String genId(String table, String column) {
        return table + "_" + counter.incrementAndGet();
    }
}
