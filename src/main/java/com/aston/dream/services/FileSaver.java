package com.aston.dream.services;

import com.aston.dream.constants.Constants;
import com.aston.dream.models.Auto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileSaver {

    private final Scanner scanner;
    private String filename;

    public FileSaver() {
        this.scanner = new Scanner(System.in);
    }

    private void saveAutos(final List<Auto> autos) {
        if (!autos.isEmpty()) {
            System.out.println(Constants.SAVE_ENTER_FILE_NAME);
            this.filename = Paths.get(".files", scanner.nextLine().trim().toLowerCase()).toString();
            System.out.println(Constants.SAVE_ASK_SAVE_STRATEGY);
            String answer = scanner.nextLine().trim().toLowerCase();
            switch (answer) {
                case Constants.SAVE_ALL:
                    saveAllAutos(autos, filename);
                    break;
                case Constants.SAVE_SELECTIVE:
                    saveSelective(autos, filename);
                    break;
                default:
                    System.out.println(Constants.SAVE_INVALID_SAVE_STRATEGY);
            }
        }
    }

     public void saveToFile(final List<Auto> autos){
        System.out.println(Constants.SAVE_ASK_ABOUT_SAVING);
        String answerAboutSaving = scanner.nextLine().trim().toLowerCase();
        if (answerAboutSaving.equals(Constants.MESSAGE_NO)) {
            System.out.println(Constants.SAVE_CANCELLED);
            return;
        }
        if (!answerAboutSaving.equals(Constants.MESSAGE_YES)){
            System.out.println(Constants.SAVE_INVALID_ANSWER);
            saveToFile(autos);
        } else {
            saveAutos(autos);
        }
    }

    private void saveAllAutos(final List<Auto> autos, final String filename) {
        try {
            createDirectoryIfNotExists(filename);
            clearFile(filename);
            for (Auto auto : autos) {
                appendAutoToFile(auto);
            }
            System.out.flush();
            System.out.printf(Constants.SAVE_AUTOS_SAVED_SUCCESS, autos.size(), filename);
        } catch (IOException e) {
            System.err.printf(Constants.SAVE_ERROR_SAVING_AUTOS, e.getMessage());
        }
    }

    private void saveSelective( final List<Auto> autos, final String filename) {
        try {
            createDirectoryIfNotExists(filename);
            clearFile(filename);
            int savedCount = 0;
            for (int i = 0; i < autos.size(); i++) {
                Auto auto = autos.get(i);
                System.out.printf(Constants.SAVE_ASK_SAVE_AUTO, auto.toString());
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals(Constants.MESSAGE_YES)) {
                    appendAutoToFile(auto);
                    savedCount++;
                    System.out.println(Constants.SAVE_AUTO_SAVED);
                } else if (answer.equals(Constants.MESSAGE_NO)) {
                    System.out.println(Constants.SAVE_AUTO_SKIPPED);
                } else {
                    System.out.println(Constants.SAVE_INVALID_ANSWER);
                    i--;
                }
            }
            System.out.flush();
            System.out.printf(Constants.SELECTIVE_SAVE_COMPLETED, savedCount, filename);
        } catch (IOException e) {
            System.err.printf(Constants.SAVE_ERROR_SAVING_AUTOS, e.getMessage());
        }
    }

    private void createDirectoryIfNotExists(final String filename) throws IOException {
        Path path = Paths.get(filename);
        Path parentDir = path.getParent();
        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }
    }

    private void clearFile(final String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.write(path, new byte[0]);
    }

    private void appendAutoToFile(Auto auto) throws IOException {
        Path path = Paths.get(filename);
        Files.writeString(path, auto.toString() + System.lineSeparator(),
                StandardOpenOption.APPEND);
    }
}