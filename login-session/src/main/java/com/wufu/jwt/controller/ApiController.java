package com.wufu.jwt.controller;

import com.wufu.jwt.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wufu
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private UserService userService;

    @GetMapping("/first")
    public String first(HttpSession session) {
        userService.doSomething();
        return "first api";
    }

    @GetMapping("/second")
    public String second(HttpSession session) {
        return "second api";
    }

}
