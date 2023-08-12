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
@Entity(name="BEntrance")
@Table(name="b")

public class BEntranceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//
    private String seq;
    private int dB;
    private String time;
    private char pointA;



}
