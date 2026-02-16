package com.aston.dream.services.enrichers;

import com.aston.dream.services.strategy.RandomEnrich;

public class EnricherRandom extends Enricher{
    public EnricherRandom(){
        super(new RandomEnrich());
    }
}
