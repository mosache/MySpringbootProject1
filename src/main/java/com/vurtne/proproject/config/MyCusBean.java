package com.vurtne.proproject.config;

import com.vurtne.proproject.utils.HttpUtil;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyCusBean {

    @Bean
    public RestTemplate httpClient(){
        RestTemplate httpClient = new RestTemplate();
        return httpClient;
    }

    @Bean
    public HttpUtil httpUtil(){
        return new HttpUtil();
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars","|{}[]");
            }
        });
        return factory;
    }
}
