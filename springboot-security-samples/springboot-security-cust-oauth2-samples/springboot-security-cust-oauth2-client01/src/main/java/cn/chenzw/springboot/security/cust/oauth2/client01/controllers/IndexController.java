package cn.chenzw.springboot.security.cust.oauth2.client01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


@Controller
public class IndexController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @ResponseBody
    @GetMapping("/index2")
    public void index(){
        OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
        System.out.println(accessToken);
    }



    @ResponseBody
    @GetMapping("/test")
    public String test(HttpServletRequest request){

        OAuth2AccessToken accessToken1 = oAuth2RestTemplate.getAccessToken();

        System.out.println(accessToken1);

        ResponseEntity<Object> forEntity = oAuth2RestTemplate.getForEntity("http://localhost:8080/user/me", Object.class);
        System.out.println(forEntity);
        HttpSession session = request.getSession();

        Enumeration<String> attributeNames = 
                session.getAttributeNames();

       if( attributeNames.hasMoreElements()){
           String s = attributeNames.nextElement();
           System.out.println(s);

           System.out.println(session.getAttribute(s));
       }

        System.out.println(oAuth2RestTemplate.getOAuth2ClientContext());

       OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
        System.out.println(accessToken);

        System.out.println("getAuthentication:" + SecurityContextHolder.getContext().getAuthentication());

       /* Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);*/

        //  Map<String, Object> additionalInformation = oAuth2RestTemplate.getAccessToken().getAdditionalInformation();
     //   System.out.println(additionalInformation);

       // System.out.println(SecurityContextHolder.getContext().getAuthentication());

        System.out.println("----------test----------------");
        return "登录成功";
    }
}
