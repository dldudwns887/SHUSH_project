package com.example.demoproject.Repository;

import com.example.demoproject.Entity.NoiseAverageTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseAverageTestRepository extends JpaRepository<NoiseAverageTestEntity, String> {
}
