package com.fhp.vipcenter.controller;

import com.fhp.vipcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private UserService userService;

    @GetMapping("/feginUser")
    public String getUserWithFeign(@RequestParam int id){
        return userService.sayHelloToUser(id);
    }

}
