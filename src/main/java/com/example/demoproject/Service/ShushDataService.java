package com.example.demoproject.Service;

import com.example.demoproject.Entity.*;
import com.example.demoproject.Repository.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShushDataService {

    private AEntranceRepository aEntranceRepository;
    private CEntranceRepository cEntranceRepository;
    private BEntranceRepository bEntranceRepository;

    private AEntranceEntity aEntranceEntity;
    private CEntranceEntity cEntranceEntity;
    private BEntranceEntity bEntranceEntity;
    private NoiseAverageHourPointARepository averageARepository;
    private NoiseAverageHourPointBRepository averageBRepository;
    private NoiseAverageHourPointCRepository averagecRepository;
    private NoiseAverageTestRopository averageTestRopository;
    private NoiseAverageHourPointAEntity averageAEntity;
    private NoiseAverageHourPointBEntity averageBEntity;
    private NoiseAverageHourPointCEntity averagecEntity;
    private NoiseAverageTestEntity averageTestEntity;

    public void calculateHourlyAverage(int pageSize){

        Pageable Pageable = PageRequest.of(0, pageSize);

        while(true){
            Page<aEntranceEntity> page = aEntranceRepository.findAll(Pageable);
            List<aEntranceEntity> noises = page.getContent();

            if(noises.isEmpty()){
                break;
            }

            double sum=0;
            for(aEntranceEntity i : noises){
                sum+= i.getDB();
            }
            double average = sum /noises.size();

            NoiseAverageTestEntity avgData= new NoiseAverageTestEntity();
            Integer.parseInt(tmp[1].substring(0, 2)), item.getdB()


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