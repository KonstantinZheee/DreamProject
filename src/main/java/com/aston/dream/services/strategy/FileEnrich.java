package com.aston.dream.services.strategy;

import com.aston.dream.models.Auto;

import java.util.List;

public class FileEnrich implements Enrichable{
    @Override
    public List<Auto> enrich() {
        //ToDo реализовать чтение данных из файла
        return List.of();
    }
}
