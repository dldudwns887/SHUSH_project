package com.example.demoproject.Repository;

import com.example.demoproject.Entity.NoiseAverageHourPointCEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseAverageHourPointCRepository extends JpaRepository<NoiseAverageHourPointCEntity, String> {
}
