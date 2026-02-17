package com.aston.dream.controllers;

import com.aston.dream.constants.Constants;
import com.aston.dream.models.Auto;
import com.aston.dream.services.enrichers.Enricher;
import com.aston.dream.services.enrichers.EnricherManual;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private boolean isRunning = true;

    public void start() {
        printWelcomeMessage();

        try (Scanner scanner = new Scanner(System.in)) {
            while (isRunning) {
                try {
                    System.out.print(Constants.MESSAGE_PROMPT);
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.isEmpty()) {
                        continue;
                    }
                    processCommand(input);
                } catch (Exception e) {
                    System.out.printf(Constants.MESSAGE_ERROR + "%n", e.getMessage());
                }
            }
        }
        System.out.println(Constants.MESSAGE_PROGRAM_TERMINATED);
    }

    private void processCommand(String command) {
        switch (command) {
            case Constants.COMMAND_MANUAL:
                System.out.println(Constants.OUTPUT_MANUAL);
                Enricher enricher = new EnricherManual();
                List<Auto> list = enricher.enrich();
                list.forEach(System.out::println);
                break;

            case Constants.COMMAND_RANDOM:
                System.out.println(Constants.OUTPUT_RANDOM);
                break;

            case Constants.COMMAND_FILE:
                System.out.println(Constants.OUTPUT_FILE);
                break;

            case Constants.COMMAND_EXIT:
                System.out.println(Constants.OUTPUT_EXIT);
                isRunning = false;
                break;

            default:
                System.out.printf(Constants.MESSAGE_UNKNOWN_COMMAND + "%n", command);
                System.out.println(Constants.MESSAGE_AVAILABLE_LIST);
                break;
        }
    }

    private void printWelcomeMessage() {
        System.out.println(Constants.MESSAGE_WELCOME);
        System.out.println(Constants.MESSAGE_AVAILABLE_COMMANDS);
        System.out.println(Constants.MESSAGE_MANUAL_DESC);
        System.out.println(Constants.MESSAGE_RANDOM_DESC);
        System.out.println(Constants.MESSAGE_FILE_DESC);
        System.out.println(Constants.MESSAGE_EXIT_DESC);
        System.out.println(Constants.MESSAGE_SEPARATOR);
        System.out.println();
    }
}
