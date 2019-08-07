package com.vurtne.proproject.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.vurtne.proproject.dto.CommitDTO;
import com.vurtne.proproject.dto.CommitListDTO;
import com.vurtne.proproject.dto.QuestionDTO;
import com.vurtne.proproject.dto.ResponseDTO;
import com.vurtne.proproject.enums.CommitParentTypeEnum;
import com.vurtne.proproject.enums.ErrorCode;
import com.vurtne.proproject.exceptions.CustomException;
import com.vurtne.proproject.mappers.CommitMapper;
import com.vurtne.proproject.mappers.QuestionMapper;
import com.vurtne.proproject.model.Commit;
import com.vurtne.proproject.model.Question;
import com.vurtne.proproject.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class CommitService {

    @Resource
    private CommitMapper commitMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Transactional
    public ResponseDTO addCommit(CommitDTO commitDTO, User user){
        if (commitDTO == null){
            throw CustomException.ofErrorCode(ErrorCode.COMMIT_ERROR_NEED_COMMIT_ERROR);
        }

        if (commitDTO.getParent_id() == null){
            throw CustomException.ofErrorCode(ErrorCode.COMMIT_ERROR_NEED_PARENT_ID_ERROR);
        }

        if (commitDTO.getCommitParentTypeEnum() == null) {
            throw CustomException.ofErrorCode(ErrorCode.COMMIT_ERROR_COMMIT_PARENT_TYPE_ERROR);
        }

        if (StringUtils.isEmpty(commitDTO.getContent())){
            throw CustomException.ofErrorCode(ErrorCode.COMMIT_ERROR_NEED_COMMIT_CONTENT);
        }

        if (commitDTO.getCommitParentTypeEnum() == CommitParentTypeEnum.COMMIT_PARENT_TYPE_QUESTION) {
            ///回复问题
            QuestionDTO question = questionMapper.getQuestionByID(commitDTO.getParent_id());
            if (question == null){
                throw CustomException.ofErrorCode(ErrorCode.COMMIT_ERROR_TARGET_QUESTION_NOT_FOUND);
            }


            Commit commit = new Commit();
            BeanUtils.copyProperties(commitDTO,commit);
            commit.setCreator_id(user.getId());
            commitMapper.insert(commit);

            question.setCommit_count(1);
            Question mQuestion = new Question();
            mQuestion.setId(question.getId());
            mQuestion.setCommit_count(1);
            questionMapper.addCommitCount(mQuestion);
        }else {
            ///回复评论
            Commit target = commitMapper.getById(commitDTO.getParent_id());
            if (target == null){
                throw CustomException.ofErrorCode(ErrorCode.COMMIT_ERROR_TARGET_COMMIT_NOT_FOUND);
            }
            Commit commit = new Commit();
            BeanUtils.copyProperties(commitDTO,commit);
            commit.setCreator_id(user.getId());
            commitMapper.insert(commit);
        }
        return ResponseDTO.resultOK(commitDTO);
    }

    public ArrayList<CommitListDTO> list(CommitDTO commitDTO){
        return commitMapper.list(commitDTO);
    }
}
