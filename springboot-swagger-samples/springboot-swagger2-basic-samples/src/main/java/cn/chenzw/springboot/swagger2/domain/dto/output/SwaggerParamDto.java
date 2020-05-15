package cn.chenzw.springboot.swagger2.domain.dto.output;

import java.util.List;

public class SwaggerParamDto {

    private Integer page;
    private Integer limit;

    private List<String> list2;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList2(List<String> list2) {
        this.list2 = list2;
    }

    @Override
    public String toString() {
        return "SwaggerParamDto{" +
                "page=" + page +
                ", limit=" + limit +
                ", list2=" + list2 +
                '}';
    }
}
