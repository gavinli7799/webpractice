package com.learn.springbootwebpractice.mapper;

import com.learn.springbootwebpractice.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username, password) values (#{username},#{password})")
    void addUser(User user);

    @Select("select * from user where username=#{username}")
    User getUser(String username);

    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username, String password);
}
