package cn.chenzw.springboot.aop.serivce;

import cn.chenzw.springboot.aop.AopSamplesApp;
import cn.chenzw.springboot.aop.ext.SysLogAdvice;
import cn.chenzw.springboot.aop.service.AopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AopSamplesApp.class})
@WebAppConfiguration
public class AopServiceTests {

    @Autowired
    AopService aopService;

    @Test
    public void testDoSomething() {
        aopService.doSomething();
    }

    @Test
    public void testDoWithReturn() {
        aopService.doWithReturn();
    }

    @Test(expected = RuntimeException.class)
    public void testDoThrowException() {
        aopService.doThrowExcetpion();
    }

    @Test
    public void testDoWithArgs() {
        aopService.doWithArgs("查询", 1, 10);
    }

    /**
     * AOP对静态方法不生效
     */
    @Test
    public void testDoWithStaticMethod() {
        aopService.doWithStaticMethod();
    }

    /**
     * 自定义代理
     */
    @Test
    public void testCustProxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTargetClass(AopService.class);
        proxyFactory.setInterfaces(AopService.class.getInterfaces());
        proxyFactory.addAdvice(new SysLogAdvice());

        AopService proxy = (AopService) proxyFactory.getProxy();

    }
}
