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