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
@Entity(name = "CDayAverage")
@Table(name = "day_average_c")

public class DayAverageCEntity {
    @EmbeddedId
    private DayAverageId id;
    private double average;

}
