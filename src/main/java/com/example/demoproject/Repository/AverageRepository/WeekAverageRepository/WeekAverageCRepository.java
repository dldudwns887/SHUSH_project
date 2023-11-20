package com.example.demoproject.Repository.AverageRepository.WeekAverageRepository;

import com.example.demoproject.Entity.AverageEntity.WeekAverageEntity.WeekAverageCEntity;
import com.example.demoproject.Entity.EntityIDs.WeekAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekAverageCRepository extends JpaRepository<WeekAverageCEntity, WeekAverageId> {
    WeekAverageCEntity findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();

    List<WeekAverageCEntity> findById_StartYearAndId_StartMonthAndId_StartDay(int year, int value, int dayOfMonth);
}
