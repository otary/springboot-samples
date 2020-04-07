package cn.chenzw.springboot.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WebClientTests {

    private static final String baseHost = "http://localhost:8080";


    @Test
    public void testQueryAllUserList() {
        WebClient webClient = WebClient.create(baseHost);
        Mono<ServerResponse> serverResponseMono = webClient.get().uri("/user/all").retrieve().bodyToMono(ServerResponse.class);
        System.out.println(serverResponseMono.block());
    }

    @Test
    public void testQueryUserById(){
        WebClient webClient = WebClient.create(baseHost);
        Mono<ServerResponse> serverResponseMono = webClient.get().uri("/user/{id}", 1).retrieve().bodyToMono(ServerResponse.class);
        System.out.println(serverResponseMono.block());
    }
}
