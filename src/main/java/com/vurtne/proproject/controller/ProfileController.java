package com.vurtne.proproject.controller;

import com.vurtne.proproject.dto.PaginationDTO;
import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.model.User;
import com.vurtne.proproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model, HttpServletRequest request){

        if ("questions".equals(action)){
            model.addAttribute("action",action);
            model.addAttribute("actionName","我的提问");
        }

        User user = (User) request.getSession().getAttribute("user");

        PaginationDTO<QuestionDTO> page = questionService.getPage(user.getId(), 1, 2);

        model.addAttribute("page",page);

        return "profile";

    }
}
