package com.aston.dream.services.strategy;

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
        System.out.print("Введите имя файла из папки .files: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("Имя файла не введено");
            return List.of();
        }

        Path path = Path.of(".files", fileName);

        if (!Files.exists(path)) {
            System.out.println("Файл не найден: " + path);
            return List.of();
        }

        List<Auto> autos = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(path)) {
                String s = line.trim();
                if (s.isEmpty()) continue;
                if (s.equalsIgnoreCase("model;power;year")) continue;

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