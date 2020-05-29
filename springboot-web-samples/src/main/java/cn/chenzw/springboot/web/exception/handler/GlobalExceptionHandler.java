package cn.chenzw.springboot.web.exception.handler;

import cn.chenzw.toolkit.spring.ratelimit.exception.RateLimitException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handleMultipartException(MultipartException e) {
        return "上传出错!";
    }

    @ExceptionHandler(RateLimitException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpEntity handleRateLimitException(RateLimitException e) {
        return new HttpEntity(e.getMessage());
    }
}
