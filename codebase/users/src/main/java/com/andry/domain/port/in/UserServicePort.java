package com.andry.domain.port.in;

import com.andry.domain.application.exception.UserNotFoundException;
import com.andry.domain.application.model.User;

import java.util.List;

public interface UserServicePort {
    User getUserById(String id) throws UserNotFoundException;
    User getUserByEmail(String email) throws UserNotFoundException;
    void delete(String userId) throws UserNotFoundException;
    void add(User user);
    void edit(User user);
    List<User> getAllUsers();
}
