package cn.chenzw.springboot.validation.controllers;

import cn.chenzw.springboot.validation.domain.dto.UserParamDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/hello")
@Validated
public class HelloController {

    @GetMapping("/say")
    public String say(@NotNull String name) {
        return "hello," + name;
    }

    @PostMapping("/say2")
    public String say2(UserParamDto userParamDto) {
        return "hello," + userParamDto.getName();
    }


}
