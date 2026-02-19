package com.aston.dream.services.strategy;

import com.aston.dream.constants.Constants;
import com.aston.dream.models.Auto;
import com.aston.dream.services.CarValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualEnrich implements Enrichable{

    private final Scanner scanner;

    public ManualEnrich() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public List<Auto> enrich() {
        List<Auto> autos = new ArrayList<>();
        while (true) {
            System.out.print(Constants.MANUAL_ASK_CONTINUE);
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals(Constants.MESSAGE_NO)) {
                System.out.println(Constants.MANUAL_INPUT_COMPLETED);
                break;
            }
            if (!answer.equals(Constants.MESSAGE_YES)) {
                System.out.println(Constants.MANUAL_INVALID_ANSWER);
                continue;
            }
            Auto auto = inputAuto();
            if (CarValidator.validateCar(auto)) {
                autos.add(auto);
                System.out.println(Constants.MANUAL_CAR_ADDED_SUCCESS);
            } else {
                String errors = CarValidator.getValidationErrors(auto);
                System.out.println(Constants.MANUAL_VALIDATION_ERRORS);
                System.out.println(errors);
                System.out.println(Constants.MANUAL_CAR_NOT_ADDED);
            }
        }
        return autos;
    }

    private final Auto inputAuto() {
        Auto.Builder builder = Auto.builder();
        String model = inputModel();
        builder.model(model);
        int power = inputPower();
        builder.power(power);
        int year = inputYear();
        builder.year(year);
        return builder.build();
    }

    private final String inputModel() {
        while (true) {
            System.out.print(Constants.MANUAL_ASK_MODEL);
            String model = scanner.nextLine().trim();
            if (CarValidator.validateModel(model)) {
                return model;
            } else {
                System.out.println(Constants.MANUAL_INVALID_MODEL);
            }
        }
    }

    private final int inputPower() {
        while (true) {
            System.out.printf(Constants.MANUAL_ASK_POWER, CarValidator.MIN_POWER, CarValidator.MAX_POWER);
            try {
                int power = Integer.parseInt(scanner.nextLine().trim());
                if (CarValidator.validatePower(power)) {
                    return power;
                } else {
                    System.out.printf(Constants.MANUAL_INVALID_POWER, CarValidator.MIN_POWER, CarValidator.MAX_POWER);
                }
            } catch (NumberFormatException _) {
                System.out.println(Constants.MANUAL_INVALID_NUMBER);
            }
        }
    }

    private final int inputYear() {
        while (true) {
            System.out.printf(Constants.MANUAL_ASK_YEAR, CarValidator.MIN_YEAR, CarValidator.MAX_YEAR);
            try {
                int year = Integer.parseInt(scanner.nextLine().trim());
                if (CarValidator.validateYear(year)) {
                    return year;
                } else {
                    System.out.printf(Constants.MANUAL_INVALID_YEAR, CarValidator.MIN_YEAR, CarValidator.MAX_YEAR);
                }
            } catch (NumberFormatException _) {
                System.out.println(Constants.MANUAL_INVALID_NUMBER);
            }
        }
    }



}
