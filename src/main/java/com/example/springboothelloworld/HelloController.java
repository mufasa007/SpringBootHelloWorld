package com.example.springboothelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 59456
 * @Date 2021/12/17
 * @Descrip
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/web")
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world! ";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "hello world! test";
    }
}
