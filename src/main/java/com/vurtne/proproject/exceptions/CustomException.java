package com.vurtne.proproject.exceptions;

import com.alibaba.fastjson.annotation.JSONField;
import com.vurtne.proproject.enums.ErrorCode;

public class CustomException extends RuntimeException implements ICustomException {

    @JSONField
    private Integer errorCode;

    @JSONField
    private String messgae;

    public CustomException(Integer errorCode, String messgae) {
        this.errorCode = errorCode;
        this.messgae = messgae;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }


    @Override
    public String getMessage() {
        return messgae;
    }

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.messgae = errorCode.getMessage();
    }

    public static CustomException ofErrorCode(ErrorCode errorCode){
        CustomException exception = new CustomException(errorCode);
        return exception;
    }
}
