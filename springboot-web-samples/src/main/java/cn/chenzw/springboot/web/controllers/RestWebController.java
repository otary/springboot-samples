package cn.chenzw.springboot.web.controllers;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RestWebController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello!";
    }

    @PostMapping("/hello")
    public String hello2(@RequestBody Map<String, String> map, HttpServletRequest request) {
        try {
            String s = IOUtils.toString(request.getInputStream(), "UTF-8");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello, " + MapUtils.getString(map, "username");
    }
}
