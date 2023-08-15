package com.example.demoproject.Controller;

import com.example.demoproject.Entity.NoiseAverageTestDailyEntity;
import com.example.demoproject.Entity.NoiseAverageTestEntity;
import com.example.demoproject.Entity.NoiseAverageTestWeeklyEntity;
import com.example.demoproject.Repository.AEntranceRepository;
import com.example.demoproject.Entity.AEntranceEntity;
import com.example.demoproject.Repository.NoiseAverageTestDailyRepository;
import com.example.demoproject.Repository.NoiseAverageTestRepository;
import com.example.demoproject.Repository.NoiseAverageTestWeeklyRepository;
import com.example.demoproject.Service.ShushDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(originPatterns = "http://localhost:3000")
@RequiredArgsConstructor
@RestController//해당 클래스를 Controller 레이어로 인식하게함//@Controller+@REsponseBody임
@RequestMapping(value= "/*")//()안에 URL패턴이 오고 - request왔을때 request의 url의 패턴을 보고 해당하는 클래스를 실행
public class MainController {

    final private AEntranceRepository aEntranceRepository;
    final private NoiseAverageTestRepository noiseAverageTestRepository;
    final private NoiseAverageTestDailyRepository noiseAverageTestDailyRepository;
    final private NoiseAverageTestWeeklyRepository noiseAverageTestWeeklyRepository;
    //private ShushDataService dataService;
    final private ShushDataService shushDataService;

    @GetMapping("data")
    public List<AEntranceEntity> rawData(){
        System.out.println("started calculating");
        shushDataService.calculateHourlyAverage(360);
        shushDataService.calculateDailyAverage();
        shushDataService.calculateWeeklyAverage();
        System.out.println("ended calculating");

        return aEntranceRepository.findAll();
    }
    @GetMapping("averageDataHourly")
    public List<NoiseAverageTestEntity> hourlyAverageData(){
        //dataService.calculateHourlyAverage(360);

        return noiseAverageTestRepository.findAll();
    }

    @GetMapping("averageDataDaily")
    public List<NoiseAverageTestDailyEntity> dailyAverageData(){
        //dataService.calculateDailyAverage();
        return noiseAverageTestDailyRepository.findAll();
    }

    @GetMapping("averageDataWeekly")
    public List<NoiseAverageTestWeeklyEntity> weeklyAverageData(){
        //dataService.calculateWeeklyAverage();
        return noiseAverageTestWeeklyRepository.findAll();
    }

}