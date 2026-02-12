package com.aston.dream.services.enrichers;

import com.aston.dream.services.strategy.FileEnrich;

public class EnricherFile extends Enricher{
    public EnricherFile() {
        super(new FileEnrich());
    }
}
