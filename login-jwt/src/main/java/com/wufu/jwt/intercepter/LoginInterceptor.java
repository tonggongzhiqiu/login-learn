package com.wufu.jwt.intercepter;

import com.wufu.jwt.context.UserContext;
import com.wufu.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author wufu
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("/login".equals(request.getRequestURI())) {
           return true;
        }

        Claims claims = JwtUtil.parse(request.getHeader("Authorization"));
        if (claims != null) {
            // 存储到 上下文 UserContext 中
            UserContext.add(claims.getSubject());
            return true;
        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("[interceptor]请先登录");
        out.flush();
        out.close();
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
    }
}
