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
@Entity(name="NoiseAveragetest")
@Table(name="noise_Average_test_table")

public class NoiseAverageTestEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//
    private String date;
    private int hour;
    private double avg;
}