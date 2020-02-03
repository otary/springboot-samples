# springboot-samples

![springboot](https://img.shields.io/badge/springboot-2.1.5.RELEASE-brightgreen.svg)
![JDK](https://img.shields.io/badge/Java-7-brightgreen.svg)


## 模块
- [springboot-helloworld-samples](./springboot-helloworld-samples): helloworld示例
- [springboot-banner-samples](./springboot-banner-samples): banner、favorite示例
- [springboot-cache-samples](./springboot-cache-samples): 集成缓存示例
  - [springboot-ehcache-samples](./springboot-cache-samples/springboot-ehcache-samples): 集成ehcache缓存示例
  - [springboot-redis-cache-samples](./springboot-cache-samples/springboot-redis-cache-samples)：集成redis缓存示例

- [spring-boot-starter](./spring-boot-starter): spring-boot-starter制作示例

- [springboot-config-samples](./springboot-config-samples)：spring配置加载优先级示例
  - [springboot-base01-samples](./springboot-config-samples/springboot-base01-samples)：子模块01配置
  - [springboot-base02-samples](./springboot-config-samples/springboot-base02-samples): 子模块02配置
  - [springboot-web02-samples](./springboot-config-samples/springboot-web01-samples)：父模块配置

- [springboot-aop-samples](./springboot-aop-samples):集成AOP示例
- [springboot-swagger-samples](./springboot-swagger-samples):集成swagger2示例
  - [springboot-swagger2-basic-samples](./springboot-swagger-samples/springboot-swagger2-basic-samples): swagger-ui示例
    - 集成basic身份认证
  - [springboot-swagger2-bootstrap-ui-samples](./springboot-swagger-samples/springboot-swagger2-bootstrap-ui-samples): bootstrap-ui示例
- [springboot-async-samples](./springboot-async-samples): 异步请求示例
- [springboot-admin-samples](./springboot-admin-samples): SpringBoot Admin示例
- [springboot-mail-samples](./springboot-mail-samples)：mail操作示例
- [springboot-message-samples](./springboot-message-samples)：异步消息通讯示例
  - [springboot-activemq-samples](./springboot-message-samples/springboot-activemq-samples)：集成ActiveMQ示例

- [springboot-filters-samples](./springboot-filters-samples)：常用过滤器示例
- [springboot-profiles-samples](./springboot-profiles-samples): Profile、Condition示例
  - [springboot-profile-samples](./springboot-profiles-samples/springboot-profile-samples)：Profile示例
  - [springboot-condition-samples](./springboot-profiles-samples/springboot-condition-samples)；Condition示例
- [springboot-validation-samples](./springboot-validation-samples)：参数校验示例
- [springboot-websocket-samples](./springboot-websocket-samples)：集成websocket示例

- [springboot-session-samples](./springboot-session-samples): spring-session示例
  - [spring-session-redis-samples](./springboot-session-samples/springboot-session-redis-samples): session同步redis示例

- [springboot-jmx-samples](./springboot-jmx-samples): JMX示例

- [springboot-log-samples](./springboot-log-samples): 日志示例
  - [spring-logback-samples](./springboot-log-samples/springboot-logback-samples): logback集成示例

- [springboot-test-samples](./springboot-test-samples): 单元测试

- [spirngboot-web-samples](./springboot-web-samples): WebMvc示例
- [springboot-webflux-samples](./springboot-webflux-samples): WebFlux示例

**批处理**
- [springboot-batch-samples](./springboot-batch-samples): 批处理示例

**定时处理**
- [springboot-task-samples](./springboot-task-samples): 定时任务示例
  - [springboot-scheduler-samples](./springboot-task-samples/springboot-scheduler-samples)：scheduler示例

**持久层**
- [springboot-mybatis-samples](./springboot-mybatis-samples): 集成mybatis示例
  - [springboot-mybatis-xml-samples](./springboot-mybatis-samples/springboot-mybatis-xml-samples): mybatis xml配置方式集成示例
  - [springboot-mybatis-annotation-samples](./springboot-mybatis-samples/springboot-mybatis-annotation-samples): mybatis 注解配置方式集成示例
  - [springboot-tkmybatis-samples](./springboot-mybatis-samples/springboot-tkmybatis-samples): 集成tkmybatis示例
  - [springboot-mybaits-plugin-samples](./springboot-mybatis-samples/springboot-mybtias-plugin-samples): 自定义Mybatis插件示例
- [springboot-datasources-samples](./springboot-datasources-samples)：数据源相关示例
  - [springboot-datasources-h2-samples](./springboot-datasources-samples/springboot-datasources-h2-samples)：集成H2数据库示例
  - [springboot-datasources-multiple-samples](./springboot-datasources-samples/springboot-datasources-multiple-samples)：多数据源示例
    - [springboot-datasources-multiple-annotation-samples](./springboot-datasources-samples/springboot-datasources-multiple-samples/springboot-datasources-multiple-annotation-samples):基于自定义注解的多数据源示例
  - [springboot-datasources-mysql-samples](./springboot-datasources-samples/springboot-datasources-mysql-samples)：集成mysql示例
- [springboot-druid-samples](./springboot-druid-samples)：集成Druid相关示例
  - [springboot-druid-config-samples](./springboot-druid-samples/springboot-druid-config-samples)：纯代码配置方式
  - [springboot-druid-props-samples](./springboot-druid-samples/springboot-druid-props-samples): application.properties配置方式
- [springboot-jpa-samples](./springboot-jpa-samples)：集成JPA示例
  - [springboot-jpa-basic-samples](./springboot-jpa-samples/springboot-jpa-basic-samples)：集成JAP示例(基础)
- [springboot-redis-samples](./springboot-redis-samples)：集成redis示例

**视图层**
- [springboot-views-samples](./springboot-views-samples)：视图模版示例
  - [springboot-views-jsp-samples](./springboot-views-samples/springboot-views-jsp-samples)：集成JSP示例
  - [springboot-thymeleaf-samples](./springboot-views-samples/springboot-thymeleaf-samples)：集成thymeleaf示例

**安全认证**
- [springboot-security-samples](./springboot-security-samples)：集成spring security示例
  - [springboot-security-basic-samples](./springboot-security-samples/springboot-security-basic-samples)：spring security基础示例
  - [springboot-security-jwt-samples](./springboot-security-samples/springboot-security-jwt-samples)：
  - [springboot-security-oauth2-samples](./springboot-security-samples/springboot-security-oauth2-samples):
- [springboot-shiro-samples](./springboot-shiro-samples)：集成shiro示例
  - [springboot-shiro-config-samples](./springboot-shiro-samples/springboot-shiro-config-samples)：纯代码配置的shiro示例

**容器**
- [springboot-container-samples](./springboot-container-samples)：集成容器示例
  - [springboot-container-jetty-samples](./springboot-container-samples/springboot-container-jetty-samples)：集成jetty容器示例
  - [springboot-container-tomcat-samples](./springboot-container-samples/springboot-container-tomcat-samples)：集成tomcat容器示例


## 问题解决

- 文件名超长clone报错
```
unable to create file springboot-datasources-samples/springboot-datasources-multiple-samples/springboot-datasources-multiple-annotation-samples/src/main/java/cn/chenzw/springboot/datasources/multiple/annotation/MultipleDatasourceAnnotationSamplesApp.java: Filename too long unable to create file springboot-datasources-samples/springboot-datasources-multiple-samples/springboot-datasources-multiple-annotation-samples/src/main/java/cn/chenzw/springboot/datasources/multiple/annotation/aop/DataSourceAspect.java: Filename too long unable to create file springboot-datasources-samples/springboot-datasources-multiple-samples/springboot-datasources-multiple-annotation-samples/src/main/java/cn/chenzw/springboot/datasources/multiple/annotation/config/DruidConfig.java: Filename too long unable to create file springboot-datasources-samples/springboot-datasources-multiple-samples/springboot-datasources-multiple-annotation-samples/src/main/java/cn/chenzw/springboot/datasources/multiple/annotation/config/TkMybatisConfig.java: Filename too long cannot create directory at 'springboot-datasources-samples/springboot-datasources-multiple-samples/springboot-datasources-multiple-annotation-samples/src/main/java/cn/chenzw/springboot/datasources/multiple/annotation/domain/entity': Filename too long warning: Clone succeeded, but checkout failed. You can inspect what was checked out with 'git status' and retry the checkout with 'git checkout -f HEAD' 
```

> 解决方法

```
git config --system core.longpaths true
```


