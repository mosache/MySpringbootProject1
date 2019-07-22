package com.vurtne.proproject.dto;

import com.vurtne.proproject.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class QuestionDTO {
    private int id;

    private String title;

    private String des;

    private String tag;

    private Date add_time;

    private Date modify_time;

    private int creator_id;

    private int view_count;

    private int commit_count;

    private int like_count;

    private User user;
}
