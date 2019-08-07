package com.vurtne.proproject.controller;

import com.vurtne.proproject.mappers.UserMapper;
import com.vurtne.proproject.model.User;
import com.vurtne.proproject.provider.GithubProvider;
import com.vurtne.proproject.utils.CookieUtil;
import com.vurtne.proproject.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private GithubProvider githubProvider;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/loginSuccess")
    public String loginSuccess(@RequestParam("code") String code, HttpServletRequest request,HttpServletResponse response){
        String token = githubProvider.getAccess_Token(code);
        UserInfo userInfo = githubProvider.getUserInfo(token);
//        model.addFlashAttribute("user",userInfo);

        User user = userMapper.getUserByGitHubID(userInfo.getId());

        if (user == null) {
            User u = new User();
            u.setAvatar_url(userInfo.getAvatar_url());
            u.setName(userInfo.getName());
            u.setToken(token);
            u.setGithub_id(userInfo.getId());
            userMapper.insert(u);
        }else {
            userMapper.updateUserToken(user.getId(),token);
            user.setToken(token);
        }

        CookieUtil.addCookie(response,"token",token);

        request.getSession().setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/signOff")
    public String signOff(HttpServletRequest request,HttpServletResponse resp){
        User currentUser = (User) request.getSession().getAttribute("user");
        request.getSession().removeAttribute("user");
        CookieUtil.removeCookie(resp,"token");
        userMapper.updateUserToken(currentUser.getId(),"");

        return "redirect:/";
    }
}
