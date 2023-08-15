package com.example.demoproject.Repository;


import com.example.demoproject.Entity.NoiseAverageTestDailyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseAverageTestDailyRepository extends JpaRepository<NoiseAverageTestDailyEntity, String> {
}
