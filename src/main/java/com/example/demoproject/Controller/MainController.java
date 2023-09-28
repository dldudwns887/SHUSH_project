package com.example.demoproject.Controller;
import com.example.demoproject.Entity.AverageEntity.*;
import com.example.demoproject.Repository.AverageRepository.*;
import com.example.demoproject.Service.ShushDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.List;
import java.time.*;



@RequiredArgsConstructor
@RestController//해당 클래스를 Controller 레이어로 인식하게함//@Controller+@REsponseBody임
@RequestMapping(value= "/getAverageData")//()안에 URL패턴이 오고 - request왔을때 request의 url의 패턴을 보고 해당하는 클래스를 실행
public class MainController {
    final private HourAverageARepository hourAverageARepository;
    final private HourAverageBRepository hourAverageBRepository;
    final private HourAverageCRepository hourAverageCRepository;

    final private DayAverageARepository dayAverageARepository;
    final private DayAverageBRepository dayAverageBRepository;
    final private DayAverageCRepository dayAverageCRepository;

    final private WeekAverageARepository weekAverageARepository;
    final private WeekAverageBRepository weekAverageBRepository;
    final private WeekAverageCRepository weekAverageCRepository;

    //private ShushDataService dataService;
    final private ShushDataService shushDataService;

    public static LocalDate getLastSunday(LocalDate date){
        int daysToLastSunday = date.getDayOfWeek().getValue();
        if(daysToLastSunday==7)
            return date;
        else
            return date.minusDays(daysToLastSunday);
    }
    public static LocalDate getThisSaturday(LocalDate date){
        int daysToLastSunday = date.getDayOfWeek().getValue();
        if(daysToLastSunday==7)
            return date.plusDays(6);
        else
            return date.plusDays(6- daysToLastSunday);
        //6이면 0
        //5이면 1
        //4면 2
        //3이면 3
        //2면 4
        //1이면 5
        //0이면 6

    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/hourly/{year}-{month}-{day}/A")
    public List<HourAverageAEntity> hourlyAverageAData(@PathVariable int year,
                                                       @PathVariable int month,
                                                       @PathVariable int day){
        return hourAverageARepository.findById_YearAndId_MonthAndId_Day(
                year,
                month,
                day);
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping("/hourly/{year}-{month}-{day}/B")
    public List<HourAverageBEntity> hourlyAverageBData(@PathVariable int year,
                                                       @PathVariable int month,
                                                       @PathVariable int day){
        return hourAverageBRepository.findById_YearAndId_MonthAndId_Day(
                year,
                month,
                day);
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/hourly/{year}-{month}-{day}/C")
    public List<HourAverageCEntity> hourlyAverageCData(@PathVariable int year,
                                                       @PathVariable int month,
                                                       @PathVariable int day){
        return hourAverageCRepository.findById_YearAndId_MonthAndId_Day(
                year,
                month,
                day);
    }


    @CrossOrigin(originPatterns = "*")
    @GetMapping("/daily/{year}-{month}-{day}/A")
    public List<DayAverageAEntity> dailyAverageAData(@PathVariable int year,
                                 @PathVariable int month,
                                 @PathVariable int day){
        LocalDate date = LocalDate.of(year,month, day);
        LocalDate saturday = getThisSaturday(date);
        date = getLastSunday(date);

        return dayAverageARepository.findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(
                date.getYear(), saturday.getYear(),
                date.getMonth().getValue(), saturday.getMonth().getValue(),
                date.getDayOfMonth(), saturday.getDayOfMonth());

    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/daily/{year}-{month}-{day}/B")
    public List<DayAverageBEntity> dailyAverageBData(@PathVariable int year,
                                                     @PathVariable int month,
                                                     @PathVariable int day){
        LocalDate date = LocalDate.of(year,month, day);
        LocalDate saturday = getThisSaturday(date);
        date = getLastSunday(date);


        if(date.getMonth() != saturday.getMonth() || date.getYear() != saturday.getYear() ) {

            List<DayAverageBEntity> result = dayAverageBRepository.findById_YearAndId_MonthAndId_DayGreaterThanEqual(
                    date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());
            result.addAll(dayAverageBRepository.findById_YearAndId_MonthAndId_DayLessThanEqual(
                    saturday.getYear(), saturday.getMonth().getValue(), saturday.getDayOfMonth()));
            return result;
        }
        else{
            return dayAverageBRepository.findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(
                    date.getYear(), saturday.getYear(),
                    date.getMonth().getValue(), saturday.getMonth().getValue(),
                    date.getDayOfMonth(), saturday.getDayOfMonth());
        }
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/daily/{year}-{month}-{day}/C")
    public List<DayAverageCEntity> dailyAverageCData(@PathVariable int year,
                                                     @PathVariable int month,
                                                     @PathVariable int day){
        LocalDate date = LocalDate.of(year,month, day);
        LocalDate saturday = getThisSaturday(date);
        date = getLastSunday(date);

        return dayAverageCRepository.findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(
                date.getYear(), saturday.getYear(),
                date.getMonth().getValue(), saturday.getMonth().getValue(),
                date.getDayOfMonth(), saturday.getDayOfMonth());

    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping("/weekly/{year}-{month}-{day}/A")
    public List<WeekAverageAEntity> weeklyAverageAData(@PathVariable int year,
                                                      @PathVariable int month,
                                                      @PathVariable int day){
        LocalDate date = LocalDate.of(year,month, day);
        date = getLastSunday(date);
        return weekAverageARepository.findById_StartYearAndId_StartMonthAndId_StartDay(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/weekly/{year}-{month}-{day}/B")
    public List<WeekAverageBEntity> weeklyAverageBData(@PathVariable int year,
                                                       @PathVariable int month,
                                                       @PathVariable int day){
        LocalDate date = LocalDate.of(year,month, day);
        date = getLastSunday(date);
        return weekAverageBRepository.findById_StartYearAndId_StartMonthAndId_StartDay(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping("/weekly/{year}-{month}-{day}/C")
    public List<WeekAverageCEntity> weeklyAverageCData(@PathVariable int year,
                                                      @PathVariable int month,
                                                      @PathVariable int day){
        LocalDate date = LocalDate.of(year,month, day);
        date = getLastSunday(date);
        return weekAverageCRepository.findById_StartYearAndId_StartMonthAndId_StartDay(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());

    }

}