package com.example.springboothelloworld.web.dao.impl;

import com.example.springboothelloworld.web.dao.UserDao;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("获取到mysql数据库用户信息");
    }
}
