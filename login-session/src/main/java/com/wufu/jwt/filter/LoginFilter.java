package com.wufu.jwt.filter;

import com.wufu.jwt.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器
 * @author wufu
 */
@Component
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // /login 请求放行
        if ("/login".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return ;
        }

        // 用户不为空，放行
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(request, response);
            return ;
        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("[filter] 请先登录");
        out.flush();
        out.close();
    }
}
