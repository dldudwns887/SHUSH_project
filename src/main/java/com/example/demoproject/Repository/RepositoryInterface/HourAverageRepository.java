package com.example.demoproject.Repository.RepositoryInterface;

import com.example.demoproject.Entity.EntityIDs.HourAverageId;
import com.example.demoproject.Entity.EntityInterface.HourAverageInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HourAverageRepository extends JpaRepository<HourAverageInterface, HourAverageId> {
    HourAverageInterface findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();

    HourAverageInterface findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<HourAverageInterface> findById_YearAndId_MonthAndId_Day(int id_year, int id_month, int id_day);

}
