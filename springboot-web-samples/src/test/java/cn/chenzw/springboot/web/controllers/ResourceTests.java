package cn.chenzw.springboot.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.io.IOException;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceTests {

    @Autowired
    List<HttpRequestHandler> httpRequestHandlers;

    @Test
    public void testPropertySourceLoader() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application-dev.yml");

        log.info("classPathResource.getDescription() => {}", classPathResource.getDescription()); // => class path resource [application-dev.yml]
        log.info("classPathResource.getFilename() => {}", classPathResource.getFilename());  // => application-dev.yml
        log.info("classPathResource.getFile() => {}", classPathResource.getFile());  // => C:\Users\chenzw\IdeaProjects\springboot-samples\springboot-web-samples\target\classes\application-dev.yml
        log.info("classPathResource.getPath() => {}", classPathResource.getPath());  // => application-dev.yml
        log.info("classPathResource.getURL() => {}", classPathResource.getURL());  // => file:/C:/Users/chenzw/IdeaProjects/springboot-samples/springboot-web-samples/target/classes/application-dev.yml
        log.info("classPathResource.getURI() => {}", classPathResource.getURI());  // => file:/C:/Users/chenzw/IdeaProjects/springboot-samples/springboot-web-samples/target/classes/application-dev.yml

        // 加载application-dev.yml配置文件
        YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
        List<PropertySource<?>> devPropertySources = yamlPropertySourceLoader.load("dev", classPathResource);

        for (PropertySource<?> propertySource : devPropertySources) {
            log.info("logging.level.web => {}", propertySource.getProperty("logging.level.web"));
            log.info("是否包含logging.level.web => {}", propertySource.containsProperty("logging.level.web"));
        }


        // 加载application.properties文件
        ClassPathResource classPathResource2 = new ClassPathResource("application.properties");
        PropertiesPropertySourceLoader propertiesPropertySourceLoader = new PropertiesPropertySourceLoader();
        List<PropertySource<?>> defaultPropertySource = propertiesPropertySourceLoader.load("default", classPathResource2);

        for (PropertySource<?> propertySource : defaultPropertySource) {
            log.info("spring.servlet.multipart.max-request-size => {}", propertySource.getProperty("spring.servlet.multipart.max-request-size"));
            log.info("是否包含spring.servlet.multipart.max-request-size => {}", propertySource.containsProperty("spring.servlet.multipart.max-request-size"));
        }
    }


    @Test
    public void testGetAllHttpRequestHandler() {

        for (HttpRequestHandler httpRequestHandler : httpRequestHandlers) {
            log.info("获取HttpRequestHandler => {}", httpRequestHandler);

            if (httpRequestHandler instanceof ResourceHttpRequestHandler) {
                ResourceHttpRequestHandler resourceHttpRequestHandler = (ResourceHttpRequestHandler) httpRequestHandler;

                log.info("resourceHttpRequestHandler.getLocations() => 共[{}]条: {}", resourceHttpRequestHandler.getLocations().size(),
                        resourceHttpRequestHandler.getLocations());  // =>  [class path resource [META-INF/resources/], class path resource [resources/], class path resource [static/], class path resource [public/], ServletContext resource [/], class path resource []]
                log.info("resourceHttpRequestHandler.getResourceResolvers() => {}", resourceHttpRequestHandler.getResourceResolvers());  // => org.springframework.web.servlet.resource.PathResourceResolver
                log.info("resourceHttpRequestHandler.getResourceHttpMessageConverter => {}", resourceHttpRequestHandler.getResourceHttpMessageConverter());  // => org.springframework.http.converter.ResourceHttpMessageConverter
                log.info("resourceHttpRequestHandler.getResourceTransformers => {}", resourceHttpRequestHandler.getResourceTransformers());  // => []
            }

        }
    }


}
