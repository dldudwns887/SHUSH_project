package com.example.demoproject.Service;


import com.example.demoproject.Entity.AverageEntity.*;
import com.example.demoproject.Entity.EntityIDs.DayAverageId;
import com.example.demoproject.Entity.EntityIDs.HourAverageId;
import com.example.demoproject.Entity.EntityIDs.WeekAverageId;
import com.example.demoproject.Entity.RawDataEntity.RawDataAEntity;
import com.example.demoproject.Entity.RawDataEntity.RawDataBEntity;
import com.example.demoproject.Entity.RawDataEntity.RawDataCEntity;
import com.example.demoproject.Repository.AverageRepository.*;
import com.example.demoproject.Repository.RawDataRepository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShushDataService implements CommandLineRunner {

    private final RawDataARepository rawDataA;
    private final RawDataBRepository rawDataB;
    private final RawDataCRepository rawDataC;
    private final HourAverageARepository hourAverageA;
    private final HourAverageBRepository hourAverageB;
    private final HourAverageCRepository hourAverageC;
    private final DayAverageARepository dayAverageA;
    private final DayAverageBRepository dayAverageB;
    private final DayAverageCRepository dayAverageC;
    private final WeekAverageARepository weekAverageA;
    private final WeekAverageBRepository weekAverageB;
    private final WeekAverageCRepository weekAverageC;
    List<Integer> monthlyDays = Arrays.asList(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    public ShushDataService(RawDataARepository rawDataA,
                            RawDataBRepository rawDataB,
                            RawDataCRepository rawDataC,
                            HourAverageARepository hourAverageA,
                            HourAverageBRepository hourAverageB,
                            HourAverageCRepository hourAverageC,
                            DayAverageARepository dayAverageA,
                            DayAverageBRepository dayAverageB,
                            DayAverageCRepository dayAverageC,
                            WeekAverageARepository weekAverageA,
                            WeekAverageBRepository weekAverageB,
                            WeekAverageCRepository weekAverageC) {
        this.rawDataA = rawDataA;
        this.rawDataB = rawDataB;
        this.rawDataC = rawDataC;
        this.hourAverageA = hourAverageA;
        this.hourAverageB = hourAverageB;
        this.hourAverageC = hourAverageC;
        this.dayAverageA = dayAverageA;
        this.dayAverageB = dayAverageB;
        this.dayAverageC = dayAverageC;
        this.weekAverageA = weekAverageA;
        this.weekAverageB = weekAverageB;
        this.weekAverageC = weekAverageC;

    }

    @Override
    public void run(String... args) throws Exception {
        calculateHourlyAverage();
        calculateDailyAverage();
        calculateWeeklyAverage();
    }

    //한 주간 average
    @Scheduled(cron = "0 0 * * * *")
    public void calculateHourlyAverage() {
        System.out.println("Started Hourly average calculation");
        int recentYear;
        int recentMonth;
        int recentDay;
        int recentHour;
        double average;
        HourAverageId hourId;

        HourAverageAEntity hourAEntity = hourAverageA.findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();


        if (hourAEntity == null) {
            RawDataAEntity rawdataAEntity = rawDataA.findTopByOrderById_YearAscId_MonthAscId_DayAscId_HourAsc();
            recentYear = rawdataAEntity.getId().getYear();
            recentMonth = rawdataAEntity.getId().getMonth();
            recentDay = rawdataAEntity.getId().getDay();
            recentHour = rawdataAEntity.getId().getHour();
        } else {
            recentYear = hourAEntity.getId().getYear();
            recentMonth = hourAEntity.getId().getMonth();
            recentDay = hourAEntity.getId().getDay();
            recentHour = hourAEntity.getId().getHour();
            hourAverageA.delete(hourAEntity);//1개 중복연산을 방지하기 위해 제일 최근 평균 데이터 하나쯤은 날린다 그냥
        }

        while (true) {

            List<RawDataAEntity> rawDataAEntities = rawDataA.findById_YearAndId_MonthAndId_DayAndId_Hour(
                    recentYear, recentMonth, recentDay, recentHour);

            if (rawDataAEntities.isEmpty())
                break;
            //평균값 계산.
            average = rawDataAEntities.stream().mapToInt(RawDataAEntity::getDB).average().orElse(0.0);
            //구한 평균값 저장
            hourId = HourAverageId.builder()
                    .year(recentYear)
                    .month(recentMonth)
                    .day(recentDay)
                    .hour(recentHour)
                    .a('a').build();
            hourAverageA.save(HourAverageAEntity.builder().id(hourId).average(average).build());
            recentHour += 1;
            if (recentHour == 24) {
                recentDay += 1;
                recentHour = 0;
                if (recentDay > monthlyDays.get(recentMonth)) {
                    recentMonth += 1;
                    recentDay = 1;
                    if (recentMonth > 12) {
                        recentYear += 1;
                        recentMonth = 1;
                    }
                }
            }
        }


        //@B포인트 평균값 계산
        HourAverageBEntity hourBEntity = hourAverageB.findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();


        if (hourBEntity == null) {
            RawDataBEntity rawDataBEntity = rawDataB.findTopByOrderById_YearAscId_MonthAscId_DayAscId_HourAsc();
            recentYear = rawDataBEntity.getId().getYear();
            recentMonth = rawDataBEntity.getId().getMonth();
            recentDay = rawDataBEntity.getId().getDay();
            recentHour = rawDataBEntity.getId().getHour();
        } else {
            recentYear = hourBEntity.getId().getYear();
            recentMonth = hourBEntity.getId().getMonth();
            recentDay = hourBEntity.getId().getDay();
            recentHour = hourBEntity.getId().getHour();
        }

        while (true) {

            List<RawDataBEntity> rawDataBEntities = rawDataB.findById_YearAndId_MonthAndId_DayAndId_Hour(
                    recentYear, recentMonth, recentDay, recentHour);

            if (rawDataBEntities.isEmpty())
                break;
            //평균값 계산.
            average = rawDataBEntities.stream().mapToInt(RawDataBEntity::getDB).average().orElse(0.0);
            //구한 평균값 저장
            hourId = HourAverageId.builder()
                    .year(recentYear)
                    .month(recentMonth)
                    .day(recentDay)
                    .hour(recentHour)
                    .a('a').build();
            hourAverageB.save(HourAverageBEntity.builder().id(hourId).average(average).build());

            recentHour += 1;
            if (recentHour == 24) {
                recentDay += 1;
                recentHour = 0;
                if (recentDay > monthlyDays.get(recentMonth)) {
                    recentMonth += 1;
                    recentDay = 1;
                    if (recentMonth > 12) {
                        recentYear += 1;
                        recentMonth = 1;
                    }
                }
            }
        }
        //@C포인트 평균값 계산
        HourAverageCEntity hourCEntity = hourAverageC.findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();


        if (hourCEntity == null) {
            RawDataCEntity rawDataCEntity = rawDataC.findTopByOrderById_YearAscId_MonthAscId_DayAscId_HourAsc();
            recentYear = rawDataCEntity.getId().getYear();
            recentMonth = rawDataCEntity.getId().getMonth();
            recentDay = rawDataCEntity.getId().getDay();
            recentHour = rawDataCEntity.getId().getHour();
        } else {
            recentYear = hourCEntity.getId().getYear();
            recentMonth = hourCEntity.getId().getMonth();
            recentDay = hourCEntity.getId().getDay();
            recentHour = hourCEntity.getId().getHour();
        }

        while (true) {

            List<RawDataCEntity> rawDataCEntities = rawDataC.findById_YearAndId_MonthAndId_DayAndId_Hour(
                    recentYear, recentMonth, recentDay, recentHour);

            if (rawDataCEntities.isEmpty())
                break;
            //평균값 계산.
            average = rawDataCEntities.stream().mapToInt(RawDataCEntity::getDB).average().orElse(0.0);
            //구한 평균값 저장
            hourId = HourAverageId.builder()
                    .year(recentYear)
                    .month(recentMonth)
                    .day(recentDay)
                    .hour(recentHour)
                    .a('a').build();
            hourAverageC.save(HourAverageCEntity.builder().id(hourId).average(average).build());
            recentHour += 1;
            if (recentHour == 24) {
                recentDay += 1;
                recentHour = 0;
                if (recentDay > monthlyDays.get(recentMonth)) {
                    recentMonth += 1;
                    recentDay = 1;
                    if (recentMonth > 12) {
                        recentYear += 1;
                        recentMonth = 1;
                    }
                }
            }
        }
        System.out.println("Ended Hourly average calculation");

    }

    @Scheduled(cron = "0 5 * * * *")
    public void calculateDailyAverage() {
        System.out.println("Started Daily average calculation");
        int recentYear;
        int recentMonth;
        int recentDay;
        double average;
        DayAverageId dayId;

        DayAverageAEntity dayAEntity = dayAverageA.findTopByOrderById_YearDescId_MonthDescId_DayDesc();

        if(dayAEntity==null){
            HourAverageAEntity hourAverageAEntity = hourAverageA.findTopByOrderById_YearAscId_MonthAscId_DayAsc();
            recentYear = hourAverageAEntity.getId().getYear();
            recentMonth = hourAverageAEntity.getId().getMonth();
            recentDay = hourAverageAEntity.getId().getDay();
        }
        else{
            recentYear = dayAEntity.getId().getYear();
            recentMonth = dayAEntity.getId().getMonth();
            recentDay = dayAEntity.getId().getDay();
            dayAverageA.delete(dayAEntity);
        }

        while(true) {
            List<HourAverageAEntity> hourAverageAEntities = hourAverageA.findById_YearAndId_MonthAndId_Day(
                    recentYear, recentMonth, recentDay);

            if (hourAverageAEntities.isEmpty()) {
                break;
            }
            average = hourAverageAEntities.stream()
                    .mapToDouble(HourAverageAEntity::getAverage)
                    .average()
                    .orElse(0.0);

            dayId = DayAverageId.builder()
                    .year(recentYear)
                    .month(recentMonth)
                    .day(recentDay)
                    .build();
            dayAverageA.save(DayAverageAEntity.builder().id(dayId).average(average).build());

            recentDay += 1;
            if (recentDay > monthlyDays.get(recentMonth)) {
                recentMonth += 1;
                recentDay = 1;
                if (recentMonth > 12) {
                    recentYear += 1;
                    recentMonth = 1;
                }
            }
        }

        DayAverageBEntity dayBEntity = dayAverageB.findTopByOrderById_YearDescId_MonthDescId_DayDesc();

        if(dayBEntity==null){
            HourAverageBEntity hourAverageBEntity = hourAverageB.findTopByOrderById_YearAscId_MonthAscId_DayAsc();
            recentYear = hourAverageBEntity.getId().getYear();
            recentMonth = hourAverageBEntity.getId().getMonth();
            recentDay = hourAverageBEntity.getId().getDay();
        }
        else{
            recentYear = dayBEntity.getId().getYear();
            recentMonth = dayBEntity.getId().getMonth();
            recentDay = dayBEntity.getId().getDay();
            dayAverageB.delete(dayBEntity);
        }

        while(true) {
            List<HourAverageBEntity> hourAverageBEntities = hourAverageB.findById_YearAndId_MonthAndId_Day(
                    recentYear, recentMonth, recentDay);

            if (hourAverageBEntities.isEmpty()) {
                break;
            }
            average = hourAverageBEntities.stream()
                    .mapToDouble(HourAverageBEntity::getAverage)
                    .average()
                    .orElse(0.0);

            dayId = DayAverageId.builder()
                    .year(recentYear)
                    .month(recentMonth)
                    .day(recentDay)
                    .build();
            dayAverageB.save(DayAverageBEntity.builder().id(dayId).average(average).build());

            recentDay += 1;
            if (recentDay > monthlyDays.get(recentMonth)) {
                recentMonth += 1;
                recentDay = 1;
                if (recentMonth > 12) {
                    recentYear += 1;
                    recentMonth = 1;
                }
            }
        }

        DayAverageCEntity dayCEntity = dayAverageC.findTopByOrderById_YearDescId_MonthDescId_DayDesc();

        if(dayCEntity==null){
            HourAverageCEntity hourAverageCEntity = hourAverageC.findTopByOrderById_YearAscId_MonthAscId_DayAsc();
            recentYear = hourAverageCEntity.getId().getYear();
            recentMonth = hourAverageCEntity.getId().getMonth();
            recentDay = hourAverageCEntity.getId().getDay();
        }
        else{
            recentYear = dayCEntity.getId().getYear();
            recentMonth = dayCEntity.getId().getMonth();
            recentDay = dayCEntity.getId().getDay();
            dayAverageC.delete(dayCEntity);
        }

        while(true) {
            List<HourAverageCEntity> hourAverageCEntities = hourAverageC.findById_YearAndId_MonthAndId_Day(
                    recentYear, recentMonth, recentDay);

            if (hourAverageCEntities.isEmpty()) {
                break;
            }
            average = hourAverageCEntities.stream()
                    .mapToDouble(HourAverageCEntity::getAverage)
                    .average()
                    .orElse(0.0);

            dayId = DayAverageId.builder()
                    .year(recentYear)
                    .month(recentMonth)
                    .day(recentDay)
                    .build();
            dayAverageC.save(DayAverageCEntity.builder().id(dayId).average(average).build());

            recentDay += 1;
            if (recentDay > monthlyDays.get(recentMonth)) {
                recentMonth += 1;
                recentDay = 1;
                if (recentMonth > 12) {
                    recentYear += 1;
                    recentMonth = 1;
                }
            }
        }
        System.out.println("Ended Daily average calculation");

    }

    @Scheduled(cron = "0 7 0 * * *")
    public void calculateWeeklyAverage() {
        System.out.println("Started Weekly average calculation");
        int recentYear;
        int recentMonth;
        int recentDay;
        double average;
        WeekAverageId weekAverageId;
        Pageable pageable;

        WeekAverageAEntity weekAverageAEntity = weekAverageA.findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();
        if(weekAverageAEntity ==null){
            DayAverageAEntity dayAverageAEntity = dayAverageA.findTopByOrderById_YearAscId_MonthAscId_DayAsc();
            recentYear = dayAverageAEntity.getId().getYear();
            recentMonth = dayAverageAEntity.getId().getMonth();
            recentDay = dayAverageAEntity.getId().getDay();
        }
        else{
            recentYear = weekAverageAEntity.getId().getStartYear();
            recentMonth = weekAverageAEntity.getId().getStartMonth();
            recentDay = weekAverageAEntity.getId().getStartDay();
            weekAverageA.delete(weekAverageAEntity);
        }
        pageable = PageRequest.of(0,7);
        while(true){
            Page<DayAverageAEntity> dayAverageAEntityPage = dayAverageA.findAll(pageable);
            List<DayAverageAEntity>  dayAverageAEntities = dayAverageAEntityPage.getContent();

            if(dayAverageAEntityPage.isEmpty())
                break;

            DayAverageId startDayAverageId=dayAverageAEntities.get(0).getId();
            DayAverageId endDayAverageId = dayAverageAEntities.get(dayAverageAEntities.size()-1).getId();



            average = dayAverageAEntities.stream().mapToDouble(DayAverageAEntity::getAverage).average().orElse(0.0);

            weekAverageId = WeekAverageId.builder()
                    .startYear(startDayAverageId.getYear())
                    .startMonth(startDayAverageId.getMonth())
                    .startDay(startDayAverageId.getDay())
                    .build();


            weekAverageA.save(WeekAverageAEntity
                    .builder().id(weekAverageId)
                    .endYear(endDayAverageId.getYear())
                    .endMonth(endDayAverageId.getMonth())
                    .endDay(endDayAverageId.getDay())
                    .average(average)
                    .build());

            pageable = pageable.next();

        }

    //B 주간 평균
    WeekAverageBEntity weekAverageBEntity = weekAverageB.findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();

        if(weekAverageBEntity ==null){
        DayAverageBEntity dayAverageBEntity = dayAverageB.findTopByOrderById_YearAscId_MonthAscId_DayAsc();
        recentYear = dayAverageBEntity.getId().getYear();
        recentMonth = dayAverageBEntity.getId().getMonth();
        recentDay = dayAverageBEntity.getId().getDay();
    }
        else{
        recentYear = weekAverageBEntity.getId().getStartYear();
        recentMonth = weekAverageBEntity.getId().getStartMonth();
        recentDay = weekAverageBEntity.getId().getStartDay();
        weekAverageB.delete(weekAverageBEntity);
    }

    pageable = PageRequest.of(0,7);

        while(true){
        Page<DayAverageBEntity> dayAverageBEntityPage = dayAverageB.findAll(pageable);
        List<DayAverageBEntity>  dayAverageBEntities = dayAverageBEntityPage.getContent();

        if(dayAverageBEntityPage.isEmpty())
            break;

        DayAverageId startDayAverageId=dayAverageBEntities.get(0).getId();
        DayAverageId endDayAverageId = dayAverageBEntities.get(dayAverageBEntities.size()-1).getId();



        average = dayAverageBEntities.stream().mapToDouble(DayAverageBEntity::getAverage).average().orElse(0.0);

        weekAverageId = WeekAverageId.builder()
                .startYear(startDayAverageId.getYear())
                .startMonth(startDayAverageId.getMonth())
                .startDay(startDayAverageId.getDay())
                .build();


        weekAverageB.save(WeekAverageBEntity
                .builder().id(weekAverageId)
                .endYear(endDayAverageId.getYear())
                .endMonth(endDayAverageId.getMonth())
                .endDay(endDayAverageId.getDay())
                .average(average)
                .build());

        pageable = pageable.next();
    }

        WeekAverageCEntity weekAverageCEntity = weekAverageC.findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();

        if(weekAverageCEntity ==null){
            DayAverageCEntity dayAverageCEntity = dayAverageC.findTopByOrderById_YearAscId_MonthAscId_DayAsc();
            recentYear = dayAverageCEntity.getId().getYear();
            recentMonth = dayAverageCEntity.getId().getMonth();
            recentDay = dayAverageCEntity.getId().getDay();
        }
        else{
            recentYear = weekAverageCEntity.getId().getStartYear();
            recentMonth = weekAverageCEntity.getId().getStartMonth();
            recentDay = weekAverageCEntity.getId().getStartDay();
            weekAverageC.delete(weekAverageCEntity);
        }

        pageable = PageRequest.of(0,7);

        while(true){
            Page<DayAverageCEntity> dayAverageCEntityPage = dayAverageC.findAll(pageable);
            List<DayAverageCEntity>  dayAverageCEntities = dayAverageCEntityPage.getContent();

            if(dayAverageCEntityPage.isEmpty())
                break;

            DayAverageId startDayAverageId=dayAverageCEntities.get(0).getId();
            DayAverageId endDayAverageId = dayAverageCEntities.get(dayAverageCEntities.size()-1).getId();



            average = dayAverageCEntities.stream().mapToDouble(DayAverageCEntity::getAverage).average().orElse(0.0);

            weekAverageId = WeekAverageId.builder()
                    .startYear(startDayAverageId.getYear())
                    .startMonth(startDayAverageId.getMonth())
                    .startDay(startDayAverageId.getDay())
                    .build();


            weekAverageC.save(WeekAverageCEntity
                    .builder().id(weekAverageId)
                    .endYear(endDayAverageId.getYear())
                    .endMonth(endDayAverageId.getMonth())
                    .endDay(endDayAverageId.getDay())
                    .average(average)
                    .build());

            pageable = pageable.next();

        }
        System.out.println("Ended Weekly average calculation");
}


}