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
@Entity(name="NoiseAverageDailyTest")
@Table(name="noise_Average_test_daily_table")

public class NoiseAverageTestDailyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//
    private String date;
    private double avg;
}