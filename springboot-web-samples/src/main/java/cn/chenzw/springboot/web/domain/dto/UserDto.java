package cn.chenzw.springboot.web.domain.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String age;

    public UserDto() {

    }

    public UserDto(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
