package cn.chenzw.springboot.mockito;

import cn.chenzw.springboot.mockito.service.RestService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
// @RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MockitoTests {

    @Autowired
    public RestService restService;

    private static MockRestServiceServer server;

    @Autowired
    private RestTemplate restTemplate;


    @Before
    public void beforeClass() {
        server = MockRestServiceServer.bindTo(restTemplate).build();
        server.expect(manyTimes(), requestTo("http://api.douban.com/v2/user/1000001")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", MediaType.APPLICATION_JSON));

      //  server.expect(manyTimes(), requestTo("/test")).andRespond(withSuccess("{}", MediaType.APPLICATION_JSON));
    }

    @Test
    public void test3(){

        System.out.println(server);
        System.out.println(restTemplate);



      RestTemplate restTemplate = new RestTemplate();
      MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

        server.expect(manyTimes(), requestTo("http://api.douban.com/v2/user/1000001")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", MediaType.APPLICATION_JSON));


        restService.getUserInfo();

    //    String forObject = restTemplate.getForObject("http://api.douban.com/v2/user/{id}", String.class, 1000001);
      //  System.out.println(forObject);
        // Use the hotel instance...

        // Verify all expectations met
        server.verify();
    }


    @Test
    public void test2() {
        //String userInfo = restService.getUserInfo();

        String forObject = restTemplate.getForObject("/test", String.class);

        System.out.println(forObject);
    }

    @Test
    public void test() {
        // mock creation 创建mock对象
        List mockedList = mock(List.class);

        //using mock object 使用mock对象
        mockedList.add("one");
        //  mockedList.clear();

        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());


        System.out.println(mockedList.get(0));
        //  System.out.println(mockedList.get(1));

        //verification 验证
        //   verify(mockedList).add("one");
        //   verify(mockedList).clear();
    }
}
