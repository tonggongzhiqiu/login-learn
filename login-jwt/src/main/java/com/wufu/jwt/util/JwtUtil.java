package com.wufu.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;

public class JwtUtil {

    /**
     * JWT 校验的密钥，很重要，不能泄露
     */
    private final static String secretKey = "whatever";
    /**
     * 过期时间
     */
    private final static Duration expiration = Duration.ofHours(2);

    /**
     * 生成 token
     * @param userName
     * @return
     */
    public static String generate(String userName) {
        // 过期时间
        Date expiryDate = new Date(System.currentTimeMillis() + expiration.toMillis());

        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    /**
     * 校验 token
     * @param token
     * @return
     */
    public static Claims parse(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    // 设置秘钥
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            System.out.println("解析失败");
        }
        return claims;
    }
}
