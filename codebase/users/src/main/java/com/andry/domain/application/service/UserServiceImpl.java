package com.andry.domain.application.service;

import com.andry.domain.application.exception.UserNotFoundException;
import com.andry.domain.application.model.User;
import com.andry.domain.port.in.UserServicePort;
import com.andry.domain.port.out.UserRepositoryPort;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    public UserServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepositoryPort.findAll();
    }

    @Override
    public User getUserById(String id) {
        return this.userRepositoryPort.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " is not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " cannot be found"));
    }

    @Override
    public User addUser(User user) {
        user.setLastUpdate(new Date());
        return this.userRepositoryPort.persist(user);
    }

    @Override
    public User editUser(User user) {
        user.setLastUpdate(new Date());
        return this.userRepositoryPort.update(user);
    }

    @Override
    public void deleteUser(String userId) {
        this.userRepositoryPort.delete(userId);
    }

}
