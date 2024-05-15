package com.example.esun.service;

import com.example.esun.model.Users;

public interface UserService {
    Users addUsers(Users users);
    Users updateUsers(Users users);
    Users deleteUsers(Users users);
    boolean checkIfUserExist(String phone);
}