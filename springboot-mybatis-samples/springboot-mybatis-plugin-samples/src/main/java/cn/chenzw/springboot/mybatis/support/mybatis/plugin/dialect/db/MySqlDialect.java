package cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.db;

import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;
import cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.Dialect;

/**
 * @author chenzw
 */
public class MySqlDialect implements Dialect {

    @Override
    public String getPageSql(String sql, Pageable pageable) {
        return sql + " limit " + pageable.getOffset() + " , " + pageable.getLimit();
    }
}
