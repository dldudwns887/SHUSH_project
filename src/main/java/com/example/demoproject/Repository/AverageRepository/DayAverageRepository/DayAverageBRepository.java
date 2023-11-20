package com.example.demoproject.Repository.AverageRepository.DayAverageRepository;

import com.example.demoproject.Entity.AverageEntity.DayAverageEntity.DayAverageBEntity;
import com.example.demoproject.Entity.EntityIDs.DayAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayAverageBRepository extends JpaRepository<DayAverageBEntity, DayAverageId> {
    DayAverageBEntity findTopByOrderById_YearDescId_MonthDescId_DayDesc();

    DayAverageBEntity findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<DayAverageBEntity> findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(int year, int year1, int month, int month1, int dayOfMonth, int day);
    List<DayAverageBEntity> findById_YearAndId_MonthAndId_DayGreaterThanEqual(int year, int month, int day);
    List<DayAverageBEntity> findById_YearAndId_MonthAndId_DayLessThanEqual(int year, int month, int day);
}
