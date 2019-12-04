package cn.chenzw.mvc.test;

import cn.chenzw.mvc.test.service.RestService;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcOkhttpTests {

    public MockWebServer mockWebServer = new MockWebServer();


    @Autowired
    public RestService restService;


    @Before
    public void beforeClass() throws IOException {

        mockWebServer.setDispatcher(new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                if ("/v2/user/1000001".equals(request.getPath())) {
                    return new MockResponse().setResponseCode(200).setBody("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}");
                }
                return new MockResponse().setBody("O");
            }
        });

        mockWebServer.start();
    }

    @Test
    public void test() throws IOException {
        HttpUrl baseUrl = mockWebServer.url("/v2/user/1000001");

        Request request = new Request.Builder().url(baseUrl).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();

        Assert.assertEquals("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", response.body().string());
    }

    @After
    public void tearDown() throws Exception {
        // 关闭服务，因为不能重用
        mockWebServer.shutdown();
    }
}
