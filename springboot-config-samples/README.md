# springboot-config-samples

- [springboot-web01-samples](springboot-web01-samples)
  - [springboot-base01-samples](springboot-base01-samples)
  - [springboot-base02-samples](springboot-base02-samples)
  
- [springboot-configproperties-samples](springboot-configproperties-samples): properties文件属性注入
  - 注入普通字段
  - 注入静态字段
  
### 说明
- springboot-web01-samples中的application.yml优先被加载，而springboot-base01-samples、springboot-base02-samples的application.yml不会被加载
- springboot-web01-samples中的application.yml使用`spring.profiles.active=base01,base02,ext`，则加载顺序 `config/application-ext.yml` => `application-base01.yml` => `application-base02.yml`，后面的同名属性将会覆盖前面的值
  - 注意： config目录下的配置会被优先加载
- 如果同时使用 `spring.profiles.active` 和 `spring.profiles.include`，则 `spring.profiles.include` 会优先加载

``` yaml
spring:
  profiles:
    active: base01, base02, ext
    include: web
    
// 加载顺序：web => ext => base01 => base02（后面的配置覆盖前面的）    
```


### 访问

http://localhost:8080/config
