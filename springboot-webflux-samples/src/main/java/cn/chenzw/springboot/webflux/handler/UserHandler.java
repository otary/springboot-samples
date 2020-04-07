package cn.chenzw.springboot.webflux.handler;

import cn.chenzw.springboot.webflux.domain.entity.User;
import cn.chenzw.springboot.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;


    public Mono<ServerResponse> queryAllUserList(ServerRequest request) {
        Flux<User> allUser = userService.queryAllUserList();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allUser, User.class);
    }

    public Mono<ServerResponse> queryUserById(ServerRequest request) {
        Long uid = Long.valueOf(request.pathVariable("id"));
        Mono<User> user = userService.queryUserById(uid);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(user, User.class);
    }
}
