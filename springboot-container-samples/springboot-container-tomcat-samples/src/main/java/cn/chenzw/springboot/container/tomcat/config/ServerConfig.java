package cn.chenzw.springboot.container.tomcat.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {

 /*   @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(Connector connector) {

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector);
        tomcat.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));

        return tomcat;
    }

    @Bean
    public Connector connector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(443);
        return connector;
    }*/


}
