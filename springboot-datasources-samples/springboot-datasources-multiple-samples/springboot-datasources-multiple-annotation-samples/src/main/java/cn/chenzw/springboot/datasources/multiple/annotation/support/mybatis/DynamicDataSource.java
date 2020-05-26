package cn.chenzw.springboot.datasources.multiple.annotation.support.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * @author chenzw
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("Use DataSource [{}]", DataSourceHolder.get());
        return DataSourceHolder.get();
    }
}
