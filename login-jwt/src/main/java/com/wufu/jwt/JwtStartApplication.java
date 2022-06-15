package com.wufu.jwt;

import com.wufu.jwt.intercepter.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wufu
 */
@SpringBootApplication
public class JwtStartApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(JwtStartApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }
}
