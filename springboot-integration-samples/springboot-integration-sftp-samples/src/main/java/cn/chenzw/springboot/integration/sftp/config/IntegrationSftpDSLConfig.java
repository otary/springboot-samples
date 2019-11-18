package cn.chenzw.springboot.integration.sftp.config;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.dsl.Sftp;

import java.io.File;

/**
 * 方式二: Java DSL方式
 *
 * @author chenzw
 */
@Configuration
public class IntegrationSftpDSLConfig {

    @Bean
    public IntegrationFlow sftpInboundFlow(SessionFactory sftpSessionFactory) {
        return IntegrationFlows
                .from(Sftp.inboundAdapter(sftpSessionFactory)
                                .preserveTimestamp(true)
                                .remoteDirectory("/")
                                // .deleteRemoteFiles(true)
                                .regexFilter(".*\\.txt$")
                                .autoCreateLocalDirectory(true)  // 自动创建本地文件夹
                                .localFilenameExpression("#this.toUpperCase()")  // 文件名转大写
                                .localDirectory(new File("sftp-inbound")),

                        e -> e.id("sftpInboundAdapter")
                                .autoStartup(true)
                                .poller(Pollers.fixedDelay(2000))  // 定时执行间隔
                )
                .handle(m -> System.out.println("playload > " + m.getPayload()))
                .get();
    }

    /*public IntegrationFlow getFromSftp() {
        return IntegrationFlows.from(Sftp.inboundAdapter(inboundSftp)
                .localDirectory(new File(classLoader.getResource(".").getFile() + "/files/" + String.valueOf(config.getId())))
                .deleteRemoteFiles(true)
                .autoCreateLocalDirectory(true)
                .remoteDirectory(config.getInboundDirectory()), e -> e.poller(Pollers.fixedDelay(4_000)))
                .transform((File f) -> pgpEncryption.encrypt(f))
                .handle(Sftp.outboundAdapter(outboundSftp)
                        .useTemporaryFileName(false)
                        .autoCreateDirectory(true)
                        .remoteDirectory(config.getOutboundDirectory()), c -> c.advice(sftpConfig.deleteFileAdvice())
                )
                .get();
    }*/

    /*@Bean
    public IntegrationFlow pushTheFile(){
        return IntegrationFlows
                .from(s -> s.file(new File(DIR_TO_WATCH))
                                .patternFilter("*.txt").preventDuplicates(),
                        e -> e.poller(Pollers.fixedDelay(100)))
                .transform(outboundTransformer)
                .handle(Sftp.outboundAdapter(this.buildSftpSessionFactory())
                        .remoteFileSeparator("/")
                        .useTemporaryFileName(false)
                        .remoteDirectory("inbound/"), c -> c.advice(expressionAdvice(c))
                )
                .get();
    }*/


}
