package com.example.demoproject.Repository.AverageRepository;
import com.example.demoproject.Entity.AverageEntity.WeekAverageBEntity;
import com.example.demoproject.Entity.EntityIDs.WeekAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekAverageBRepository extends JpaRepository<WeekAverageBEntity, WeekAverageId> {
    WeekAverageBEntity findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();

    List<WeekAverageBEntity> findById_StartYearAndId_StartMonthAndId_StartDay(int year, int value, int dayOfMonth);
}
