package com.vurtne.proproject.exceptions;

/**
 * 请求的Question不存在
 * */
public class QuestionNotExistException extends RuntimeException{
    public QuestionNotExistException(String message) {
        super(message);
    }
}
