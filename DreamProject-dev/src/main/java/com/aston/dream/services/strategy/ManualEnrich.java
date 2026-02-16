package com.aston.dream.services.strategy;

import com.aston.dream.models.Auto;

import java.util.List;

public class ManualEnrich implements Enrichable{
    @Override
    public List<Auto> enrich() {
        //ToDo реализовать чтение данных из консоли
        return List.of();

    }
}
