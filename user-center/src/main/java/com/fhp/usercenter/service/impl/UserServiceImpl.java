package com.fhp.usercenter.service.impl;

import com.fhp.usercenter.domain.User;
import com.fhp.usercenter.mapper.UserMapper;
import com.fhp.usercenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        System.out.println("service进行一些逻辑处理");
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(int id) {
        System.out.println("service进行一些逻辑处理");
        return userMapper.getUserById(id);
    }

    @Override
    public void deleteUserByName(String name) {
        System.out.println("service进行一些逻辑处理");
        userMapper.deleteUserByName(name);
    }

    @Override
    public void insertUser(User user) {
        System.out.println("service进行一些逻辑处理");
        userMapper.insertUser(user);
    }
}
