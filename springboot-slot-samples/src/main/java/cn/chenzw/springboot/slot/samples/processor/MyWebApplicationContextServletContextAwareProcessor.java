package cn.chenzw.springboot.slot.samples.processor;

import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;
import org.springframework.web.context.ConfigurableWebApplicationContext;

public class MyWebApplicationContextServletContextAwareProcessor extends WebApplicationContextServletContextAwareProcessor {
    public MyWebApplicationContextServletContextAwareProcessor(ConfigurableWebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }
}
