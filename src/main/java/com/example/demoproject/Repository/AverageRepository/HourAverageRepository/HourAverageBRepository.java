package com.example.demoproject.Repository.AverageRepository.HourAverageRepository;

import com.example.demoproject.Entity.AverageEntity.HourAverageEntity.HourAverageBEntity;
import com.example.demoproject.Entity.EntityIDs.HourAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourAverageBRepository extends JpaRepository<HourAverageBEntity, HourAverageId> {
    HourAverageBEntity findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();

    HourAverageBEntity findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<HourAverageBEntity> findById_YearAndId_MonthAndId_Day(int recentYear, int recentMonth, int recentDay);

}
