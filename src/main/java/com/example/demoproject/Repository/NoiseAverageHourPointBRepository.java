package com.example.demoproject.Repository;

import com.example.demoproject.Entity.NoiseAverageHourPointBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseAverageHourPointBRepository extends JpaRepository<NoiseAverageHourPointBEntity, String> {
}
