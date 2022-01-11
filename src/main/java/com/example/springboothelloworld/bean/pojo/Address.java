package com.example.springboothelloworld.bean.pojo;

/**
 * @Author 59456
 * @Date 2022/1/10
 * @Descrip
 * @Version 1.0
 */
public class Address {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "location='" + location + '\'' +
                '}';
    }
}
