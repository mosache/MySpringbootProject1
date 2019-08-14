package com.vurtne.proproject.mappers;

import com.vurtne.proproject.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionExtMapper {
    List<QuestionDTO> relativeQuestionByTag(QuestionDTO questionDTO);
}
