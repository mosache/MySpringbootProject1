package com.vurtne.proproject.controller;

import com.vurtne.proproject.provider.GithubProvider;
import com.vurtne.proproject.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/loginSuccess")
    public String loginSuccess(@RequestParam("code") String code, RedirectAttributes model, HttpServletRequest request){
        String token = githubProvider.getAccess_Token(code);
        UserInfo userInfo = githubProvider.getUserInfo(token);
        model.addFlashAttribute("user",userInfo);
        request.getSession().setAttribute("user",userInfo);
        return "redirect:/";
    }
}
