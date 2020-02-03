package cn.chenzw.springboot.webflux.service;

import cn.chenzw.springboot.webflux.domain.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> queryAllUserList();

    Mono<User> queryUserById(Long id);
}
