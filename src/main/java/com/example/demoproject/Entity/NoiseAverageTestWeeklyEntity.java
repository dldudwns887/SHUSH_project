package com.example.demoproject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="NoiseAverageWeeklyTest")
@Table(name="noise_Average_test_weekly_table")

public class NoiseAverageTestWeeklyEntity {
    @Id
    private String startDate;
    private String endDate;
    private double avg;
}