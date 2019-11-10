package cn.chenzw.springboot.integration.sftp.config;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.sftp.filters.SftpSimplePatternFileListFilter;
import org.springframework.integration.sftp.gateway.SftpOutboundGateway;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizer;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizingMessageSource;
import org.springframework.integration.sftp.outbound.SftpMessageHandler;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.io.File;

/**
 * 方式一
 *
 * @author chenzw
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationSftpConfig {

    @Bean
    public SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost("106.12.136.105");
        factory.setPort(22);
        factory.setUser("root");
        factory.setPassword("otary@123");
        factory.setAllowUnknownKeys(true);
        return new CachingSessionFactory<ChannelSftp.LsEntry>(factory);
    }

    @Bean
    public SftpInboundFileSynchronizer sftpInboundFileSynchronizer() {
        SftpInboundFileSynchronizer fileSynchronizer = new SftpInboundFileSynchronizer(sftpSessionFactory());
        fileSynchronizer.setDeleteRemoteFiles(false);  // 是否删除远程文件
        fileSynchronizer.setRemoteDirectory("/");  // 读取的远程目录
        fileSynchronizer.setFilter(new SftpSimplePatternFileListFilter("*.txt"));  // 读取的文件
        fileSynchronizer.setPreserveTimestamp(true);
        fileSynchronizer.setTemporaryFileSuffix("-temp"); // 正在写的文件（临时文件）前缀
        return fileSynchronizer;
    }

    /**
     * 数据源
     *
     * @return
     */
    @Bean
    @InboundChannelAdapter(channel = "sftpChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> sftpMessageSource() {
        SftpInboundFileSynchronizingMessageSource source = new SftpInboundFileSynchronizingMessageSource(
                sftpInboundFileSynchronizer());
        source.setLocalDirectory(new File("ftp-inbound"));  // 本地存储目录
        source.setAutoCreateLocalDirectory(true);  // 是否自动创建本地缓存文件夹
        source.setLocalFilter(new AcceptOnceFileListFilter<File>());
        return source;
    }

    /**
     * 输出源
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "sftpChannel")
    public MessageHandler handler() {
        return new MessageHandler() {

            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                File payload = (File) message.getPayload();

               /*try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (true) {
                    throw new RuntimeException("异常！");
                }*/
                System.out.println("------------message----:" + message.getPayload());
                System.out.println("-----------header-----:" + message.getHeaders());
            }

        };
    }

    /**
     * 列举目录文件
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "lsChannel")
    public MessageHandler lsHandler() {
        SftpOutboundGateway sftpOutboundGateway = new SftpOutboundGateway(sftpSessionFactory(), "ls", "payload");
        sftpOutboundGateway.setOptions("-dirs"); // 配置项
        return sftpOutboundGateway;
    }

    @Bean
    @ServiceActivator(inputChannel = "downloadChannel")
    public MessageHandler downloadHandler() {
        SftpOutboundGateway sftpOutboundGateway = new SftpOutboundGateway(sftpSessionFactory(), "mget", "payload");
        sftpOutboundGateway.setOptions("-R");
        sftpOutboundGateway.setFileExistsMode(FileExistsMode.REPLACE_IF_MODIFIED);
        sftpOutboundGateway.setLocalDirectory(new File("ftp-inbound2"));
        sftpOutboundGateway.setAutoCreateLocalDirectory(true);
        return sftpOutboundGateway;
    }

    /**
     * 上传文件
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "uploadChannel")
    public MessageHandler uploadHandler() {
        SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory());
        handler.setRemoteDirectoryExpression(new LiteralExpression("/"));  // 上传的目录
        handler.setFileNameGenerator(message -> {
            if (message.getPayload() instanceof File) {
                return ((File) message.getPayload()).getName();
            } else {
                throw new IllegalArgumentException("File expected as payload.");
            }
        });
        return handler;
    }


}
