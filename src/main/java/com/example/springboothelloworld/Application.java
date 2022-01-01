package com.example.springboothelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class Application {

    // http://localhost:8080/web/hello
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
