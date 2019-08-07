package com.vurtne.proproject.enums;

/**
 * 错误码
 * */
public enum ErrorCode {
    QUESTION_NOT_FOUND(4001,"未找到请求的问题"),
    USER_NOT_LOGIN(4002,"用户未登录，请先登录"),
    TARGET_QUESTION_NOT_FOUND(4003,"回复的问题不存在"),
    TARGET_COMMIT_NOT_FOUND(4004,"回复的评论不存在"),

    COMMIT_ERROR_NEED_COMMIT_ERROR(4005,"please send commit json!"),
    COMMIT_ERROR_COMMIT_PARENT_TYPE_ERROR(4006,"评论父类型错误"),
    COMMIT_ERROR_NEED_PARENT_ID_ERROR(4007,"需要父类型ID"),
    COMMIT_ERROR_TARGET_QUESTION_NOT_FOUND(4008,"目标问题不存在"),
    COMMIT_ERROR_TARGET_COMMIT_NOT_FOUND(4009,"目标评论不存在"),
    COMMIT_ERROR_NEED_COMMIT_CONTENT(4010,"请输入评论内容"),
    ;

    private Integer errorCode;
    private String message;


    ErrorCode(Integer errorCode,String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
