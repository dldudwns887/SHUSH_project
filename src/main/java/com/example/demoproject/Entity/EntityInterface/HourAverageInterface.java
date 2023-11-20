package com.example.demoproject.Entity.EntityInterface;

import com.example.demoproject.Entity.EntityIDs.HourAverageId;

public interface HourAverageInterface {
    void setId(HourAverageId id);
    HourAverageId getId();
    void setAverage(double Average);
    double getAverage();
}
