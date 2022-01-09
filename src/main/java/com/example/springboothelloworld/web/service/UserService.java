package com.example.springboothelloworld.web.service;

import com.example.springboothelloworld.web.dao.UserDao;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public interface UserService {

    void setUserDao(UserDao userDao);
    void getUser();
}
