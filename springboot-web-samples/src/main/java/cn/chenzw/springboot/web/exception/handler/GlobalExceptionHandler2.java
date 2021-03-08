package cn.chenzw.springboot.web.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author chenzw
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE) // 调整优先级 => 优先级更高
public class GlobalExceptionHandler2 {

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex) {
        log.info("未知异常2!", ex);
    }
}
