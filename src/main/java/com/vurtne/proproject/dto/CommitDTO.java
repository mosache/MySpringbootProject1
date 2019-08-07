package com.vurtne.proproject.dto;

import com.vurtne.proproject.enums.CommitParentTypeEnum;
import lombok.Data;

/**
 * 评论
 * */
@Data
public class CommitDTO {
    private Integer parent_type;

    private Long parent_id;

    private String content;

    private CommitParentTypeEnum commitParentTypeEnum;


}

