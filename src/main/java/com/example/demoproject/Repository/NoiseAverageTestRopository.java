package com.example.demoproject.Repository;

import com.example.demoproject.Entity.NoiseAverageTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoiseAverageTestRopository extends JpaRepository<NoiseAverageTestEntity, String> {
}
