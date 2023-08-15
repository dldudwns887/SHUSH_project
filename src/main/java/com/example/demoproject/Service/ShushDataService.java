package com.example.demoproject.Service;

import com.example.demoproject.Entity.*;
import com.example.demoproject.Repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShushDataService {

    private AEntranceRepository aEntranceRepository;
   /* private BEntranceRepository bEntranceRepository;
    private CEntranceRepository cEntranceRepository;

    private NoiseAverageHourPointARepository averageARepository;
    private NoiseAverageHourPointBRepository averageBRepository;
    private NoiseAverageHourPointCRepository averageRepository;*/
    private NoiseAverageTestRepository averageTestRepository;
    private NoiseAverageTestDailyRepository averageTestDailyRepository;
    private NoiseAverageTestWeeklyRepository averageTestWeeklyRepository;

    public ShushDataService(AEntranceRepository aEntranceRepository,
                            /*BEntranceRepository bEntranceRepository,
                            CEntranceRepository cEntranceRepository,
                            NoiseAverageHourPointARepository averageARepository,
                            NoiseAverageHourPointBRepository averageBRepository,
                            NoiseAverageHourPointCRepository averageRepository,*/
                            NoiseAverageTestRepository averageTestRepository,
                            NoiseAverageTestDailyRepository averageTestDailyRepository,
                            NoiseAverageTestWeeklyRepository averageTestWeeklyRepository) {
        this.aEntranceRepository = aEntranceRepository;
        /*this.bEntranceRepository = bEntranceRepository;
        this.cEntranceRepository = cEntranceRepository;
        this.averageARepository = averageARepository;
        this.averageBRepository = averageBRepository;
        this.averageRepository = averageRepository;*/
        this.averageTestRepository = averageTestRepository;
        this.averageTestDailyRepository = averageTestDailyRepository;
        this.averageTestWeeklyRepository = averageTestWeeklyRepository;
    }


    //한 주간 average
    public void calculateHourlyAverage(int pageSize) {
        Pageable pageable = PageRequest.of(0, pageSize);

        while (true) {

            Page<AEntranceEntity> pageA = aEntranceRepository.findAll(pageable);
            List<AEntranceEntity> noises = pageA.getContent();

            if (noises.isEmpty()) {
                break;
            }

            double sum = 0;
            for (AEntranceEntity i : noises) {
                sum += i.getDB();
            }
            double average = sum / noises.size();

            NoiseAverageTestEntity avgData = new NoiseAverageTestEntity();
            avgData.setAvg(average);
            avgData.setDate(noises.get(0).getTime().substring(0, 10));//날짜
            avgData.setHour(Integer.parseInt(noises.get(0).getTime().substring(11, 13))); //시간

            averageTestRepository.save(avgData);

            if (pageA.isLast()) break;

            pageable = pageable.next();
        }
    }

    public void calculateDailyAverage() {
        Pageable pageable = PageRequest.of(0, 24);
        while (true) {
            Page<NoiseAverageTestEntity> page = averageTestRepository.findAll(pageable);
            List<NoiseAverageTestEntity> avgs = page.getContent();

            if (avgs.isEmpty()) break;

            double sum = 0;

            for (NoiseAverageTestEntity i : avgs) {
                sum += i.getAvg();
            }

            NoiseAverageTestDailyEntity dailyAvg = new NoiseAverageTestDailyEntity();
            dailyAvg.setDate(avgs.get(0).getDate());
            dailyAvg.setAvg(sum / avgs.size());


        }
    }

    public void calculateWeeklyAverage() {
        Pageable pageable = PageRequest.of(0, 7);
        while (true) {
            Page<NoiseAverageTestDailyEntity> page = averageTestDailyRepository.findAll(pageable);
            List<NoiseAverageTestDailyEntity> avgs = page.getContent();

            if (avgs.isEmpty()) break;

            double sum = 0;

            for (NoiseAverageTestDailyEntity i : avgs) {
                sum += i.getAvg();
            }

            NoiseAverageTestWeeklyEntity dailyAvg = new NoiseAverageTestWeeklyEntity();
            dailyAvg.setStartDate(avgs.get(0).getDate());
            dailyAvg.setEndDate(avgs.get(23).getDate());
            dailyAvg.setAvg(sum / avgs.size());
        }


    }
}
/*
@Service
public class ShushDataService<dataEntityT, dataRepositoryT, avgEntityT, avgRepositoryT> {

    public void calculateHourlyAverage(int pageSize){

        Pageable Pageable = PageRequest.of(0, pageSize);

        while(true){
            Page<dataEntityT> page = dataRepositoryT.findall(pageable);
            List<dataEntityT> noises = page.getContent();

            if(noises.isEmpty()){
                break;
            }

            double sum=0;
            for(dataEntityT i : noises){
                sum+= i.getDB();
            }
            double average = sum /noises.size();

            NoiseAverageTestEntity avgData= new NoiseAverageTestEntity();
            Integer.parseInt(tmp[1].substring(0, 2)), item.getdB()


        }
    }
}
*/