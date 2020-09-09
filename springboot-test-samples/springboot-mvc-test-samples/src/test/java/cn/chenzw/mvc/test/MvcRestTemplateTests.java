package cn.chenzw.mvc.test;

import cn.chenzw.mvc.test.service.RestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcRestTemplateTests {

    private MockRestServiceServer server;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public RestService restService;


    @Before
    public void beforeClass() {
        server = MockRestServiceServer.bindTo(restTemplate).build();
        server.expect(manyTimes(), requestTo("http://api.douban.com2/v2/user/1000001")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", MediaType.APPLICATION_JSON));
    }

    @Test
    public void test() {
        String userInfo = restService.getUserInfo();
        Assert.assertEquals("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", userInfo);
    }


}
