package com.fhp.ribbonservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHelloToUser(int userId){
        return restTemplate.getForObject("http://USER-CENTER/hi/"+userId,String.class);
    }

    //实际情况中，我们会在这里将请求信息写入到数据库，等USER-CENTER服务恢复后，写入到该服务的数据库中
    public String hiError(int userId){
        System.out.println("写入数据库，方法名: sayHelloToUser, 参数：" +userId);
        return userId+"";
    }
}
