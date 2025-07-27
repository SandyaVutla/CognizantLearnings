package com.cognizant.spring_learn4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.spring_learn4")
public class SpringLearn4Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringLearn4Application.class, args);
    }
}
