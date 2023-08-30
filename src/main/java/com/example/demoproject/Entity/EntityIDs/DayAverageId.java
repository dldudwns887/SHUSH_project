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
public class DayAverageId implements Serializable {
    private int year;
    private int month;
    private int day;
    private char a;

}
