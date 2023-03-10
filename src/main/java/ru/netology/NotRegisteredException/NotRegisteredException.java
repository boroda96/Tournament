package ru.netology.NotRegisteredException;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок " + name + " не найден!");
    }

}
