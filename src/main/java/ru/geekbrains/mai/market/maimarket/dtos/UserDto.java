package ru.geekbrains.mai.market.maimarket.dtos;

import lombok.Data;
import ru.geekbrains.mai.market.maimarket.models.User;


@Data
public class UserDto extends User {
    private String username;
    private String email;

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
