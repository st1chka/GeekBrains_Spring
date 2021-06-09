package ru.geekbrains.mai.market.maimarket.dtos;


import lombok.Data;
import ru.geekbrains.mai.market.maimarket.models.User;


@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String email;

    public RegistrationUserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
//
//    public RegistrationUserDto(User user) {
//    }
}
