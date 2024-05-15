package com.example.esun.service.impl;

import com.example.esun.dao.UsersDao;
import com.example.esun.dto.UsersDto;
import com.example.esun.model.Users;
import com.example.esun.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PasswordEncoder pwdEncoder;

    @Override
    public Users addUsers(Users users) {
        String encodedPwd = pwdEncoder.encode(users.getPassword()); // 加密
        users.setPassword(encodedPwd);
        return usersDao.save(users);
    }

    @Override
    public Users getUserById(long id) {
        return usersDao.findByUserId(id);
    }

    @Override
    public Users updateUsers(Users users) {
        return null;
    }

    @Override
    public Users deleteUsers(Users users) {
        return null;
    }

    @Override
    public boolean checkIfUserExist(String phone) {
        Users dbUser = usersDao.findByPhone(phone);
        return dbUser != null;
    }

    @Override
    public UsersDto login(String phone, String password) {
        Users dbUser = usersDao.findByPhone(phone);
        if(dbUser!=null)
        {
            // 你要比對的字串, 資料庫裡面的字串
            if (pwdEncoder.matches(password, dbUser.getPassword()))
            {
                UsersDto usersDto = new UsersDto();
                BeanUtils.copyProperties(dbUser,usersDto);
                return usersDto;
            }
        }
        return null;
    }
}
