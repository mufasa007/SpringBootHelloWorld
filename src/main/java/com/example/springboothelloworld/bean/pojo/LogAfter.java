package com.example.springboothelloworld.bean.pojo;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author 59456
 * @Date 2022/1/16
 * @Descrip
 * @Version 1.0
 */
@Component
public class LogAfter implements AfterReturningAdvice {

    /**
     *
     * @param returnValue 执行后的返回结果
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName()+"方法执行后的结果为=>"+returnValue);
    }
}
