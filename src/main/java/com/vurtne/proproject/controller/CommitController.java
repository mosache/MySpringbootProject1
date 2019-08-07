package com.vurtne.proproject.controller;

import com.vurtne.proproject.dto.CommitDTO;
import com.vurtne.proproject.dto.ResponseDTO;
import com.vurtne.proproject.enums.ErrorCode;
import com.vurtne.proproject.exceptions.CustomException;
import com.vurtne.proproject.model.User;
import com.vurtne.proproject.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论
 * */
@Controller
public class CommitController {

    @Autowired
    private CommitService commitService;

    @PostMapping("/commit")
    @ResponseBody
    public ResponseDTO commit(@RequestBody CommitDTO commitDTO, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return commitService.addCommit(commitDTO,user);
    }

}
