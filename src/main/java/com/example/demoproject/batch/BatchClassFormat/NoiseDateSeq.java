package com.example.demoproject.batch.BatchClassFormat;

public class NoiseDateSeq {

    private String date;
    private int hour;
    private int dB;

    public NoiseDateSeq(){}

    public NoiseDateSeq(String date, int hour, int dB){
        this.date = date;
        this.hour = hour;
        this.dB = dB;
    }

    public int getdB() {
        return dB;
    }

    public int getHour() {
        return hour;
    }

    public String getDate() {
        return date;
    }
}
