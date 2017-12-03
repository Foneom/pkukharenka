package ru.job4j.start.tracker;

import ru.job4j.start.tracker.io.ConsoleInput;
import ru.job4j.start.tracker.io.Input;

/**
 * Класс содержит в себе методы для взаимодействия с пользователем.
 *
 * @author Pyotr Kukharenka
 * @since 01.12.2017
 */

public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private Input input;
    /**
     * Хранилище заявок пользователя.
     */
    private Tracker tracker;


    /**
     * Конуструктор для инициализации программы.
     *
     * @param input   - система ввода/вывода.
     * @param tracker - хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean flag = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fill();
        while (!flag) {
            menu.showMenu();
            flag = menu.select();
        }
    }

    /**
     * Запуск программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}