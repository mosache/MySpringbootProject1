package com.vurtne.proproject.vo;

import lombok.Data;

@Data
public class UserTokenBean {
    private String access_token;

    private String token_type;

    private String scope;


}
