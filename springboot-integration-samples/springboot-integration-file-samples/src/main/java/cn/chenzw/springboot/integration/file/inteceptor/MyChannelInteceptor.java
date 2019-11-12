package cn.chenzw.springboot.integration.file.inteceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class MyChannelInteceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("---------preSend----------" + message);

        // channel.send(message);

        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.println("------postSend----------" + message);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        System.out.println("-------afterSendCompletion------------" + message);
    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        System.out.println("----------preReceive------------");
        return false;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        System.out.println("------------postReceive---------------" + message);
        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        System.out.println("-----------afterReceiveCompletion--------------" + message);
    }
}
