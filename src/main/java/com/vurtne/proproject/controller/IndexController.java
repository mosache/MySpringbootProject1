package com.vurtne.proproject.controller;

import com.vurtne.proproject.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@ModelAttribute("user") UserInfo userInfo){
        return "index";
    }
}
