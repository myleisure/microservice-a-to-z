package com.andry.domain.port.in;

import com.andry.domain.application.model.User;

import java.util.List;

public interface UserServicePort {
    List<User> getAllUsers();
    User getUserById(String id);
    User getUserByEmail(String email);
    User addUser(User user);
    User editUser(User user);
    void deleteUser(String userId);
}
