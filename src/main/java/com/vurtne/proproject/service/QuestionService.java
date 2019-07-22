package com.vurtne.proproject.service;

import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.mappers.QuestionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    public ArrayList<QuestionDTO> list(){
        return (ArrayList<QuestionDTO>) questionMapper.list();
    }
}
