package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;

@Slf4j
@RestController
@RequestMapping("/context")
public class ContextController {


    @Autowired
    WebApplicationContext webApplicationContext;


    @GetMapping("/findWebApplicationContext")
    public void findWebApplicationContext(HttpServletRequest request) {
        WebApplicationContext wac = RequestContextUtils.findWebApplicationContext(request);

        log.info("RequestContextUtils.findWebApplicationContext => {}", wac);  // => AnnotationConfigServletWebServerApplicationContext
        log.info("容器比对 => {}", wac == webApplicationContext);
    }


    @GetMapping("/getLocaleResolver")
    public void testGetLocaleResolver(HttpServletRequest request) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

        log.info("GetLocaleResolver => {}", localeResolver); // => AcceptHeaderLocaleResolver
    }

    @GetMapping("/getLocale")
    public void testGetLocale(HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request);

        log.info("GetLocale => {}", locale);
    }

    @GetMapping("/getTimeZone")
    public void testGetTimeZone(HttpServletRequest request) {
        TimeZone timeZone = RequestContextUtils.getTimeZone(request);

        log.info("GetTimeZone => {}", timeZone);
    }

    @GetMapping("/getThemeResolver")
    public void testGetThemeResolver(HttpServletRequest request) {
        ThemeResolver themeResolver = RequestContextUtils.getThemeResolver(request);

        log.info("GetThemeResolver => {}", themeResolver);  // => FixedThemeResolver
    }

    @GetMapping("/getTheme")
    public void testGetTheme(HttpServletRequest request) {
        Theme theme = RequestContextUtils.getTheme(request);

        log.info("GetTheme => {}", theme);
    }

    @GetMapping("/getRequestAttributes")
    public void testGetRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        String[] attributeNames = requestAttributes.getAttributeNames(RequestAttributes.SCOPE_REQUEST);
        log.info("GetRequestAttributes SCOPE_REQUEST => {}", Arrays.toString(attributeNames));

        String[] attributeSessionNames = requestAttributes.getAttributeNames(RequestAttributes.SCOPE_SESSION);
        log.info("GetRequestAttributes SCOPE_SESSION => {}", Arrays.toString(attributeSessionNames));

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("获取Request => {}", request);

        HttpServletResponse response = ((org.springframework.web.context.request.ServletRequestAttributes)
                org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).getResponse();
        log.info("获取Response => {}", response);
    }

}
