package com.vurtne.proproject.service;

import com.vurtne.proproject.dto.PaginationDTO;
import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.exceptions.QuestionNotExistException;
import com.vurtne.proproject.mappers.QuestionExtMapper;
import com.vurtne.proproject.mappers.QuestionMapper;
import com.vurtne.proproject.model.Question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionExtMapper questionExtMapper;

    public ArrayList<QuestionDTO> list(int offSet,int size){
        return questionMapper.list(offSet,size);
    }

    public PaginationDTO<QuestionDTO> getPage(int page,int size) {
        int totalCount = questionMapper.getTotalCount();
        PaginationDTO<QuestionDTO> pageDTO = new PaginationDTO<>();
        pageDTO.setPagination(totalCount,page,size);
        pageDTO.setData(questionMapper.list(pageDTO.getOffSet(),size));
        return pageDTO;
    }

    public PaginationDTO<QuestionDTO> getPage(Long user_id,int page,int size) {
        int totalCount = questionMapper.getTotalCountByUserID(user_id);
        PaginationDTO<QuestionDTO> pageDTO = new PaginationDTO<>();
        pageDTO.setPagination(totalCount,page,size);
        pageDTO.setData(questionMapper.listByUserID(user_id,pageDTO.getOffSet(),size));
        return pageDTO;
    }

    public QuestionDTO getQuestionByID(Long id){
        QuestionDTO question = questionMapper.getQuestionByID(id);
        if (question == null){
            throw new QuestionNotExistException("请求的问题不存在！");
        }
        return question;
    }

    public void createOrUpdate(Question q) {
        if (q.getId() > 0 ) {
            questionMapper.updateQuestion(q);
        }else {
            questionMapper.create(q);
        }
    }

    public void addViewCount(Long id,int incCount){
        Question q = new Question();
        q.setId(id);
        q.setView_count(incCount);
        questionMapper.addViewCount(q);
    }

    public List<QuestionDTO> getRelativedQuestions(QuestionDTO question) {
        String[] tags = question.getTag().split(",");
        String tagExps = Arrays.stream(tags).collect(Collectors.joining("|"));
        QuestionDTO example = new QuestionDTO();
        example.setTag(tagExps);
        example.setId(question.getId());
        List<QuestionDTO> questionDTOS = questionExtMapper.relativeQuestionByTag(example);
        return questionDTOS;

    }
}
