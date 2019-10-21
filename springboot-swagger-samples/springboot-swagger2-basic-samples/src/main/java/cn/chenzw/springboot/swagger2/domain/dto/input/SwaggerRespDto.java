package cn.chenzw.springboot.swagger2.domain.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Swagger响应对象")
public class SwaggerRespDto {

    private Long id;

    @ApiModelProperty(value = "名称", name = "name", required = true, example = "example")
    private String name;


    @ApiModelProperty(value = "性别", name = "sex", required = true, example = "男", allowableValues = "男,女")
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "SwaggerRespDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
