package cn.chenzw.springboot.freemarker.controllers;

import cn.chenzw.springboot.freemarker.domain.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {


    @RequestMapping("/index")
    public String index(Model model) {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setName("张三");
        userDto.setBirth(new Date());

        model.addAttribute("user", userDto);
        return "index";
    }
}
