package com.example.demoproject.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HourlyAverageId implements Serializable {
    private String date;
    private int hour;

}
