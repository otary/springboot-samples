package cn.chenzw.springboot.web.controllers;

import cn.chenzw.springboot.web.domain.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formatter")
public class FormatterController {

    @GetMapping("/users/{userId}")
    public UserDto getUserInfo(@PathVariable("userId") UserDto userDto) {
        return userDto;
    }
}
