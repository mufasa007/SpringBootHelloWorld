package com.example.springboothelloworld.web.service.impl;

import com.example.springboothelloworld.web.service.UserAopService;

/**
 * @Author 59456
 * @Date 2022/1/16
 * @Descrip
 * @Version 1.0
 */
public class UserAopServiceImpl implements UserAopService {
    @Override
    public String add() {
        System.out.println("增加");
        return "success";
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void query() {
        System.out.println("查询");
    }
}
