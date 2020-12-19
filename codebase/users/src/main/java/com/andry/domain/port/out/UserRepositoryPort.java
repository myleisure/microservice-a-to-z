package com.andry.domain.port.out;

import com.andry.domain.application.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    List<User> findAll();
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);
    User update(User user);
    User persist(User user);
    void delete(String id);
}
