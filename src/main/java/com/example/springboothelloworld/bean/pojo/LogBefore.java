package com.example.springboothelloworld.bean.pojo;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author 59456
 * @Date 2022/1/16
 * @Descrip
 * @Version 1.0
 */
@Component
public class LogBefore implements MethodBeforeAdvice {
    /**
     *
     * @param method 要执行目标对象的方法
     * @param args 参数
     * @param target 被通知的对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println(target.getClass().getName()+"类的"+method.getName()+"方法【将要】被执行!");
    }
}
