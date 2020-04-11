package com.exam.exam_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author :
 * @ClassName : LoginController
 * @Description :
 * @Date : 2020/3/27 15:07
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/login")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request, SessionStatus sessionStatus, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        sessionStatus.setComplete();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/login";
    }
}
