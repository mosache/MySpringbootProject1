package com.vurtne.proproject.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String avatar_url;
    private String name;
    private String token;
    private Integer github_id;
}
