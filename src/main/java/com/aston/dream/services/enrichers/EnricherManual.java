package com.aston.dream.services.enrichers;

import com.aston.dream.services.strategy.ManualEnrich;

public class EnricherManual extends Enricher{
    public EnricherManual(){
        super(new ManualEnrich());
    }
}
