package com.miv.mytwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class MyTwitterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyTwitterApplication.class, args);
    }

}
