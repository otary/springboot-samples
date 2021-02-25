package cn.chenzw.springboot.web.controllers;

import cn.chenzw.springboot.web.domain.dto.ArrayQueryDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UrlPathHelper;

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
    public String hello2(@RequestBody Map<String, String> map, HttpServletRequest request) throws IOException {
        String requestParams = IOUtils.toString(request.getInputStream(), "UTF-8");

        log.info("request params => {}", requestParams);

        return "hello, " + MapUtils.getString(map, "userName");
    }


    @GetMapping("/arrayQuery")
    public ArrayQueryDto arrayQuery(ArrayQueryDto arrayQueryDto) {
        return arrayQueryDto;
    }

    /**
     * 使用UrlPathHelper工具类
     *
     * @param request
     */
    @GetMapping("/url-path-utils")
    public void urlPathUtils(HttpServletRequest request) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();

        log.info("getLookupPathForRequest => {}", urlPathHelper.getLookupPathForRequest(request));
        log.info("getPathWithinServletMapping => {}", urlPathHelper.getPathWithinServletMapping(request));
        log.info("getPathWithinApplication => {}", urlPathHelper.getPathWithinApplication(request));
        log.info("getRequestUri => {}", urlPathHelper.getRequestUri(request));
        log.info("getServletPath => {}", urlPathHelper.getServletPath(request));
        log.info("getContextPath => {}", urlPathHelper.getContextPath(request));
        log.info("getOriginatingQueryString => {}", urlPathHelper.getOriginatingQueryString(request));
        log.info("getOriginatingRequestUri => {}", urlPathHelper.getOriginatingRequestUri(request));
        log.info("getOriginatingServletPath => {}", urlPathHelper.getOriginatingServletPath(request));
        log.info("getOriginatingContextPath => {}", urlPathHelper.getOriginatingContextPath(request));

    }
}
