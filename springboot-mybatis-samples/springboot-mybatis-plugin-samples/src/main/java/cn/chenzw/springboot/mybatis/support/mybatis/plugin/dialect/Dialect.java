package cn.chenzw.springboot.mybatis.support.mybatis.plugin.dialect;

import cn.chenzw.springboot.mybatis.support.mybatis.plugin.Pageable;

/**
 * @author chenzw
 */
public interface Dialect {


    /**
     * 生成分页SQL
     *
     * @param sql
     * @param pageable
     * @return
     */
    String getPageSql(String sql, Pageable pageable);

}
