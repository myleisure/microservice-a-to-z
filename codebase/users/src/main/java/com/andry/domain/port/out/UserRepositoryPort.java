package com.andry.domain.port.out;

import com.andry.domain.application.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findById(String id);
    Optional<User> findBYEmail(String email);
    List<User> findAll();
    void persist(User user);
    void update(User user);
    void delete(String userId);
}
