package com.example.demoproject.Repository.RawDataRepository;

import com.example.demoproject.Entity.EntityIDs.RawDataId;
import com.example.demoproject.Entity.RawDataEntity.RawDataAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RawDataARepository extends JpaRepository<RawDataAEntity, RawDataId> {
     List<RawDataAEntity> findFirstById_YearAndId_MonthAndId_DayAndId_Hour(int id_year, int id_month, int id_day, int id_hour);
     RawDataAEntity findTopByOrderById_YearAscId_MonthAscId_DayAscId_HourAsc();

     List<RawDataAEntity> findById_YearAndId_MonthAndId_DayAndId_Hour(int recentYear, int recentMonth, int recentDay, int recentHour);
}
