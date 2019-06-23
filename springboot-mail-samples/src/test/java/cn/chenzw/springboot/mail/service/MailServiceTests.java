package cn.chenzw.springboot.mail.service;

import cn.chenzw.springboot.mail.MailSamplesApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.thymeleaf.context.Context;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MailSamplesApp.class)
@WebAppConfiguration
public class MailServiceTests {


    @Autowired
    MailService mailService;

    @Test
    public void testSendSimpleEmail() {
        mailService.sendSimpleEmail("656469722@qq.com", "文本测试邮件", "文本内容");
    }


    @Test
    public void testSendHtmlMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("656469722@qq.com", "HTML测试邮件", content);
    }

    @Test
    public void testSendAttachmentsMail() {
        String path = Thread.currentThread().getContextClassLoader().getResource("attaches/readme.txt").getPath();
        mailService.sendAttachmentsMail("656469722@qq.com", "附件测试邮件", "附件内容", new File(path));
    }

    @Test
    public void testSendTemplateMail() {
        Context context = new Context();
        context.setVariable("id", "0206");
        mailService.sendTemplateMail("656469722@qq.com", "模版测试邮件", "email-template", context);
    }
}
