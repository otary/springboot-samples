package cn.chenzw.springboot.web.exception.handler;

import cn.chenzw.toolkit.spring.ratelimit.exception.RateLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * @author chenzw
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handleMultipartException(MultipartException ex) {
        log.error("上传出错!", ex);

        return "上传出错!";
    }

    @ExceptionHandler(RateLimitException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpEntity handleRateLimitException(RateLimitException ex) {
        log.error("限度异常!", ex);

        return new HttpEntity(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex) {
        log.info("未知异常!", ex);
    }
}
