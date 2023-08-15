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
@Entity(name="NoiseAverageHourPointB")
@Table(name="noise_average_hour_point_b")

public class NoiseAverageHourPointBEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//
    private String date;
    private int hour;
    private double avg;
}