package cn.chenzw.springboot.validation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cn.chenzw.springboot.validation"})
public class WebConfig {

     /*   @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure()
                .addProperty("hibernate.validator.fail_fast", "true").buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }*/
}
