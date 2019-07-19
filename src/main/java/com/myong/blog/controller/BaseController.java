package com.myong.blog.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class BaseController {
    private static final String TOKEN = "token";

    /**
     * 设置Cookie
     * @param response
     * @param token
     */
    protected void setUserCookie(HttpServletResponse response, String token) {
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookie = new Cookie(TOKEN, token);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

    /**
     * 获取Cookie
     * @param request
     * @return
     */
    protected String getUserCookie(HttpServletRequest request) {
        return getCookie(request);
    }

    private String getCookie(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
            Cookie[] cookies = request.getCookies();
            if (cookies!=null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(TOKEN)) {
                        return cookie.getValue();
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
