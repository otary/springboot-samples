package cn.chenzw.springboot.resource.message.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/name")
    public String getName() {
        return messageSource.getMessage("my.name", null,  LocaleContextHolder.getLocale());
    }
}
