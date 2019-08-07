package com.vurtne.proproject.dto;

import com.vurtne.proproject.exceptions.CustomException;
import lombok.Data;

/**
 * response
 * */
@Data
public class ResponseDTO<T> {

    private Integer statusCode;

    private String message;

    private T data;

    public ResponseDTO(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public static ResponseDTO ofError(CustomException ex){
        ResponseDTO result = new ResponseDTO(ex.getErrorCode(), ex.getMessage());
        return result;
    }

    public static <T> ResponseDTO resultOK(T data){
        ResponseDTO<T> result = new ResponseDTO<>(200, "");
        result.data = data;
        return result;
    }

}
