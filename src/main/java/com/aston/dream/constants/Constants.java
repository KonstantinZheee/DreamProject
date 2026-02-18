package com.aston.dream.constants;

public class Constants {
    private Constants(){}

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

    public static final int MIN_ARRAY_SIZE = 1;
    public static final int MAX_ARRAY_SIZE = 50;

    public static final String RANDOM_ENRICH_TITLE = "=== Генерация случайных автомобилей ===";
    public static final String RANDOM_ENRICH_CANCELLED = "Генерация отменена";
    public static final String RANDOM_ASK_COUNT = "Сколько автомобилей сгенерировать? (0 - отмена, %d-%d): ";
    public static final String ERROR_INVALID_NUMBER = "Ошибка: введите корректное число";
    public static final String ERROR_SIZE_RANGE = "Ошибка: размер должен быть от %d до %d\n";
}
