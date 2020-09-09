package cn.chenzw.springboot.web.domain.dto;

import cn.chenzw.springboot.web.annotation.ArrayParameter;

public class ArrayQueryDto {

    @ArrayParameter
    private String[] ids;


    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
