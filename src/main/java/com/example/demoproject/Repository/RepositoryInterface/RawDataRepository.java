package com.example.demoproject.Repository.RepositoryInterface;

import com.example.demoproject.Entity.EntityIDs.RawDataId;
import com.example.demoproject.Entity.EntityInterface.RawDataInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawDataRepository extends JpaRepository<RawDataInterface, RawDataId> {
    List<RawDataInterface> findFirstById_YearAndId_MonthAndId_DayAndId_Hour(int id_year, int id_month, int id_day, int id_hour);
    RawDataInterface findTopByOrderById_YearAscId_MonthAscId_DayAscId_HourAsc();

    List<RawDataInterface> findById_YearAndId_MonthAndId_DayAndId_Hour(int recentYear, int recentMonth, int recentDay, int recentHour);
}
