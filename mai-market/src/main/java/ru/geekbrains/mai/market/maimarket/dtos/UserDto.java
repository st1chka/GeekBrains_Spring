package ru.geekbrains.mai.market.maimarket.dtos;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
