package cn.chenzw.springboot.batch.basic.samples;

import cn.chenzw.springboot.batch.basic.samples.domain.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileBatchTests {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job fileProcessJob;

    @Test
    public void test() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParameters();
        JobExecution jobExecution = jobLauncher.run(fileProcessJob, jobParameters);

        System.out.println("jobExecution:" + jobExecution);
    }

    @Test
    public void testFlatFileItemWriter() throws Exception {
        FlatFileItemWriter<Person> flatFileItemWriter = new FlatFileItemWriter();

        flatFileItemWriter.setAppendAllowed(true);
        // flatFileItemWriter.setShouldDeleteIfExists(true);
        flatFileItemWriter.setEncoding("UTF-8");
        flatFileItemWriter.setResource(new FileSystemResource(new File("file-outbound/flat.txt")));
        flatFileItemWriter.setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("20\n");
                writer.write("id##name##age##nation");
            }
        });
        flatFileItemWriter.setLineAggregator(new DelimitedLineAggregator<Person>() {{
            setDelimiter("##");
            setFieldExtractor(new BeanWrapperFieldExtractor<Person>() {{
                setNames(new String[]{"id", "name", "age", "nation"});
            }});
        }});

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setId(Long.valueOf(i));
            p.setName("張三" + i);
            p.setAge(i);
            persons.add(p);
        }
        flatFileItemWriter.open(new ExecutionContext());
        flatFileItemWriter.write(persons);
    }

    @Test
    public void testJsonFileWriter() throws Exception {
        FileSystemResource fileSystemResource = new FileSystemResource(new File("file-outbound/data.json"));
        JsonFileItemWriter<Object> jsonFileItemWriter = new JsonFileItemWriter<>(fileSystemResource, new JacksonJsonObjectMarshaller());
        jsonFileItemWriter.setEncoding("UTF-8");
        jsonFileItemWriter.setName("tradeJsonFileItemWriter");
        jsonFileItemWriter.setAppendAllowed(true);

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setId(Long.valueOf(i));
            p.setName("張三" + i);
            p.setAge(i);
            persons.add(p);
        }
        jsonFileItemWriter.open(new ExecutionContext());
        jsonFileItemWriter.write(persons);
        jsonFileItemWriter.close();
    }
}
