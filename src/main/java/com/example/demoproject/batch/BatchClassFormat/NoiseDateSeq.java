package com.example.demoproject.batch.BatchClassFormat;

public class NoiseDateSeq {

    private int year;
    private int month;
    private int date;
    private char pointA;
    private int seq;
    private int dB;

    public NoiseDateSeq(){}

    public NoiseDateSeq( int year, int month, int date, char pointA, int seq, int dB){
        this.year = year;
        this.month =month;
        this.date = date;
        this.seq = seq;
        this.pointA = pointA;
        this.dB = dB;
    }

    public int getdB() {
        return dB;
    }

    public char getPointA() {
        return pointA;
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getSeq() {
        return seq;
    }

    public int getYear() {
        return year;
    }
}
