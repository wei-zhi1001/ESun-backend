package com.example.esun.controller;

import com.example.esun.model.Users;
import com.example.esun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UsersController
{
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public Users register(
            @RequestParam("name") String username,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password){

        boolean isExist = userService.checkIfUserExist(phone);
        if(isExist) {
            throw new RuntimeException("此號碼已註冊過");
        }else {
            Users newUsers = new Users();
            newUsers.setUserName(username);
            newUsers.setEmail(email);
            newUsers.setPhone(phone);
            newUsers.setPassword(password);

            userService.addUsers(newUsers);
            return newUsers;
        }
    }


}
