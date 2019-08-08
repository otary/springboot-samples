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

    @PostMapping("/throw-bind-exception")
    public String throwBindException(@Validated UserParamDto userParamDto) {
        return "hello," + userParamDto.getName();
    }

    @PostMapping("/throw-method-argument-not-valid-exception")
    public String throwMethodArgumentNotValidException(@Validated @RequestBody UserBodyParamDto userBodyParamDto) {
        return "hello," + userBodyParamDto.getName();
    }

    @GetMapping("/throw-constraint-violation-exception")
    public String throwConstraintViolationException(@RequestParam(required = false) @NotNull String name) {
        return "hello," + name;
    }

    @GetMapping("/throw-constraint-violation-exception2")
    public String throwConstraintViolationException2(@NotNull String name) {
        return "hello," + name;
    }

}


