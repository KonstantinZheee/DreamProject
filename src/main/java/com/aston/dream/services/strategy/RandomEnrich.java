package com.aston.dream.services.strategy;

import com.aston.dream.constants.Constants;
import com.aston.dream.models.Auto;
import com.aston.dream.services.CarValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomEnrich implements Enrichable{
    private static final Random random = new Random();
    private static final String[] MODELS = {
           "Toyota", "Honda", "Nissan", "Mazda", "Subaru", "Mitsubishi", "Suzuki", "Lexus",
            "BMW", "Audi", "Mercedes-Benz", "Volkswagen", "Porsche", "Opel", "Ford", "Chevrolet", "Dodge", "Chrysler",
            "Jeep", "Cadillac", "Lincoln", "Tesla", "Hyundai", "Kia", "Renault", "Peugeot", "Citroen", "Fiat",
            "Ferrari", "Lamborghini", "Maserati", "Alfa Romeo", "Jaguar", "Land Rover", "Bentley", "Rolls-Royce",
            "Aston Martin", "Volvo", "Saab", "Geely", "BYD", "Chery", "Great Wall", "Haval", "XPeng", "Li Auto",
            "Skoda", "Lada", "GAZ", "UAZ", "Moskvich",
    };

    private final Scanner scanner;

    public RandomEnrich() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public List<Auto> enrich() {
        List<Auto> autos = new ArrayList<>();
        System.out.println(Constants.RANDOM_ENRICH_TITLE);

        int count = askCount();
        if (count <= 0) {
            System.out.println(Constants.RANDOM_ENRICH_CANCELLED);
            return autos;
        }

        for (int i = 0; i < count; i++) {
            Auto auto = generateRandom();

            if (CarValidator.validateCar(auto)) {
                autos.add(auto);
            } else {
                i--;
            }
        }
        return autos;
    }

    private int askCount() {
        while (true) {
            System.out.printf(Constants.RANDOM_ASK_COUNT, Constants.MIN_ARRAY_SIZE, Constants.MAX_ARRAY_SIZE);

            try {
                int count = Integer.parseInt(scanner.nextLine().trim());
                if (count == 0) {
                    return 0;
                }

                if (Constants.MIN_ARRAY_SIZE <= count && count <= Constants.MAX_ARRAY_SIZE) {
                    return count;
                }

                System.out.printf(Constants.ERROR_SIZE_RANGE,
                        Constants.MIN_ARRAY_SIZE, Constants.MAX_ARRAY_SIZE);
            } catch (NumberFormatException e) {
                System.out.println(Constants.ERROR_INVALID_NUMBER);
            }
        }
    }

    private Auto generateRandom() {
        int power = CarValidator.MIN_POWER + random.nextInt(CarValidator.MAX_POWER - CarValidator.MIN_POWER + 1);
        int year = CarValidator.MIN_YEAR + random.nextInt(CarValidator.MAX_YEAR - CarValidator.MIN_YEAR + 1);
        String model = MODELS[random.nextInt(MODELS.length)];

        return Auto.builder()
                .power(power)
                .year(year)
                .model(model)
                .build();
    }
}
