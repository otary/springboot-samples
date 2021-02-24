package cn.chenzw.springboot.web.controllers;

import cn.chenzw.springboot.web.domain.dto.ArrayQueryDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Slf4j
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
            String requestParams = IOUtils.toString(request.getInputStream(), "UTF-8");

            log.info("request params => {}", requestParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello, " + MapUtils.getString(map, "userName");
    }


    @GetMapping("/arrayQuery")
    public ArrayQueryDto arrayQuery(ArrayQueryDto arrayQueryDto) {

        System.out.println("------------------" + arrayQueryDto);
        return arrayQueryDto;
    }
}
