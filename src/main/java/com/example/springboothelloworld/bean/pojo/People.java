package com.example.springboothelloworld.bean.pojo;

import java.util.Date;

/**
 * @Author 59456
 * @Date 2022/1/11
 * @Descrip
 * @Version 1.0
 */
public class People {
    private Dog dog;
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
