package com.example.demoproject.Entity.AverageEntity.DayAverageEntity;

import com.example.demoproject.Entity.EntityIDs.DayAverageId;
import com.example.demoproject.Entity.EntityInterface.DayAverageInterface;
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
@Entity(name = "CDayAverage")
@Table(name = "day_average_c")

public class DayAverageCEntity implements DayAverageInterface {
    @EmbeddedId
    private DayAverageId id;
    private double average;

}
