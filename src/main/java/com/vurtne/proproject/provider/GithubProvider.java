package com.vurtne.proproject.provider;

import com.vurtne.proproject.utils.HttpUtil;
import com.vurtne.proproject.vo.UserInfo;
import com.vurtne.proproject.vo.UserTokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class GithubProvider {

    @Autowired
    private HttpUtil httpUtil;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    public String getAccess_Token(String code){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("client_id",client_id);
        map.add("client_secret",client_secret);
        map.add("code",code);
        UserTokenBean token = httpUtil.post("https://github.com/login/oauth/access_token", map, UserTokenBean.class);
        return token.getAccess_token();
    }

    public UserInfo getUserInfo(String access_token){
        UserInfo userInfo = httpUtil.get("https://api.github.com/user?access_token="+access_token, UserInfo.class);
        return userInfo;

    }
}
