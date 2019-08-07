package com.vurtne.proproject.exceptions;

public interface ICustomException {
    String message = null;

    Integer errorCode = 0;

    String getMessage();

    Integer getErrorCode();

}
