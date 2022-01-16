package com.example.springboothelloworld.bean.pojo;

/**
 * @Author 59456
 * @Date 2022/1/16
 * @Descrip
 * @Version 1.0
 */
public class CustomeLog {
    public void before(){
        System.out.println("==方法执行之前==");
    }
    public void after(){
        System.out.println("==方法执行之后==");
    }
}
