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
    public static final String MESSAGE_SORTED_LIST = "Отсортированный список: ";

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

    public static final int MIN_ARRAY_SIZE = 1;
    public static final int MAX_ARRAY_SIZE = 50;
    public static final String RANDOM_ENRICH_TITLE = "=== Генерация случайных автомобилей ===";
    public static final String RANDOM_ENRICH_CANCELLED = "Генерация отменена";
    public static final String RANDOM_ASK_COUNT = "Сколько автомобилей сгенерировать? (0 - отмена, %d-%d): ";
    public static final String ERROR_INVALID_NUMBER = "Ошибка: введите корректное число";
    public static final String ERROR_SIZE_RANGE = "Ошибка: размер должен быть от %d до %d\n";

    public static final String SAVE_NO_AUTOS_TO_SAVE = "Нет автомобилей для сохранения.";
    public static final String SAVE_ASK_SAVE_STRATEGY = """
            Хотите сохранить все автомобили сразу или сохранять в файл автомобили по одному?
            Введите '1' для сохранения всех или '2' для поштучного выбора:\s""";
    public static final String SAVE_INVALID_SAVE_STRATEGY = "Некорректный выбор стратегии сохранения.";
    public static final String SAVE_AUTOS_SAVED_SUCCESS = "Сохранено %d автомобилей в файл '%s'%n";
    public static final String SAVE_ERROR_SAVING_AUTOS = "Ошибка при сохранении автомобилей: %s%n";
    public static final String SAVE_ENTER_FILE_NAME = "Введите имя файла: ";
    public static final String SAVE_ASK_SAVE_AUTO = "\nАвтомобиль : %s\nСохранить этот автомобиль? (да/нет): ";
    public static final String SAVE_AUTO_SAVED = "Автомобиль сохранен.";
    public static final String SAVE_AUTO_SKIPPED = "Автомобиль НЕ сохранен.";
    public static final String SAVE_INVALID_ANSWER = "Введите \"да\" или \"нет\".";
    public static final String SELECTIVE_SAVE_COMPLETED = "Сохранено %d автомобилей в файл '%s'%n";
    public static final String SAVE_ASK_ABOUT_SAVING = "Хотите сохранить автомобили в файл? (да/нет)";
    public static final String SAVE_CANCELLED = "Сохранение в файл отменено.";

    public static final String SAVE_ALL = "1";
    public static final String SAVE_SELECTIVE = "2";

}
