package com.example.demoproject.Entity.EntityInterface;

import com.example.demoproject.Entity.EntityIDs.DayAverageId;



public interface DayAverageInterface {
    void setId(DayAverageId id);
    DayAverageId getId();
    void setAverage(double average);
    double getAverage();
}
