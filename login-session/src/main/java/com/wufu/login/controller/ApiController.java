package com.wufu.login.controller;

import com.wufu.login.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author wufu
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/first")
    public String first(HttpSession session) {

        if (hasUser(session)) {
            return "请先登录";
        }
        return "first api";
    }

    @GetMapping("/second")
    public String second(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (hasUser(session)) {
            return "请先登录";
        }
        return "second api";
    }

    private boolean hasUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user == null;
    }

}
