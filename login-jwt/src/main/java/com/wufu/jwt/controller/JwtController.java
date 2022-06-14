package com.wufu.jwt.controller;

import com.wufu.jwt.entity.User;
import com.wufu.jwt.util.JwtUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wufu
 */
@RestController
public class JwtController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if ("admin".equals(user.getUserName()) &&
                "admin".equals(user.getPassword())) {
            // 如果正确，返回生成的 token
            return JwtUtil.generate(user.getUserName());
        }
        return "账号密码错误";
    }
}
