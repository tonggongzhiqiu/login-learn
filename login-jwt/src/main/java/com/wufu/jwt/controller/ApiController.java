package com.wufu.jwt.controller;

import com.wufu.jwt.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wufu
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private UserService userService;

    @GetMapping("/jwt1")
    public String api(HttpServletRequest request) {
        userService.doSomething();
        return "get info from jwt1";
    }

    @GetMapping("/jwt2")
    public String jwt2(HttpServletRequest request) {
        userService.doSomething();
        return "get info from jwt2";
    }

}
