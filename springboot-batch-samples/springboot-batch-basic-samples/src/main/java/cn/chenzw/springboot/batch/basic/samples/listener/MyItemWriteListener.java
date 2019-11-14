package cn.chenzw.springboot.batch.basic.samples.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

/**
 * 写操作监听器
 *
 * @author chenzw
 */
public class MyItemWriteListener implements ItemWriteListener {

    private final Logger logger = LoggerFactory.getLogger(MyItemWriteListener.class);

    @Override
    public void beforeWrite(List items) {
        logger.info("before write, target: {} ", items);
    }

    @Override
    public void afterWrite(List items) {
        logger.info("after write, target: {} ", items);
    }

    @Override
    public void onWriteError(Exception exception, List items) {
        logger.error("write with error! data:[{}], exception:[{} - {}]", items, exception.getClass().getSimpleName(), exception.getLocalizedMessage());
    }
}
