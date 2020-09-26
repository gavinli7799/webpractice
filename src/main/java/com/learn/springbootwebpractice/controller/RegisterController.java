package com.learn.springbootwebpractice.controller;

import com.learn.springbootwebpractice.mapper.UserMapper;
import com.learn.springbootwebpractice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    private UserMapper userMapper;



    @RequestMapping("/register")
    public String register(HttpServletRequest request, Map<String, Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = userMapper.getUser(username);
        if(user!=null){
            map.put("msg","The user has been registered! Try another one!");
            return "register";
        }

        else {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            userMapper.addUser(newUser);
            map.put("msg","Congratulations! You have successfully registered!");
            return "login";
        }


    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = userMapper.login(username, password);
        if (loginUser!=null){
            map.put("msg", "the user :" + loginUser.getUsername() + " logged.");
        } else {
            map.put("msg", "Username or password not matched");
        }

        return "login";
    }

}
