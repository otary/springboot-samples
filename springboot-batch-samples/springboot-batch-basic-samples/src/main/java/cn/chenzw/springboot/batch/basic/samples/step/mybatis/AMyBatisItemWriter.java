package cn.chenzw.springboot.batch.basic.samples.step.mybatis;

import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.core.io.Resource;

public class AMyBatisItemWriter extends JsonFileItemWriter {

    public AMyBatisItemWriter(Resource resource, JsonObjectMarshaller jsonObjectMarshaller) {
        super(resource, jsonObjectMarshaller);

        setResource(resource);
        setJsonObjectMarshaller(jsonObjectMarshaller);
        setEncoding("UTF-8");
        setName("tradeJsonFileItemWriter");
    }
}
