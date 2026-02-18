package com.aston.dream.services;

import com.aston.dream.constants.Constants;
import com.aston.dream.models.Auto;

import java.util.List;
import java.util.Scanner;

public class FileSaver {

    private final Scanner scanner;
    private final String filename;

    public FileSaver(String filename) {
        this.scanner = new Scanner(System.in);
        this.filename = filename;
    }

    public void saveAutos(List<Auto> autos) {
        if (autos == null || autos.isEmpty()) {
            System.out.println(Constants.SAVE_NO_AUTOS_TO_SAVE);
        } else {
            System.out.println(Constants.SAVE_ASK_SAVE_STRATEGY);
            String answer = scanner.nextLine().trim().toLowerCase();
            switch (answer) {
                case Constants.SAVE_ALL:
                    saveAllAutos(autos);
                case Constants.SAVE_SELECTIVE:
                    saveSelective(autos);
                default:
                    System.out.println(Constants.SAVE_INVALID_SAVE_STRATEGY);
            }
        }
    }


}