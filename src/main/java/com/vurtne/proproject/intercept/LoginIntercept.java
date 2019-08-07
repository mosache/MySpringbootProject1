package com.vurtne.proproject.intercept;

import com.vurtne.proproject.model.User;
import com.vurtne.proproject.utils.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查是否登录
 * */
public class LoginIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User currentUser = (User) request.getSession().getAttribute("user");

        if (currentUser == null){
            response.sendRedirect("/");
            return false;
        }

        String token = CookieUtil.getCookie(request, "token", null);

        if (token == null){
            response.sendRedirect("/");
            return false;
        }

        if (!token.equals(currentUser.getToken())) {
            response.sendRedirect("/");
            return false;
        }

        return true;
    }
}
