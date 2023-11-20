package com.example.demoproject.Repository.AverageRepository.WeekAverageRepository;

import com.example.demoproject.Entity.AverageEntity.WeekAverageEntity.WeekAverageAEntity;
import com.example.demoproject.Entity.EntityIDs.WeekAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekAverageARepository extends JpaRepository<WeekAverageAEntity, WeekAverageId> {
    WeekAverageAEntity findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();

    void findTopByOrderById_StartYearAscId_StartMonthAscId_StartDayAsc();

    List<WeekAverageAEntity> findById_StartYearAndId_StartMonthAndId_StartDay(int year, int value, int dayOfMonth);
}
