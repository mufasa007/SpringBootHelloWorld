package com.example.springboothelloworld.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Author 59456
 * @Date 2022/1/16
 * @Descrip
 * @Version 1.0
 */
@Aspect
public class AnotationPointCut {

//    @Before("execution(* com.example.springboothelloworld.web.service.impl.UserAopServiceImpl.*(..))")
//    public void before(){
//        System.out.println("==执行前==");
//    }

    @Around("execution(* com.example.springboothelloworld.web.service.impl.UserAopServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        Signature signature = jp.getSignature();
        System.out.println("signature:"+signature);
        // 执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后");
    }
}
