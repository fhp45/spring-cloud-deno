package com.fhp.vipcenter.controller;

import com.fhp.vipcenter.mapper.VipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class VipController {
    @Autowired
    private VipMapper vipMapper;

    @Autowired
    RestTemplate restTemplate;

    @LoadBalanced
    public String sayHelloToUser(int userId){
        return restTemplate.getForObject("http://USER-CENTER/user/"+userId,String.class);
    }

    @RequestMapping("/isVip/{id}")
    public int isVip(@PathVariable("id") int id){
        return vipMapper.vipLevel(id);
    }

    @RequestMapping("/getUserByVipId/{id}")
    public String getUserByVipId(@PathVariable("id") int id){
        return sayHelloToUser(id);
    }



}
