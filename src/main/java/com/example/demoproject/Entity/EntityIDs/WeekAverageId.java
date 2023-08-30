package com.example.demoproject.Entity.EntityIDs;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class WeekAverageId implements Serializable {
    private int startYear;
    private int startMonth;
    private int startDay;
    private char a;

}
