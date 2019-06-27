package com.fhp.usercenter.mapper;


import com.fhp.usercenter.domain.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAllUser();

    User getUserById(int id);

    void deleteUserByName(String name);

    void insertUser(User user);
}
