package com.example.demoproject.Repository.AverageRepository.HourAverageRepository;
import com.example.demoproject.Entity.AverageEntity.HourAverageEntity.HourAverageAEntity;
import com.example.demoproject.Entity.EntityIDs.HourAverageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourAverageARepository extends JpaRepository<HourAverageAEntity, HourAverageId> {
    HourAverageAEntity findTopByOrderById_YearDescId_MonthDescId_DayDescId_HourDesc();

    HourAverageAEntity findTopByOrderById_YearAscId_MonthAscId_DayAsc();

    List<HourAverageAEntity> findById_YearAndId_MonthAndId_Day(int id_year, int id_month, int id_day);

    boolean existsById_YearAndId_month(int recentYear, int recentMonth);
}
