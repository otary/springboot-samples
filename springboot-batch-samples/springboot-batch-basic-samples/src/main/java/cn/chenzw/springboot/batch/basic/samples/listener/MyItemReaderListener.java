package cn.chenzw.springboot.batch.basic.samples.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;


/**
 * read监听器
 *
 * @author chenzw
 */
public class MyItemReaderListener implements ItemReadListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void beforeRead() {
        logger.info("before read...");
    }

    @Override
    public void afterRead(Object o) {
        logger.info("after read! target: {}", o);
    }

    @Override
    public void onReadError(Exception e) {
        if (e instanceof FlatFileParseException) {
            FlatFileParseException parseException = (FlatFileParseException) e;
            logger.error("read with error! data: [{} - {}], exception: [{} - {}]", parseException.getLineNumber(), parseException.getInput() , e.getClass().getSimpleName(), e.getLocalizedMessage());
        } else {
            logger.error("read with error! exception: {} - {}", e.getClass(), e.getLocalizedMessage());
        }

    }
}
