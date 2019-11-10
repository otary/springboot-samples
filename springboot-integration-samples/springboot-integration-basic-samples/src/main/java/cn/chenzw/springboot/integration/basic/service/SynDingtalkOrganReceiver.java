package cn.chenzw.springboot.integration.basic.service;

import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 *
 */
//@Service
public class SynDingtalkOrganReceiver {

   // @Resource
   // private ExecutorService executorService;

   // @ServiceActivator(inputChannel = "synDingtalkOrganQueueChannel", poller = @Poller)
    public void onMessage(Long userId) {

        System.out.println("------------onMessage--------------");
      /*  executorService.execute(() -> {
            System.out.println("------------------:处理");
            *//**
             *  处理数据
             * *//*
        });*/
    }
}
