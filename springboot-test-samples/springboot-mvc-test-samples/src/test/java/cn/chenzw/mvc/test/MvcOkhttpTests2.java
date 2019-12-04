package cn.chenzw.mvc.test;

import cn.chenzw.mvc.test.service.RestService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockserver.model.Cookie.cookie;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcOkhttpTests2 {


    @Autowired
    RestService restService;

    private static MockServerClient serverClient;

    @BeforeClass
    public static void beforeClass() {
        // 1. 8000端口启动服务
        ClientAndServer.startClientAndServer(8000);

        // 2. new 一个操作服务端行为的实例
        serverClient = new MockServerClient("localhost", 8000);

        // 3. 定义服务端的行为
        serverClient
                .when(request()
                        .withMethod("GET")
                        .withPath("/v2/user/1000001"))
                .respond(response()
                        .withStatusCode(200)
                        .withBody("{\"id\": \"1\"}"));

        serverClient
                .when(request()
                        .withMethod("GET")
                        .withPath("/path/function")
                        .withCookies(cookie("session", "4930456C-C718-476F-971F-CB8E047AB349"))
                        .withQueryStringParameters(param("cartId", "055CA455-1DF7-45BB-8535-4F83E7266092")))
                .respond(response()
                        .withStatusCode(307)
                        .withBody("{\"id\": \"2\"}"));
    }


    /**
     * 使用MockServer
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        String userInfo2 = restService.getUserInfo2();

        Assert.assertEquals("{\"id\": \"1\"}", userInfo2);

    }

}
