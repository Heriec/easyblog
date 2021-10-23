package com.heriec.easyblogmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EasyblogMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyblogMasterApplication.class, args);
    }

}
