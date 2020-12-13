package com.andry.domain.application.service;

import com.andry.domain.application.exception.UserNotFoundException;
import com.andry.domain.application.model.User;
import com.andry.domain.port.in.UserServicePort;
import com.andry.domain.port.out.UserRepositoryPort;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.List;

@ApplicationScoped
@SuppressWarnings("unused")
public class UserServiceImpl implements UserServicePort {

    private final UserRepositoryPort repositoryPort;

    public UserServiceImpl(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public User getUserById(String id) throws UserNotFoundException {
        return this.repositoryPort.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        return this.repositoryPort.findBYEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void delete(String userId) throws UserNotFoundException {
        final var user = this.getUserById(userId);
        this.repositoryPort.delete(user.getId());
    }

    @Override
    public void add(User user) {
        user.setLastUpdate(new Date());
        this.repositoryPort.persist(user);
    }

    @Override
    public void edit(User user) {
        user.setLastUpdate(new Date());
        this.repositoryPort.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.repositoryPort.findAll();
    }
}
