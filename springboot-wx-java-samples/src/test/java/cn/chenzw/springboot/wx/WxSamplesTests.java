package cn.chenzw.springboot.wx;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxSamplesTests {

    @Autowired
    private WxMpService wxMpService;

    @Test
    public void testGetAccessToken() throws WxErrorException {
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId("wxfc51b046043629b7"); // 设置微信公众号的appid
        config.setSecret("e2173483b4a4a7b37bbf5609d6529f178"); // 设置微信公众号的app corpSecret
        config.setToken("123456"); // 设置微信公众号的token
        config.setAesKey("12345678"); // 设置微信公众号的EncodingAESKey

        WxMpService wxService = new WxMpServiceImpl();  // 实际项目中请注意要保持单例，不要在每次请求时构造实例，具体可以参考demo项目
        wxService.setWxMpConfigStorage(config);

        String accessToken = wxService.getAccessToken();

        log.info("getAccessToken => {}", accessToken);
    }

    @Test
    public void testGetAccessToken2() throws WxErrorException {
        String accessToken = wxMpService.getAccessToken();

        log.info("getAccessToken => {}", accessToken);
    }

    @Test
    public void testGetMenu() throws WxErrorException {
        WxMpMenu wxMpMenu = wxMpService.getMenuService().menuGet();

        log.info("menus => {}", wxMpMenu);
    }

}
