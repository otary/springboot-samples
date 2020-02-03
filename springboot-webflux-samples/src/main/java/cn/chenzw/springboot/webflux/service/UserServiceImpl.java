package cn.chenzw.springboot.webflux.service;

import cn.chenzw.springboot.webflux.domain.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<Long, User> userMap = new HashMap<>(4);

    static {
        userMap.put(1L, new User(1L, "admin"));
        userMap.put(2L, new User(2L, "admin2"));
        userMap.put(3L, new User(3L, "admin3"));
    }


    @Override
    public Flux<User> queryAllUserList() {
        return Flux.fromIterable(userMap.values());
    }

    @Override
    public Mono<User> queryUserById(Long id) {
        return Mono.just(userMap.get(id));
    }
}
