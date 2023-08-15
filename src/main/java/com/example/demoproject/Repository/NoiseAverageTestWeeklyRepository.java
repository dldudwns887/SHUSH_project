package com.example.demoproject.Repository;

import com.example.demoproject.Entity.NoiseAverageTestWeeklyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseAverageTestWeeklyRepository extends JpaRepository<NoiseAverageTestWeeklyEntity, String> {
}
