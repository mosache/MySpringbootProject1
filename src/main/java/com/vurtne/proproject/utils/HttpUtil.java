package com.vurtne.proproject.utils;

import com.vurtne.proproject.vo.UserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class HttpUtil {
    @Resource
    private RestTemplate httpClient;

    public <T> T post(String url, MultiValueMap<String ,String> params,Class<T> tClass){
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        List<MediaType> acceptTypes = new ArrayList<>();
        acceptTypes.add(MediaType.APPLICATION_JSON);
        header.setAccept(acceptTypes);
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(params,header);
        ResponseEntity<T> resp = httpClient.postForEntity(url, request, tClass);
        return resp.getBody();
    }

    public <T> T get(String url, Class<T> tClass){
        ResponseEntity<T> resp = httpClient.getForEntity(url,tClass);
        return resp.getBody();
    }
}
