package cn.chenzw.springboot.integration.file.inteceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class MyChannelInteceptor implements ChannelInterceptor {

    private final Logger logger = LoggerFactory.getLogger(MyChannelInteceptor.class);

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        logger.info("[presend]> {}, {}", message, channel);
        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        logger.info("[postSend]> {}, {}", message, channel);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        logger.info("[afterSendCompletion]> {}, {}, {}", message, channel, ex);
    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        logger.info("[preReceive]> {}", channel);
        return false;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        logger.info("[postReceive]> {}, {}", message, channel);
        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        logger.info("[afterReceiveCompletion]> {}, {}, {}", message, channel, ex);
    }
}
