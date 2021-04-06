package cn.chenzw.springboot.webflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClientTests {

    private static final String baseHost = "http://localhost:8080";

    @Autowired
    WebTestClient webTestClient;

//    @Test
//    public void testQueryAllUserList() {
//        WebClient webClient = WebClient.create(baseHost);
//        Mono<ServerResponse> serverResponseMono = webClient.get().uri("/user/all").retrieve().bodyToMono(ServerResponse.class);
//
//        log.info("testQueryAllUserList => {}", serverResponseMono.block());
//    }
//
//    @Test
//    public void testQueryUserById(){
//        WebClient webClient = WebClient.create(baseHost);
//        Mono<ServerResponse> serverResponseMono = webClient.get().uri("/user/{id}", 1).retrieve().bodyToMono(ServerResponse.class);
//
//        log.info("testQueryUserById => {}",serverResponseMono.block() );
//    }

    @Test
    public void testQueryAllUserList() {
        webTestClient.get().uri("/user/all")
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("[{\"id\":1,\"name\":\"admin\"},{\"id\":2,\"name\":\"admin2\"},{\"id\":3,\"name\":\"admin3\"}]");
    }

    @Test
    public void testQueryUserById() {
        webTestClient.get().uri("/user/{id}", 1)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json("{\"id\":1,\"name\":\"admin\"}");
    }
}
