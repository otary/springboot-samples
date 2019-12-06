package cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.db;

import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;
import cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.AbstractDialect;

/**
 * @author chenzw
 */
public class H2Dialect extends AbstractDialect {

    @Override
    public String getPageSql(String sql, Pageable pageable) {
        return sql + " limit " + pageable.getLimit() + "  offset " + pageable.getOffset();
    }
}
