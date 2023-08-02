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
@Entity(name="FrontEntrance")
@Table(name="front_entrance")

public class FrontEntranceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//
    private String id;
    private int db;
    private String time;



}
