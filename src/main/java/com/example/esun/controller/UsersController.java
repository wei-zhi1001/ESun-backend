package com.example.esun.controller;

import com.example.esun.dto.UsersDto;
import com.example.esun.model.Users;
import com.example.esun.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@CrossOrigin(allowCredentials = "true", origins = { "http://localhost:5173" })
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

    @PostMapping("/user/login")
    public UsersDto login(
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            HttpSession session) {
        UsersDto result = userService.login(phone, password);
        if(result != null) {
            session.setAttribute("loggedInUser", result);
            return result;
        }else {
            throw new RuntimeException("登入失敗，帳號或密碼錯誤");
        }
        //return result;
    }

    @GetMapping("/user/logout")
    public boolean logout(HttpSession session) {
        session.invalidate();
        return true;
    }
}
