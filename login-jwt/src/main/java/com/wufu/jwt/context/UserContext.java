package com.wufu.jwt.context;

/**
 * 自定义上下文，记录 jwt 解析的数据
 * 使用 ThreadLocal 记录，防止线程冲突
 * @author wufu
 */
public final class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<>();

    public static void add(String userName) {
        user.set(userName);
    }

    public static void remove() {
        user.remove();
    }

    public static String getCurrentUserName() {
        return user.get();
    }
}
