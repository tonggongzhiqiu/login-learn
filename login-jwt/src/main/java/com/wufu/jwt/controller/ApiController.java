package com.wufu.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wufu
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/jwt1")
    public String api(HttpServletRequest request) {

        return "get info from jwt1";
    }

    @GetMapping("/jwt2")
    public String jwt2(HttpServletRequest request) {

        return "get info from jwt2";
    }

}
