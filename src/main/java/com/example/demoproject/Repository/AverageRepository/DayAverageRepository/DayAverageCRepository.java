package com.example.demoproject.Repository.AverageRepository.DayAverageRepository;

import com.example.demoproject.Entity.AverageEntity.DayAverageEntity.DayAverageCEntity;
import com.example.demoproject.Entity.EntityIDs.DayAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayAverageCRepository extends JpaRepository<DayAverageCEntity, DayAverageId> {
    DayAverageCEntity findTopByOrderById_YearDescId_MonthDescId_DayDesc();

    DayAverageCEntity findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<DayAverageCEntity> findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(int year, int year1, int month, int month1, int dayOfMonth, int day);
}
