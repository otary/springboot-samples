package cn.chenzw.springboot.mockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    public String getUserInfo() {
        return restTemplate.getForObject("http://api.douban.com/v2/user/1000001", String.class);
    }
}
