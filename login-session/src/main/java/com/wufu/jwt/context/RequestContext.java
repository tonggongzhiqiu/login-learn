package com.wufu.jwt.context;

import com.wufu.jwt.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wufu
 */
public class RequestContext {
    /**
     * RequestContextHolder 可以在任意位置获取当前 request 请求
     * @return
     */
    public static HttpServletRequest getCurrentRequest() {
        return  ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
    }


    public static User getCurrentUser() {
        return (User) getCurrentRequest().getSession().getAttribute("user");
    }
}
