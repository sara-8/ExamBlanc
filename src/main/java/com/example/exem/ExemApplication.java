package com.example.exem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemApplication.class, args);
    }

}
