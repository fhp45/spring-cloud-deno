package com.fhp.ribbonservice.controller;


import com.fhp.ribbonservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/{id}")
    public String hello(@PathVariable("id") int id){
        return helloService.sayHelloToUser(id);
    }
}
