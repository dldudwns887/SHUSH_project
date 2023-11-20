package com.example.demoproject.Repository.RepositoryInterface;


import com.example.demoproject.Entity.EntityIDs.WeekAverageId;
import com.example.demoproject.Entity.EntityInterface.WeekAverageInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeekAverageRepository extends JpaRepository<WeekAverageInterface, WeekAverageId> {
    WeekAverageInterface findTopByOrderById_StartYearDescId_StartMonthDescId_StartDayDesc();

    void findTopByOrderById_StartYearAscId_StartMonthAscId_StartDayAsc();

    List<WeekAverageInterface> findById_StartYearAndId_StartMonthAndId_StartDay(int year, int value, int dayOfMonth);
}

