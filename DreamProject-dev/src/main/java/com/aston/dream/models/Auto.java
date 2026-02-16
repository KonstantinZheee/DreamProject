package com.aston.dream.models;

public class Auto implements Comparable<Auto> {

    private String brand;
    private int year;

    public Auto(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public int compareTo(Auto other) {
        return Integer.compare(this.year, other.year);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //ToDo Реализовать класс с использованием Паттерна Builder
}
