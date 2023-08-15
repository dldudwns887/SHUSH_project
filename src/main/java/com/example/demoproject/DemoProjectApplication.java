package com.example.demoproject;

import com.example.demoproject.Service.ShushDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectApplication {
    /*
    private ShushDataService shushDataService;
    shushDataService.calculateHourlyAverage(360);
    shushDataService.calculateDailyAverage();
    shushDataService.calculateWeeklyAverage();
    */

    public static void main(String[] args) {SpringApplication.run(DemoProjectApplication.class, args);}

}
