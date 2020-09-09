# FROM centos:7
FROM java:8
# FROM openjdk:8-jre-alpine
#RUN rpm -Uvh http://nginx.org/packages/centos/7/noarch/RPMS/nginx-release-centos-7-0.el7.ngx.noarch.rpm
#RUN yum -y install nginx

LABEL MAINTAINER="656469722@qq.com"

VOLUME /tmp2

# ENTRYPOINT nginx
COPY springboot-web-samples/target/springboot-web-samples-0.0.1-SNAPSHOT.jar app.jar

## RUN echo '<h1>Spring Cloud与Docker微服务实战</h1>' > /usr/share/nginx/html/index.html

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
