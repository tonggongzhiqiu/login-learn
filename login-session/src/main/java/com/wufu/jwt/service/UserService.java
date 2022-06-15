package com.wufu.jwt.service;

import com.wufu.jwt.context.RequestContext;
import com.wufu.jwt.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author wufu
 */
@Service
public class UserService {

    public void doSomething() {
        User user = RequestContext.getCurrentUser();
        System.out.println("[service] current user="+ user.getUserName());
    }
}
