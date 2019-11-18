package cn.chenzw.springboot.integration.file.config;

import cn.chenzw.springboot.integration.file.inteceptor.MyChannelInteceptor;
import cn.chenzw.springboot.integration.file.util.TransformUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.dsl.FileInboundChannelAdapterSpec;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationFileDSLConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public IntegrationFlow processFilesFlow() throws IOException {
        return IntegrationFlows.from(fileReadingMessageSource2(), c -> c.poller(poller()))
                .channel(fileInputChannel2())
                .<File, String>transform(f -> TransformUtils.transformFileToString(f))  // => File 转 String
                // .transform(fileToStringTransformer())
                .channel(stringInputChannel2())
                .handle(readContent())
                .get();
    }

    @Bean
    public FileToStringTransformer fileToStringTransformer() {
        return new FileToStringTransformer();
    }

    /**
     * 输入源
     *
     * @return
     */
    @Bean
    public MessageSource<File> fileReadingMessageSource2() throws IOException {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setAutoCreateDirectory(true);
        source.setDirectory(new ClassPathResource("file-inbound").getFile());  // 读取文件的目录

        CompositeFileListFilter<File> filters = new CompositeFileListFilter<>();
        filters.addFilter(new SimplePatternFileListFilter("*.txt"));
        filters.addFilter(new AcceptOnceFileListFilter<>());  // 只允许一次读
        source.setFilter(filters);  // 文件过滤

        return source;
    }

    /**
     * 轮询器
     *
     * @return
     */
    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(1000).get();
    }

    /**
     * 输入通道
     *
     * @return
     */
    @Bean
    public MessageChannel fileInputChannel2() {
        DirectChannel directChannel = MessageChannels.direct().get();
        directChannel.addInterceptor(new MyChannelInteceptor());
        return directChannel;
    }

    /**
     * 输出通道
     *
     * @return
     */
    @Bean
    public MessageChannel stringInputChannel2() {
        return MessageChannels.direct().get();
    }

    /**
     * 输出文件内容
     *
     * @return
     */
    @Bean
    public MessageHandler readContent() {
        return message -> {
            logger.info("file: {}, message: {}", message, message.getPayload());
        };
    }


}
