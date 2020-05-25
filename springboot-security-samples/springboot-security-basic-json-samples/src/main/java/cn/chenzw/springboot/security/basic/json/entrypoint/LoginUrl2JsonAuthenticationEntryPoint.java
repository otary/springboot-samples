package cn.chenzw.springboot.security.basic.json.entrypoint;

import cn.chenzw.springboot.security.basic.json.constants.enums.ResponseStateEnum;
import cn.chenzw.toolkit.http.entity.HttpResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未认证时的格式
 *
 * @author chenzw
 */
public class LoginUrl2JsonAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();


    /**
     * @param loginFormUrl URL where the login page can be found. Should either be
     *                     relative to the web-app context path (include a leading {@code /}) or an absolute
     *                     URL.
     */
    public LoginUrl2JsonAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(objectMapper.writeValueAsString(
                    new HttpResult<>(
                            ResponseStateEnum.USER_UNAUTHORIZED.getCode(),
                            ResponseStateEnum.USER_UNAUTHORIZED.getMessage())));
        } catch (Exception e) {
            logger.error("Close ResposeWriter error!", e);
        }
    }

}
