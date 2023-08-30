package com.example.demoproject.Repository.AverageRepository;

import com.example.demoproject.Entity.AverageEntity.DayAverageAEntity;
import com.example.demoproject.Entity.EntityIDs.DayAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface DayAverageARepository extends JpaRepository<DayAverageAEntity, DayAverageId> {
    DayAverageAEntity findTopByOrderById_YearDescId_MonthDescId_DayDesc();

    DayAverageAEntity findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<DayAverageAEntity> findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(int year, int year1, int month, int month1, int dayOfMonth, int day);
}
