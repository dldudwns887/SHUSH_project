package com.example.demoproject.Repository.RawDataRepository;

import com.example.demoproject.Entity.EntityIDs.RawDataId;
import com.example.demoproject.Entity.RawDataEntity.RawDataAEntity;
import com.example.demoproject.Entity.RawDataEntity.RawDataBEntity;
import com.example.demoproject.Entity.RawDataEntity.RawDataCEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RawDataCRepository extends JpaRepository<RawDataCEntity, RawDataId> {
    List<RawDataCEntity> findFirstById_YearAndId_MonthAndId_DayAndId_Hour(int id_year, int id_month, int id_day, int id_hour);
    RawDataCEntity findTopByOrderById_YearAscId_MonthAscId_DayAscId_HourAsc();

    List<RawDataCEntity> findById_YearAndId_MonthAndId_DayAndId_Hour(int recentYear, int recentMonth, int recentDay, int recentHour);

    boolean existsById_YearAndId_month(int recentYear, int recentMonth);
}
