package com.example.demoproject;

import com.example.demoproject.Service.ShushDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoProjectApplication {

    public static void main(String[] args) {SpringApplication.run(DemoProjectApplication.class, args);}

}