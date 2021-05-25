package ru.geekbrains.mai.market.maimarket.conrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.mai.market.maimarket.dtos.RegistrationUserDto;
import ru.geekbrains.mai.market.maimarket.dtos.UserDto;
import ru.geekbrains.mai.market.maimarket.error_hendling.ResourceNotFoundException;

import ru.geekbrains.mai.market.maimarket.models.User;
import ru.geekbrains.mai.market.maimarket.repositories.UserRepository;
import ru.geekbrains.mai.market.maimarket.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/me")
    public UserDto getCurrentUsername(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        return new UserDto(currentUser.getUsername(), currentUser.getEmail());
    }

    @PostMapping("/register")
    public RegistrationUserDto addUser(@RequestBody RegistrationUserDto registrationUserDto){
        registrationUserDto.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        return userService.createNewUser(registrationUserDto);
    }
}
