package cn.chenzw.springboot.thymeleaf.controllers;

import cn.chenzw.springboot.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/home")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("message", "chenzw");

        // eq
        modelMap.addAttribute("name", "neo");
        modelMap.addAttribute("age", 30);
        modelMap.addAttribute("flag", "yes");

        // if/unless
        modelMap.addAttribute("flag", "yes");

        // each
        List<User> list = new ArrayList<User>();
        list.add(new User("大牛", 12, "123456"));
        list.add(new User("小牛", 6, "123563"));
        list.add(new User("纯洁的微笑", 66, "666666"));
        modelMap.addAttribute("users", list);

        // switch
        modelMap.addAttribute("sex", "woman");

        // href
        modelMap.addAttribute("type", "link");
        modelMap.addAttribute("pageId", "springcloud/2017/09/11/");

        // style
        modelMap.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");

        return "home";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }
}
