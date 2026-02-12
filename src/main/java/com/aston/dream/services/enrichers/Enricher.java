package com.aston.dream.services.enrichers;

import com.aston.dream.models.Auto;
import com.aston.dream.services.strategy.Enrichable;

import java.util.List;

public class Enricher {
    Enrichable enrichable;

    public Enricher(Enrichable enrichable) {
        this.enrichable = enrichable;
    }
    public List<Auto> enrich(){
        return enrichable.enrich();
    }
}
