package com.aston.dream.services.strategy;

import com.aston.dream.constants.Constants;
import com.aston.dream.models.Auto;
import com.aston.dream.services.CarValidator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEnrich implements Enrichable {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<Auto> enrich() {
        System.out.print(Constants.FILE_ENTER_FILE_NAME);
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println(Constants.FILE_NO_FILE_NAME);
            return List.of();
        }

        Path path = Path.of(Constants.FILE_DIRECTORY, fileName);

        if (!Files.exists(path)) {
            System.out.printf(Constants.FILE_NOT_FOUND, path);
            return List.of();
        }

        List<Auto> autos = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(path)) {
                String s = line.trim();
                if (s.isEmpty()) continue;
                if (s.equalsIgnoreCase(Constants.FILE_READING_SEQUENCE)) continue;

                String[] parts = s.split(";");
                if (parts.length != 3) continue;

                String model = parts[0].trim();

                int power;
                int year;
                try {
                    power = Integer.parseInt(parts[1].trim());
                    year = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                Auto auto = Auto.builder()
                        .model(model)
                        .power(power)
                        .year(year)
                        .build();

                if (CarValidator.validateCar(auto)) {
                    autos.add(auto);
                }
            }
        } catch (Exception e) {
            return List.of();
        }
        return autos;
    }
}