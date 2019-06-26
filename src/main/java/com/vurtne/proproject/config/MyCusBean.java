package com.vurtne.proproject.config;

import com.vurtne.proproject.utils.HttpUtil;
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
}
