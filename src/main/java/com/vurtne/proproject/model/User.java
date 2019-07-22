package com.vurtne.proproject.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String avatar_url;
    private String name;
    private String token;
}
