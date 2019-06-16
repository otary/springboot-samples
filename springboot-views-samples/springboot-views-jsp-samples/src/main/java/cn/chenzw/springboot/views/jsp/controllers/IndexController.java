package cn.chenzw.springboot.views.jsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/home")
    public String homePage() {
        return "homepage";
    }
}
