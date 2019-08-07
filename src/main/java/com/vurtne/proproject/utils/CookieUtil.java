package com.vurtne.proproject.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void addCookie(HttpServletResponse resp, String key, String value){
        Cookie cookie = new Cookie(key, value);
        resp.addCookie(cookie);
    }


    public static void removeCookie(HttpServletResponse resp, String key){
        Cookie cookie = new Cookie(key, null);
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

    public static String  getCookie(HttpServletRequest request, String key, String defaultValue){
        Cookie[] cookies = request.getCookies();

        if (cookies == null){
            return defaultValue;
        }

        for (Cookie c : cookies) {
            if (key.equals(c.getName())) {
                return c.getValue();
            }
        }

       return defaultValue;
    }

}
