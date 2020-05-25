package cn.chenzw.springboot.security.basic.json.handler;

import cn.chenzw.springboot.security.basic.json.constants.enums.ResponseStateEnum;
import cn.chenzw.toolkit.http.entity.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录失败处理器
 *
 * @author chenzw
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(objectMapper.writeValueAsString(
                    new HttpResult<>(
                            ResponseStateEnum.FAILURE.getCode(),
                            exception.getMessage())));
        } catch (Exception e) {
            logger.error("Close ResposeWriter error!", e);
        }

    }
}
