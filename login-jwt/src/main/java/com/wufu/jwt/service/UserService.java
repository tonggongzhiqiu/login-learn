package com.wufu.jwt.service;

import com.wufu.jwt.context.UserContext;
import org.springframework.stereotype.Service;

/**
 * @author wufu
 */
@Service
public class UserService {

    public void doSomething() {
        String currentUserName = UserContext.getCurrentUserName();
        System.out.println("[service] current user="+ currentUserName);
    }
}
