package com.vurtne.proproject.model;

import lombok.Data;

import java.util.Date;

@Data
public class Question {

    private Long id;

    private String title;

    private String des;

    private String tag;

    private Date add_time;

    private Date modify_time;

    private Long creator_id;

    private int view_count;

    private int commit_count;

    private int like_count;
}
