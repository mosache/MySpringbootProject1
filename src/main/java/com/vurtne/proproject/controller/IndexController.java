package com.vurtne.proproject.controller;

import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.mappers.QuestionMapper;
import com.vurtne.proproject.mappers.UserMapper;
import com.vurtne.proproject.model.Question;
import com.vurtne.proproject.model.User;
import com.vurtne.proproject.service.QuestionService;
import com.vurtne.proproject.utils.CookieUtil;
import com.vurtne.proproject.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private QuestionService questionService;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request,Model model){

        String token = CookieUtil.getCookie(request, "token", null);

        if (token == null) {
            return "index";
        }

        User user = userMapper.getUserByToken(token);

        if (user != null) {
            request.getSession().setAttribute("user",user);
        }

        ArrayList<QuestionDTO> list = questionService.list();

        model.addAttribute("list",list);

        return "index";
    }
}
