package com.example.demoproject.Repository;

import com.example.demoproject.Entity.NoiseAverageHourPointAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseAverageHourPointARepository extends JpaRepository<NoiseAverageHourPointAEntity, String> {
}
