package com.example.demoproject.batch;

import com.example.demoproject.batch.BatchClassFormat.NoisePer10Sec;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig extends DefaultBatchConfiguration {


    //item reader
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    //to redo a branch
    @Bean
    public JpaPagingItemReader<NoisePer10Sec> itemReader(){
        return new JpaPagingItemReaderBuilder<NoisePer10Sec>()
                .name("noiseReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select n from NoisePer10Sec n")
                .pageSize(8639)
                .build();
    }


}
