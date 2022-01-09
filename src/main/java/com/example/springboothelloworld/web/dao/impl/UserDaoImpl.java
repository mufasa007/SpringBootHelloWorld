package com.example.springboothelloworld.web.dao.impl;

import com.example.springboothelloworld.web.dao.UserDao;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("获取到用户信息! ");
    }
}
