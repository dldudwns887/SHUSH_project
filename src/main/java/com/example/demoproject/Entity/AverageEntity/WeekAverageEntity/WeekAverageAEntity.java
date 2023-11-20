package com.example.demoproject.Entity.AverageEntity.WeekAverageEntity;

import com.example.demoproject.Entity.EntityIDs.WeekAverageId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AWeekAverage")
@Table(name = "week_average_a")

public class WeekAverageAEntity {
    @EmbeddedId
    private WeekAverageId id;

    private int endYear;
    private int endMonth;
    private int endDay;

    private double average;

}
