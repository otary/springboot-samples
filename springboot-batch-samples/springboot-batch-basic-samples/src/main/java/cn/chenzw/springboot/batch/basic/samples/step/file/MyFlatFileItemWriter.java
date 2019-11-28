package cn.chenzw.springboot.batch.basic.samples.step.file;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Writer;


/**
 * 二维文本格式输出
 *
 * @author chenzw
 */
public class MyFlatFileItemWriter extends FlatFileItemWriter<Person> {

    public MyFlatFileItemWriter(Resource resource) {
        this.setAppendAllowed(true);
        // this.setShouldDeleteIfExists(true);
        this.setEncoding("UTF-8");
        this.setResource(resource);
        this.setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("20\n");
                writer.write("id##name##age##nation");
            }
        });
        this.setLineAggregator(new DelimitedLineAggregator<Person>() {{
            setDelimiter("##");
            setFieldExtractor(new BeanWrapperFieldExtractor<Person>() {{
                setNames(new String[]{"id", "name", "age", "nation"});
            }});
        }});
    }

}
