package com.example.demoproject.batch.BatchClassFormat;

public class NoisePer1HourAverage {
    private static double averageNoise;
    private int year;
    private int month;
    private int day;
    private int hour;

    public NoisePer1HourAverage(){
    }

    public NoisePer1HourAverage(double averageNoise, int year, int month, int day, int hour){
        this.averageNoise = averageNoise;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }

}
