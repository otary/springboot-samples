# springboot-config-samples

- springboot-web01-samples
  - springboot-base01-samples
  - springboot-base02-samples
  
### 说明
- springboot-web01-samples中的application.properties优先被加载，而springboot-base01-samples、springboot-base02-samples的application.properties不会被加载
- springboot-web01-samples中的application.properties使用`spring.profiles.active=base01,base02,ext`，则会加载`application-base01.properties`、`application-base02.properties`、`application-ext.properties`，后面的同名属性将会覆盖前面的值

### 访问

http://localhost:8080/config
