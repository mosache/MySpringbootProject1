package com.vurtne.proproject.controller;

import com.vurtne.proproject.dto.CommitDTO;
import com.vurtne.proproject.dto.CommitListDTO;
import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.service.CommitService;
import com.vurtne.proproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommitService commitService;

    @GetMapping("/question/{id}")
    public String detail(@PathVariable("id")Long id, Model model){
        questionService.addViewCount(id,1);
        QuestionDTO question = questionService.getQuestionByID(id);

        ArrayList<QuestionDTO> relativedQuestions = (ArrayList<QuestionDTO>) questionService.getRelativedQuestions(question);

        CommitDTO commitDTO = new CommitDTO();
        commitDTO.setParent_type(1);
        commitDTO.setParent_id(question.getId());
        ArrayList<CommitListDTO> commitList = commitService.list(commitDTO);

        model.addAttribute("question",question);
        model.addAttribute("commits",commitList);
        model.addAttribute("relativeQuestions",relativedQuestions);

        return "question";
    }
}
