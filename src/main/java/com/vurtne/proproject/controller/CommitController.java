package com.vurtne.proproject.controller;

import com.vurtne.proproject.dto.CommitDTO;
import com.vurtne.proproject.dto.ResponseDTO;
import com.vurtne.proproject.enums.CommitParentTypeEnum;
import com.vurtne.proproject.enums.ErrorCode;
import com.vurtne.proproject.exceptions.CustomException;
import com.vurtne.proproject.model.User;
import com.vurtne.proproject.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/commit/{id}")
    @ResponseBody
    public ResponseDTO comments(@PathVariable("id")Long id, HttpServletRequest request){
        CommitDTO commitDTO = new CommitDTO();
        commitDTO.setCommitParentTypeEnum(CommitParentTypeEnum.COMMIT_PARENT_TYPE_COMMIT);
        commitDTO.setParent_id(id);
        commitDTO.setParent_type(2);
        return ResponseDTO.resultOK(commitService.list(commitDTO));
    }
}
