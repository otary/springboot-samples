package cn.chenzw.springboot.mybatis.xml.domain.dto;

public class PageResult<T> extends BaseResult<T> {

    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "PageResult{" + "total=" + total + "} " + super.toString();
    }
}
