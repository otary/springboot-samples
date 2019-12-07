package cn.chenzw.springboot.batch.basic.samples.step.file;

import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.core.io.Resource;

import java.util.Map;

/**
 * JSON格式输出
 *
 * @author chenzw
 */
public class MyJsonFileItemWriter extends JsonFileItemWriter<Map<String, Object>> {

    public MyJsonFileItemWriter(Resource resource, JsonObjectMarshaller jsonObjectMarshaller) {
        super(resource, jsonObjectMarshaller);

        //setResource(resource);
        //setJsonObjectMarshaller(jsonObjectMarshaller);
        setEncoding("UTF-8");
        setName("tradeJsonFileItemWriter");
    }
}
