package com.example.demoproject.batch;

import com.example.demoproject.batch.BatchClassFormat.NoisePer10Sec;
import com.example.demoproject.batch.BatchProcessor.NoiseSeqProcessor;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig extends DefaultBatchConfiguration {




    //item reader
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Bean
    public JpaPagingItemReader<NoisePer10Sec> itemReader359(){
        return new JpaPagingItemReaderBuilder<NoisePer10Sec>()
                .name("noiseReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select n from NoisePer10Sec n")
                .pageSize(359)
                .build();
    }

    @Bean
    public JpaPagingItemReader<NoisePer10Sec> itemReader360(){
        return new JpaPagingItemReaderBuilder<NoisePer10Sec>()
                .name("noiseReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select n from NoisePer10Sec n")
                .pageSize(360)
                .build();
    }

    //Item Processor
    @Bean
    public NoiseSeqProcessor processor(){
        return new NoiseSeqProcessor();
    }


}
