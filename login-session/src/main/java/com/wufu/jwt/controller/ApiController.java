package com.wufu.jwt.controller;

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
        return "first api";
    }

    @GetMapping("/second")
    public String second(HttpSession session) {
        return "second api";
    }

}
