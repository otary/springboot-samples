package cn.chenzw.springboot.integration.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.splitter.FileSplitter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.ErrorHandler;

import java.io.File;

//@Configuration
//@EnableIntegration
//@IntegrationComponentScan
public class IntegrationFileConfig {

    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel processFileChannel() {
        DirectChannel dc = new DirectChannel();
        dc.subscribe(processFileOutbound());
        return dc;
    }

    @Bean
    public MessageChannel doneFileChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel errorFileChannel() {
        return new DirectChannel();
    }


    @Bean
    public ErrorHandler errorHandler(MessageChannel errorFileChannel) {
        return new ErrorHandler() {

            @Override
            public void handleError(Throwable throwable) {

                System.out.println("---------error----------" + throwable);

                if (throwable.getCause() instanceof MessagingException) {
                    MessagingException exception = (MessagingException) throwable.getCause();

                    Object payload = exception.getFailedMessage().getPayload();
                    if (payload instanceof File) {
                        errorFileChannel.send(MessageBuilder.withPayload((File) payload).build());
                    }
                }
            }
        };
    }

    @ServiceActivator(inputChannel = "processFileChannel", autoStartup = "true")
    private MessageHandler processFileOutbound() {
        return new MessageHandler() {

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("-----------------" + message);

                //throw new RuntimeException("抛出异常!");
            }
        };
    }


    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File("ftp-inbound"));
        source.setFilter(new SimplePatternFileListFilter("*.txt"));
        source.setFilter(new AcceptOnceFileListFilter());
        return source;
    }

   /* @Bean
    @Transformer(inputChannel = "fileInputChannel", outputChannel = "processFileChannel")
    public FileToStringTransformer fileToStringTransformer() {
        return new FileToStringTransformer();
    }*/

    /*@Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public FileWritingMessageHandler messageProcessHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("file-outbound"));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setDeleteSourceFiles(true);
        handler.setPreserveTimestamp(true);
        handler.setOutputChannel(processFileChannel());
        return handler;
    }*/

    @Bean
    @ServiceActivator(inputChannel = "doneFileChannel")
    public FileWritingMessageHandler messageDoneHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("file-outbound-done"));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        //   handler.setDeleteSourceFiles(true);
        handler.setExpectReply(false);
        return handler;
    }

    @Bean
    @ServiceActivator(inputChannel = "errorFileChannel")
    public FileWritingMessageHandler messageErrorHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("file-outbound-error"));
        handler.setFileExistsMode(FileExistsMode.REPLACE);
        // handler.setDeleteSourceFiles(true);
        handler.setExpectReply(false);
        return handler;
    }

    /*@ServiceActivator(inputChannel = "fileInputChannel", outputChannel = "doneFileChannel")
    public File process(File file) {

        System.out.println("done >>>" + file);

        return file;
    }*/

    @Bean
    @Splitter(inputChannel = "fileInputChannel")
    public MessageHandler fileSplitter() {
        FileSplitter splitter = new FileSplitter(true, true, true);
        splitter.setApplySequence(true);
        splitter.setOutputChannel(processFileChannel());
        return splitter;
    }


}
