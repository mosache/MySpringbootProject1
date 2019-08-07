package com.vurtne.proproject.controller;

import com.vurtne.proproject.dto.PaginationDTO;
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
import org.springframework.web.bind.annotation.*;

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
    public String index(HttpServletRequest request,Model model,
                        @RequestParam(value = "page",defaultValue = "1")Integer page,
                        @RequestParam(value = "size",defaultValue = "20")Integer size
                        ){

        String token = CookieUtil.getCookie(request, "token", null);

        User user = null;

        if (token != null){
            user = userMapper.getUserByToken(token);
            request.getSession().setAttribute("user",user);
        }

        if (user == null) {
            return "index";
        }

        PaginationDTO<QuestionDTO> pageDTO = questionService.getPage(page, size);

//        ArrayList<QuestionDTO> list = questionService.list(offSet,size);
//
        model.addAttribute("page",pageDTO);
//
        return "index";
    }
}
