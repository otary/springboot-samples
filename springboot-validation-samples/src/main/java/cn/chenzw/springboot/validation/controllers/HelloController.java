package cn.chenzw.springboot.validation.controllers;

import cn.chenzw.springboot.validation.domain.dto.UserBodyParamDto;
import cn.chenzw.springboot.validation.domain.dto.UserParamDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String say2(@Validated UserParamDto userParamDto) {
        return "hello," + userParamDto.getName();
    }

    @PostMapping("/say3")
    public String say3(@Validated @RequestBody UserBodyParamDto userBodyParamDto) {
        return "hello," + userBodyParamDto.getName();
    }

    @GetMapping("/say4")
    public String say4(@RequestParam(required = false) @NotNull String name) {
        return "hello," + name;
    }



}


