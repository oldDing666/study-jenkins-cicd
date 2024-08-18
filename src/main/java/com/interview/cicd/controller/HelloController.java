package com.interview.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: afuya
 * @program: study-jenkins-cicd
 * @date: 2024/8/18 09:44
 */

@RestController("/")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello afu!";
    }
}
