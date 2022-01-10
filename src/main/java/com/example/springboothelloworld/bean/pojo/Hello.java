package com.example.springboothelloworld.bean.pojo;

/**
 * @Author 59456
 * @Date 2022/1/9
 * @Descrip
 * @Version 1.0
 */
public class Hello {
    private String str;

    public Hello() {
        System.out.println("初始化hello对象! ");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }

    public void show(){
        System.out.println("数据=>"+str);
    }
}
