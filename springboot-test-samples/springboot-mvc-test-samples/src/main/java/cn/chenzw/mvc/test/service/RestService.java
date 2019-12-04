package cn.chenzw.mvc.test.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;


    OkHttpClient okHttpClient = new OkHttpClient();


    public String getUserInfo() {
        return restTemplate.getForObject("http://api.douban.com/v2/user/1000001", String.class);
    }

    public String getUserInfo2() throws IOException {
        Request request = new Request.Builder().url("http://localhost:8000/v2/user/1000001").build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }
}
