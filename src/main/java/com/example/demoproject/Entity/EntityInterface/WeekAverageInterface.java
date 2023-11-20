package com.example.demoproject.Entity.EntityInterface;

import com.example.demoproject.Entity.EntityIDs.WeekAverageId;

public interface WeekAverageInterface {

    void setId(WeekAverageId id);
    void setEndYear(int endYear);
    void setEndMonth(int endMonth);
    void setEndDay(int EndDay);
    void setAverage(double average);

    WeekAverageId getId();
    int getEndYear();
    int getEndMonth();
    int getEndDay();
    double getAverage();
}
