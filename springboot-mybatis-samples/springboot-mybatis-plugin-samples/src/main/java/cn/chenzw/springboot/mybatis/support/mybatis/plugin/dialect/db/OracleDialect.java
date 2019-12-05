package cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.db;

import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;
import cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.Dialect;

/**
 * Oracle实现
 *
 * @author chenzw
 */
public class OracleDialect implements Dialect {


    @Override
    public String getPageSql(String sql, Pageable pageable) {
        int start = pageable.getOffset() * pageable.getLimit();
        int end = start + pageable.getLimit();

        return "SELECT * " + "  FROM (SELECT t________.*, ROWNUM rownum_ FROM (" + sql + ") t________) "
                + " WHERE rownum_ > " + start + "   AND rownum_ <= " + end;
    }
}
