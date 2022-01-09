package com.example.springboothelloworld.web.service.impl;

import com.example.springboothelloworld.web.dao.UserDao;
import com.example.springboothelloworld.web.dao.impl.UserDaoImpl;
import com.example.springboothelloworld.web.dao.impl.UserDaoPgImpl;
import com.example.springboothelloworld.web.service.UserService;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDaoImpl();
    private UserDao userDao = new UserDaoPgImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
