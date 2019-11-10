package cn.chenzw.springboot.integration.basic;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.scheduling.PollerMetadata;

import java.io.File;
import java.io.IOException;


import static java.lang.System.getProperty;

@Configuration
public class Test22 {

    /*@Bean
    public IntegrationFlow getOrdersFromHttpRequest(MessageChannel inboundOrderChannel) {
        return IntegrationFlows
                .from(inboundOrderChannel)  // 流程从from方法开始
                .enrich(orderWithEmbedded -> orderWithEmbedded
                        .requestSubFlow(subflow -> subflow
                                .transform(new RealOrderToExchangeableCustomer()) // transform to ExchangeableCustomer
                                .handle(salesforceClient, "createOrUpdateCustomer"))
                        .propertyExpression("salesAccountId", "payload")
                        .sendTimeout(10000)
                )
                .transform(new RealOrderToExchangeableOrder())
                .handle(this::sendOrderToNetsuite)
                .get();
    }*/



   /* @Bean
    public IntegrationFlow demoFlow() {
        return IntegrationFlows.from("input")  //从Channel input获取消息
                .<String, Integer>transform(Integer::parseInt) //将消息转换成整数
                .get();  //获得集成流程并注册为Bean
    }*/

    @Value("https://spring.io/blog.atom")
    Resource resource;

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {  //使用Fluent API和Pollers配置默认的轮询方式
        return Pollers.fixedRate(500).get();
    }

    @Bean
    public FeedEntryMessageSource feedEntryMessageSource() throws IOException { //FeedEntryMessageSource实际为feed:inbound-channel-adapter,此处即构造feed的入站通道适配器作为数据输入
        FeedEntryMessageSource messageSource = new FeedEntryMessageSource(resource.getURL(), "news");
        return messageSource;
    }

    @Bean
    public IntegrationFlow myFlow() throws IOException {
        return IntegrationFlows.from(feedEntryMessageSource())  //流程从from方法开始
                .<SyndEntry, String>route(payload ->
                                payload.getCategories().get(0).getName(),  //通过路由方法route来选择路由，消息体（payload）的类型为SyndEntry，作为判断条件的类型为String，判断的值是通过payload获得的分类（Categroy）;
                        mapping -> mapping.channelMapping("releases",
                                "releasesChannel")  //通过不同分类的值转向不同的消息通道，若分类为releases，则转向releasesChannel;

                )
                .get();   //通过get方法获得IntegrationFlow实体，配置为Spring的Bean。
    }

    @Bean
    public IntegrationFlow releasesFlow() {
        return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 10)) //1
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator")) //2
                .handle(Files.outboundAdapter(new File("e:/springblog")) //3
                        .fileExistsMode(FileExistsMode.APPEND) //4
                        .charset("UTF-8") //5
                        .fileNameGenerator(message -> "releases.txt") //6
                        .get())
                .get();
    }




}
