package com.fhp.usercenter.controller;

import com.fhp.usercenter.domain.User;
import com.fhp.usercenter.log.ControllerLogAccessor;
import com.fhp.usercenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping("delete")
    public List<User> deleteUser(@RequestParam String  name){
        userService.deleteUserByName(name);
        return userService.getAllUser();
    }

    @RequestMapping("insert")
    @ControllerLogAccessor(description = "插入用户")
    public List<User> insertUser(@RequestBody User user){
        userService.insertUser(user);
        return userService.getAllUser();
    }

    @RequestMapping("hi/{id}")
    public String helloUser(@PathVariable("id") int id){
        return "hello, "+ userService.getUserById(id).getUsername() + " from port : " + port;
    }

}
