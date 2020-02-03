package cn.chenzw.springboot.webflux.controller;

import cn.chenzw.springboot.webflux.domain.entity.User;
import cn.chenzw.springboot.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 兼容webmvc方式
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public Mono<ServerResponse> queryAllUserList() {
        Flux<User> allUser = userService.queryAllUserList();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allUser, User.class);
    }

    @GetMapping("/{id}")
    public Mono<ServerResponse> queryUserById(ServerRequest request) {
        Long uid = Long.valueOf(request.pathVariable("id"));
        Mono<User> user = userService.queryUserById(uid);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(user, User.class);
    }
}
