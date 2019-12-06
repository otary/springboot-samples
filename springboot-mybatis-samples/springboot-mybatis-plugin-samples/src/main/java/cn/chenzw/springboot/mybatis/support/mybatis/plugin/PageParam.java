package cn.chenzw.springboot.mybatis.support.mybatis.plugin;

/**
 * @author chenzw
 */
public class PageParam implements Pageable {

    private int offset = 0;
    private int limit = 25;
    private long total = -1;

    public PageParam(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public long getTotalRows() {
        return total;
    }



}
