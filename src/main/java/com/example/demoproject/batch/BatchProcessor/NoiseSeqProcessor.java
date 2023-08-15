package com.example.demoproject.batch.BatchProcessor;


import com.example.demoproject.batch.BatchClassFormat.NoiseDateSeq;
import com.example.demoproject.batch.BatchClassFormat.NoisePer10Sec;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class NoiseSeqProcessor implements ItemProcessor<NoisePer10Sec, NoiseDateSeq> {
    @Override
    public NoiseDateSeq process(NoisePer10Sec item) throws Exception {
        String[] tmp = item.getTime().split(" ");
        return new NoiseDateSeq(tmp[0], Integer.parseInt(tmp[1].substring(0, 2)), item.getdB());
    }
}
