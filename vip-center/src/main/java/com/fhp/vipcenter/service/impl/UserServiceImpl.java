package com.fhp.vipcenter.service.impl;

import com.fhp.vipcenter.service.UserService;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Override
    public String sayHelloToUser(int id) {
        return "hystrix 熔断处理 " + id;
    }
}
