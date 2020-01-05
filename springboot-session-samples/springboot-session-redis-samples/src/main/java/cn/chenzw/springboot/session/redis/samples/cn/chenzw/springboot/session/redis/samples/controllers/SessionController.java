package cn.chenzw.springboot.session.redis.samples.cn.chenzw.springboot.session.redis.samples.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/me")
    public void getSession(HttpServletRequest request) {
        logger.info(request.getSession().getClass().getCanonicalName());
        // => org.springframework.session.web.http.SessionRepositoryFilter.SessionRepositoryRequestWrapper.HttpSessionWrapper
    }

}
