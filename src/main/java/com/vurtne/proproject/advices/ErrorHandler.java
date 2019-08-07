package com.vurtne.proproject.advices;
import com.alibaba.fastjson.JSON;
import com.vurtne.proproject.dto.ResponseDTO;
import com.vurtne.proproject.exceptions.CustomException;
import com.vurtne.proproject.exceptions.ICustomException;
import com.vurtne.proproject.exceptions.QuestionNotExistException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView errorHandler(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response){

        String contentType = request.getContentType();

        if ("application/json".equals(contentType)){

            try {
                ///setContentType要在getWrite之前调用
                CustomException exception = null;
                if (ex instanceof CustomException){
                    exception = (CustomException)ex;
                }else {
                    exception = new CustomException(500,ex.getLocalizedMessage());
                }
                ResponseDTO result = ResponseDTO.ofError(exception);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=UTF-8");
//                response.setHeader("contentType","application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                String json = JSON.toJSONString(result);
                writer.write(json);
                response.setStatus(400);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else {
            model.addAttribute("message",ex.getMessage());
            ModelAndView mv = new ModelAndView("error");
            return mv;
        }



    }
}
