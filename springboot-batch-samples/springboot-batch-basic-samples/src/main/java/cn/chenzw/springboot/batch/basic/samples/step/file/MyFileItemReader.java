package cn.chenzw.springboot.batch.basic.samples.step.file;

import cn.chenzw.springboot.batch.basic.samples.step.file.mapper.PersonFieldsetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

/**
 * 文件读操作
 *
 * @author chenzw
 */
public class MyFileItemReader extends FlatFileItemReader {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    public MyFileItemReader(Resource resource) {
        this.setResource(resource);
        this.setLinesToSkip(1);
        this.setSkippedLinesCallback(new LineCallbackHandler() {
            @Override
            public void handleLine(String line) {
                logger.info("skip:" + line);
            }
        });

        this.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(new DelimitedLineTokenizer("##") {
                    {
                        setNames(new String[]{"id", "name", "age"});
                    }
                });
                setFieldSetMapper(new PersonFieldsetMapper());
            }
        });
    }
}
