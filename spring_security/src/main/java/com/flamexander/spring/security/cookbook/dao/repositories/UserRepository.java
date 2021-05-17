package com.flamexander.spring.security.cookbook.dao.repositories;

import com.flamexander.spring.security.cookbook.dao.enities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
