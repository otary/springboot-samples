package cn.chenzw.springboot.websocket.basic.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Component
@ServerEndpoint(value = "/server/{sid}")
public class WebSocketServer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<>();

    private static AtomicLong onlineCount = new AtomicLong(0);

    private String sid;

    @OnOpen
    public void onOpen(@PathParam("sid") String sid, Session session) {
        this.sid = sid;

        clients.put(sid, this);
        logger.info("新用户[{}]加入,当前连接数: [{}]!", sid, onlineCount.incrementAndGet());
    }


    @OnClose
    public void onClose() {
        clients.remove(sid);

        logger.info("用户[{}]关闭,当前连接数: [{}]!", sid, onlineCount.decrementAndGet());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("接收到用户[{}]消息:[{}]", sid, message);
    }

    @OnError
    public void onError(Session session, Throwable ex) {
        logger.error("用户[{}]连接出错!", sid, ex);
    }

}
