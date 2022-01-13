package com.example.springboothelloworld.bean.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author 59456
 * @Date 2022/1/11
 * @Descrip
 * @Version 1.0
 */
public class People {
    // 说明该对象可以为null，否则不允许为空
//    @Autowired(required = false)
    // javax的注解也可以实现自动装配
    @Resource
    private Dog dog;
    @Autowired
    // 指定特定的对象
    @Qualifier(value = "cat2")
    private Cat cat;
    private String name;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
