package com.example.demoproject.Entity.RawDataEntity;

import com.example.demoproject.Entity.EntityIDs.RawDataId;
import com.example.demoproject.Entity.EntityInterface.RawDataInterface;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="BRawData")
@Table(name="raw_data_b")

public class RawDataBEntity implements RawDataInterface {
    @EmbeddedId
    private RawDataId id;
    private int dB;


}
