package com.fhp.vipcenter.service;


import com.fhp.vipcenter.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-center", fallback = UserServiceImpl.class)
public interface UserService {

    @RequestMapping(value = "user/{id}" ,method = RequestMethod.GET)
    String sayHelloToUser(@PathVariable("id") int id);

}
