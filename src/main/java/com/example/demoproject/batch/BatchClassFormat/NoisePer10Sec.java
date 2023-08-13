package com.example.demoproject.batch.BatchClassFormat;

import org.springframework.web.bind.annotation.GetMapping;

public class NoisePer10Sec {
    private String seq;
    private int dB;
    private String time;
    private char pointA;

    public NoisePer10Sec(){}

    public NoisePer10Sec(String time, int dB, String seq, char pointA){
        this.time = time;
        this.dB =dB;
        this.seq = seq;
        this.pointA = pointA;
    }

    public String getSeq() {
        return seq;
    }

    public char getPointA() {
        return pointA;
    }

    public int getdB() {
        return dB;
    }

    public String getTime() {
        return time;
    }
}
