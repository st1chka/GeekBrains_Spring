package ru.geekbrains.mai.market.maimarket.error_hendling;

import java.util.List;

public class InvalidDataException extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public InvalidDataException(List<String> messages) {
        this.messages = messages;
    }
}
