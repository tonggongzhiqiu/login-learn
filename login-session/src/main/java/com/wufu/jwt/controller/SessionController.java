package com.wufu.jwt.controller;

import com.wufu.jwt.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author wufu
 */
@RestController
public class SessionController {

    /**
     * postman 测试时必须在 body-raw 部分设置数据类型为 json
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        if ("admin".equals(user.getUserName())
                && "admin".equals(user.getPassword())) {
            // session 意味着一个浏览器和服务器之间的通话，使用固定的 key 应该是可以的
            session.setAttribute("user", user);
            return "登录成功";
        }
        return "登录失败";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "登出成功";
    }
}
