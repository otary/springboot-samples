package cn.chenzw.springboot.mybatis.support.mybatis.plugin;

/**
 * 分页信息
 *
 * @author chenzw
 */
public interface Pageable {

    /**
     * 第几页
     *
     * @return
     */
    int getOffset();

    /**
     * 每页条数
     *
     * @return
     */
    int getLimit();

    /**
     * 总条数
     *
     * @return
     */
    long getTotalRows();

}
