package com.aston.dream.services.strategy;

import com.aston.dream.models.Auto;

import java.util.List;

public class RandomEnrich implements Enrichable{
    @Override
    public List<Auto> enrich() {
        //ToDo реализовать рандомное автоматическое заполнение коллекции
        return List.of();
    }
}
