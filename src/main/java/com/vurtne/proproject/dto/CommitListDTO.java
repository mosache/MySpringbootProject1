package com.vurtne.proproject.dto;

import com.vurtne.proproject.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class CommitListDTO {

    private Long id;

    private Long parent_id;

    private Date add_time;

    private Date modify_time;

    private String content;

    private Integer parent_type;

    private User user;

}
