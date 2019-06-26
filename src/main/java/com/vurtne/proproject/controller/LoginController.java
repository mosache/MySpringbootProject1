package com.vurtne.proproject.controller;

import com.vurtne.proproject.utils.HttpUtil;
import com.vurtne.proproject.vo.UserInfo;
import com.vurtne.proproject.vo.UserTokenBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private HttpUtil httpUtil;

    @GetMapping("/loginSuccess")
    public String loginSuccess(@RequestParam("code") String code){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("client_id","ffbb683f5470d1be9669");
        map.add("client_secret","84ef0a64dff8649aea2a4dbcaea0b131f61e4a44");
        map.add("code",code);
        UserTokenBean bean = httpUtil.post("https://github.com/login/oauth/access_token",map,UserTokenBean.class);
        return "redirect:/getUserInfo?access_token="+bean.getAccess_token();
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam("access_token") String token, Model model){
        UserInfo userInfo = httpUtil.get("https://api.github.com/user/"+token,UserInfo.class);
        model.addAttribute("user",userInfo);
        return "index";
    }
}
