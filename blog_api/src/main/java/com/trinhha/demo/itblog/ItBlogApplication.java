package com.trinhha.demo.itblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class ItBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItBlogApplication.class, args);
    }
}
