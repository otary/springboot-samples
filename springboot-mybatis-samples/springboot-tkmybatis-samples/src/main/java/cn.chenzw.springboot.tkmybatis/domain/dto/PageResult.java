package cn.chenzw.springboot.tkmybatis.domain.dto;

import com.github.pagehelper.Page;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenzw
 */
@Data
@ToString
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -862831535683690412L;

    private Long total;
    private Integer offset;
    private Integer pages;
    private Integer limit;
    private T data;

    public PageResult(Long total, Integer offset, Integer limit, Integer pages, T data) {
        this.total = total;
        this.offset = offset;
        this.limit = limit;
        this.pages = pages;
        this.data = data;
    }

    public PageResult(Page page) {
        this.total = page.getTotal();
        this.limit = page.getPageSize();
        this.offset = page.getPageNum();
        this.pages = page.getPages();
        this.data = (T) page.getResult();
    }

    public static PageResult of(Page page) {
        return new PageResult(page.getTotal(), page.getPageNum(), page.getPageSize(), page.getPages(), page.getResult());
    }

}
