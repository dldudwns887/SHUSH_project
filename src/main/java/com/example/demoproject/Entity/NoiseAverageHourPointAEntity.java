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
@Entity(name="NoiseAverageHourPointA")
@Table(name="noise_average_hour_point_a")

public class NoiseAverageHourPointAEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//
    private String date;
    private int hour;
    private double avg;
}