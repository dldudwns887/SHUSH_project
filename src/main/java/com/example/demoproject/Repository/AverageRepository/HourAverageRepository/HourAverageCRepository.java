package com.example.demoproject.Repository.AverageRepository.HourAverageRepository;

import com.example.demoproject.Entity.AverageEntity.HourAverageEntity.HourAverageCEntity;
import com.example.demoproject.Entity.EntityIDs.HourAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourAverageCRepository extends JpaRepository<HourAverageCEntity, HourAverageId> {
    HourAverageCEntity findTopByOrderById_YearDescId_MonthDescId_DayDesc();

    HourAverageCEntity findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();

    HourAverageCEntity findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<HourAverageCEntity> findById_YearAndId_MonthAndId_Day(int recentYear, int recentMonth, int recentDay);;
}
