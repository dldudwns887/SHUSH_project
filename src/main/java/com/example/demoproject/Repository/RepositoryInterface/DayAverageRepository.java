package com.example.demoproject.Repository.RepositoryInterface;

import com.example.demoproject.Entity.EntityIDs.DayAverageId;
import com.example.demoproject.Entity.EntityInterface.DayAverageInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayAverageRepository extends JpaRepository<DayAverageInterface, DayAverageId> {
    DayAverageInterface findTopByOrderById_YearDescId_MonthDescId_DayDesc();

    DayAverageInterface findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<DayAverageInterface> findById_YearBetweenAndId_MonthBetweenAndId_DayBetween(int year, int year1, int month, int month1, int dayOfMonth, int day);
}
