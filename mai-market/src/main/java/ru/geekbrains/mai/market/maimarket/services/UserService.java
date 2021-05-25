package ru.geekbrains.mai.market.maimarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.mai.market.maimarket.dtos.ProductDto;
import ru.geekbrains.mai.market.maimarket.dtos.RegistrationUserDto;
import ru.geekbrains.mai.market.maimarket.dtos.UserDto;
import ru.geekbrains.mai.market.maimarket.error_hendling.ResourceNotFoundException;
import ru.geekbrains.mai.market.maimarket.models.Category;
import ru.geekbrains.mai.market.maimarket.models.Product;
import ru.geekbrains.mai.market.maimarket.models.Role;
import ru.geekbrains.mai.market.maimarket.models.User;
import ru.geekbrains.mai.market.maimarket.repositories.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
//    private final UserDto userDto;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Transactional
    public RegistrationUserDto createNewUser (RegistrationUserDto registrationUserDto) {
        User user = new User();
        user.setUsername(registrationUserDto.getUsername());
        user.setPassword(registrationUserDto.getPassword());
        user.setEmail(registrationUserDto.getEmail());
        userRepository.save(user);
        return new RegistrationUserDto(user.getUsername(),user.getPassword(),user.getEmail());
    }


}