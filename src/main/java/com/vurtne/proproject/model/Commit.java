package com.vurtne.proproject.model;

import lombok.Data;

import java.util.Date;

@Data
public class Commit {
    private Long id;

    private Long parent_id;

    private Date add_time;

    private Date modify_time;

    private String content;

    private Integer parent_type;

    private Long creator_id;
}
