package com.example.demoproject.Entity.EntityInterface;

import com.example.demoproject.Entity.EntityIDs.RawDataId;

public interface RawDataInterface {

    void setId(RawDataId id);
    RawDataId getId();
    void setDB(int dB);
    int getDB();

}
