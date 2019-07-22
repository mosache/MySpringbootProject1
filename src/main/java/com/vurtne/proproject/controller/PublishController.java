package com.vurtne.proproject.controller;

import com.vurtne.proproject.mappers.QuestionMapper;
import com.vurtne.proproject.model.Question;
import com.vurtne.proproject.model.User;
import com.vurtne.proproject.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Resource
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("des") String des,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        if (title == null || title.length() == 0) {
            model.addAttribute("error","标题不能为空");
            return "publish";
        }

        if (des == null || des.length() == 0) {
            model.addAttribute("error","描述不能为空");
            return "publish";
        }

        if (tag == null || tag.length() == 0) {
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        Question q = new Question();
        q.setTitle(title);
        q.setDes(des);
        q.setTag(tag);
        q.setCreator_id(user.getId());
        questionMapper.create(q);
        return "redirect:/";
    }
}
