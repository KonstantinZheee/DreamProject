package com.aston.dream.constants;

public class Constants {
    private Constants(){
        throw new UnsupportedOperationException();
    }

    public static final String COMMAND_MANUAL = "manual";
    public static final String COMMAND_RANDOM = "random";
    public static final String COMMAND_FILE = "file";
    public static final String COMMAND_EXIT = "exit";

    public static final String OUTPUT_MANUAL = "manual";
    public static final String OUTPUT_RANDOM = "random";
    public static final String OUTPUT_FILE = "file";
    public static final String OUTPUT_EXIT = "выход";

    public static final String MESSAGE_WELCOME = "=== Консольный контроллер ===";
    public static final String MESSAGE_AVAILABLE_COMMANDS = "Доступные команды:";
    public static final String MESSAGE_MANUAL_DESC = "  'manual' - режим ручного ввода";
    public static final String MESSAGE_RANDOM_DESC = "  'random' - случайный режим";
    public static final String MESSAGE_FILE_DESC = "  'file'   - файловый режим";
    public static final String MESSAGE_EXIT_DESC = "  'exit'   - выход из программы";
    public static final String MESSAGE_SEPARATOR = "==============================";
    public static final String MESSAGE_PROMPT = "> ";
    public static final String MESSAGE_UNKNOWN_COMMAND = "Неизвестная команда: '%s'";
    public static final String MESSAGE_AVAILABLE_LIST = "Доступные команды: manual, random, file, exit";
    public static final String MESSAGE_ERROR = "Ошибка при обработке команды: %s";
    public static final String MESSAGE_PROGRAM_TERMINATED = "Программа завершена.";

    public static final String MANUAL_ASK_CONTINUE = "\nХотите ввести данные автомобиля? (да/нет): ";
    public static final String MESSAGE_NO = "нет";
    public static final String MESSAGE_YES = "да";
    public static final String MANUAL_INPUT_COMPLETED = "Ввод данных завершен.";
    public static final String MANUAL_INVALID_ANSWER = "Пожалуйста, введите 'да' или 'нет'";
    public static final String MANUAL_CAR_ADDED_SUCCESS = "Автомобиль успешно добавлен!";
    public static final String MANUAL_VALIDATION_ERRORS = "Ошибки валидации:";
    public static final String MANUAL_CAR_NOT_ADDED = "Автомобиль не был добавлен. Попробуйте снова.";
    public static final String MANUAL_ASK_MODEL = "\nВведите модель автомобиля: ";
    public static final String MANUAL_INVALID_MODEL = "Некорректная модель. " +
            "Используйте буквы, цифры, пробелы и дефисы.";
    public static final String MANUAL_ASK_POWER = "\nВведите мощность автомобиля (л.с.) от %d до %d: ";
    public static final String MANUAL_INVALID_POWER = "Мощность должна быть в диапазоне от %d до %d";
    public static final String MANUAL_INVALID_NUMBER = "Пожалуйста, введите целое число";
    public static final String MANUAL_ASK_YEAR = "\nВведите год выпуска от %d до %d: ";
    public static final String MANUAL_INVALID_YEAR = "Год должен быть в диапазоне от %d до %d";

}
