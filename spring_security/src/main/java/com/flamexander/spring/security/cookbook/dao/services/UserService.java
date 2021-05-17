package com.flamexander.spring.security.cookbook.dao.services;

//import com.flamexander.spring.security.cookbook.dao.enities.Role;

//import com.flamexander.spring.security.cookbook.dao.enities.Permissions;
import com.flamexander.spring.security.cookbook.dao.enities.Permission;
import com.flamexander.spring.security.cookbook.dao.enities.User;
import com.flamexander.spring.security.cookbook.dao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Permissions;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public  Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getPermissions()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Permission> permissions) {
        return permissions.stream().map(permission -> new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());
    }
}