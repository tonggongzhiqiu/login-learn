package com.wufu.jwt.controller;

import com.wufu.jwt.util.JwtUtil;
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
        if (check(request)) {
            return "请先登录";
        }

        return "get info from jwt1";
    }

    @GetMapping("/jwt2")
    public String jwt2(HttpServletRequest request) {
        if (check(request)) {
            return "请先登录";
        }

        return "get info from jwt2";
    }

    private boolean check(HttpServletRequest request) {
        return JwtUtil.parse(request.getHeader("Authorization")) == null;
    }
}
