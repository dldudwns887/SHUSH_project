package com.example.demoproject.Service;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Service;

@Service
public class ShushDataService {
    @PersistenceUnit
    private EntityManagerFactory emf;

}
