package cn.chenzw.springboot.security.basic.json.handler;

import cn.chenzw.springboot.security.basic.json.constants.enums.ResponseStateEnum;
import cn.chenzw.toolkit.http.entity.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 角色权限认证拒绝处理器
 * @author chenzw
 */
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(objectMapper.writeValueAsString(
                    new HttpResult<>(
                            ResponseStateEnum.ACCESS_DENIED.getCode(),
                            ResponseStateEnum.ACCESS_DENIED.getMessage())));
        } catch (Exception e) {
            logger.error("Close ResposeWriter error!", e);
        }
    }
}
