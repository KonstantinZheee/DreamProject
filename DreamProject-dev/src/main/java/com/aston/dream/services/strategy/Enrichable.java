package com.aston.dream.services.strategy;

import com.aston.dream.models.Auto;

import java.util.List;

public interface Enrichable {
    public List<Auto> enrich();
}
