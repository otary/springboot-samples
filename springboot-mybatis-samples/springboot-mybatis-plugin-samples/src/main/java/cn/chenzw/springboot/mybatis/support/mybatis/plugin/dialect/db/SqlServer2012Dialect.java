package cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.db;

import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;
import cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect.AbstractDialect;

public class SqlServer2012Dialect extends AbstractDialect {

    @Override
    public String getPageSql(String sql, Pageable pageable) {
        int startRow = pageable.getLimit() * pageable.getOffset();
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
        sqlBuilder.append(sql);
        sqlBuilder.append(" OFFSET ").append(startRow).append(" ROWS FETCH NEXT ").append(pageable.getLimit()).append(" ROWS ONLY ");
        return sqlBuilder.toString();
    }
}
