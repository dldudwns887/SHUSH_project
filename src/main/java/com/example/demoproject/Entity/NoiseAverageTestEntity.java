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
@Entity(name="NoiseAverageTest")
@Table(name="noise_Average_test_table")

public class NoiseAverageTestEntity {
   @EmbeddedId
   private HourlyAverageId Id;
    private double avg;

    public void setDate(String date){
        this.Id.setDate(date);
    }
    public void setHour(int hour){
        this.Id.setHour(hour);
    }
    public String getDate(){
        return this.Id.getDate();
    }
    public int getHour(){
        return this.Id.getHour();
    }

}