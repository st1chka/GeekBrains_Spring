package ru.geekbrains.mai.market.maimarket.error_hendling;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
