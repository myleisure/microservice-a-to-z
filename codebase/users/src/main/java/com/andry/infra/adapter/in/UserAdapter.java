package com.andry.infra.adapter.in;

import com.andry.domain.application.model.User;
import com.andry.domain.port.out.UserRepositoryPort;
import com.andry.infra.application.mapper.UserEntityMapper;
import com.andry.infra.application.mapper.UserMapper;
import com.andry.infra.application.repository.UserRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userRepository.find("id", new ObjectId(id)).firstResultOptional()
                .map(UserMapper::map);
    }

    @Override
    public Optional<User> findBYEmail(String email) {
        return this.userRepository.find("email", email).firstResultOptional()
                .map(UserMapper::map);
    }

    @Override
    public List<User> findAll() {
        return UserMapper.map(this.userRepository.findAll().list());
    }

    @Override
    public void persist(User user) {
        this.userRepository.persist(UserEntityMapper.map(user));
    }

    @Override
    public void update(User user) {
        this.userRepository.update(UserEntityMapper.map(user));
    }

    @Override
    public void delete(String userId) {
        this.userRepository.delete(this.userRepository.findById(new ObjectId(userId)));
    }
}
