package cn.chenzw.springboot.webflux.config;

import cn.chenzw.springboot.webflux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfig {

    /**
     * 基于函数式的WebFlux开发方式
     *
     * @param userHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return route(GET("/user/all"), userHandler::queryAllUserList)
                .andRoute(GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::queryUserById);
    }
}
