package com.fhp.usercenter.service;

import com.fhp.usercenter.domain.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    User getUserById(int id);

    void deleteUserByName(String name);

    void insertUser(User user);
}
