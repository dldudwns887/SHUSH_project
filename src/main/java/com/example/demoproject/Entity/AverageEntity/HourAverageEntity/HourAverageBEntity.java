package com.example.demoproject.Entity.AverageEntity.HourAverageEntity;

import com.example.demoproject.Entity.EntityIDs.HourAverageId;
import com.example.demoproject.Entity.EntityInterface.HourAverageInterface;
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
@Entity(name = "BHourAverage")
@Table(name = "hour_average_b")

public class HourAverageBEntity implements HourAverageInterface {
    @EmbeddedId
    private HourAverageId id;
    private double average;

}
