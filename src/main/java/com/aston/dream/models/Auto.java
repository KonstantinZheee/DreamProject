package com.aston.dream.models;

import java.util.Comparator;
import java.util.Objects;

public class Auto implements Comparable<Auto> {

    private final int power;
    private final String model;
    private final int year;

    public Auto(String brand, int year) {
        this(0, brand, year);
    }

    public Auto(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer power;
        private String model;
        private Integer year;

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Auto build() {
            if (power == null) throw new IllegalStateException("Мощность");
            if (model == null || model.trim().isEmpty()) throw new IllegalStateException("Модель");
            if (year == null) throw new IllegalStateException("Год выпуска");
            return new Auto(power, model, year);
        }
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return model;
    }

    @Override
    public int compareTo(Auto other) {
        return Comparator.comparing(Auto::getModel)
                .thenComparing(Auto::getYear)
                .thenComparing(Auto::getPower)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return String.format("Автомобиль: %s, мощность: %d, год выпуска: %d.",model, power, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto auto = (Auto) o;
        return power == auto.power && year == auto.year && Objects.equals(model, auto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, model, year);
    }
}

