package com.example.demoproject.Entity.AverageEntity;

import com.example.demoproject.Entity.EntityIDs.DayAverageId;
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
@Entity(name = "ADayAverage")
@Table(name = "day_average_a")

public class DayAverageAEntity {
    @EmbeddedId
    private DayAverageId id;
    private double average;

}
