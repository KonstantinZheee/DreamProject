package com.aston.dream.services;

import java.time.Year;
import com.aston.dream.models.Auto;

public class CarValidator {
    public static final int MIN_POWER = 20;
    public static final int MAX_POWER = 2000;
    public static final int MIN_YEAR = 1886;
    public static final int MAX_YEAR = Year.now().getValue();

    public static boolean validatePower(int power) {
        return MIN_POWER <= power && power <= MAX_POWER;
    }

    public static boolean validateYear(int year) {
        return MIN_YEAR <= year && year <= MAX_YEAR;
    }

    public static boolean validateModel(String model) {
        return model != null &&
                !model.trim().isEmpty() &&
                model.matches("^[a-zA-Zа-яА-Я0-9\\s-]+$");
    }

    public static boolean validateCar(Auto auto) {
        return auto != null &&
                validatePower(auto.getPower()) &&
                validateYear(auto.getYear()) &&
                validateModel(auto.getModel());
    }

    public static String getValidationErrors(Auto auto) {
        if (auto == null) {return "Автомобиль не может быть null";}
        StringBuilder errors = new StringBuilder();

        if (!validatePower((auto.getPower()))) {
            errors.append(String.format("Мощность %d л.с. должна быть в диапазоне %d-%d%n",
                    auto.get.Power(), MIN_POWER, MAX_POWER));
        }

        if (!validateYear((auto.getYear()))) {
            errors.append(String.format("Год %d должен быть в диапазоне %d-%d%n",
                    auto.getYear(), MIN_YEAR, MAX_YEAR));
        }

        if (!validateModel((auto.getModel()))) {
            errors.append(String.format("Модель содержит недопустимые символы%n",
                    auto.getModel()));
        }

        return errors.toString();
    }
}
