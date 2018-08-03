package com.trinhha.demo.itblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ItBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItBlogApplication.class, args);
    }
}
