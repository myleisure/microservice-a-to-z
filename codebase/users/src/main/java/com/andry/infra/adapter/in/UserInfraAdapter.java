package com.andry.infra.adapter.in;

import com.andry.domain.application.model.User;
import com.andry.domain.application.model.UserBuilder;
import com.andry.domain.port.out.UserRepositoryPort;
import com.andry.infra.application.entity.UserEntity;
import com.andry.infra.application.entity.UserEntityBuilder;
import com.andry.infra.application.repository.UserRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserInfraAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserInfraAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        final List<UserEntity> list = this.userRepository.findAll().list();
        return list.stream()
                .map(userMapper())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userRepository.findByIdOptional(new ObjectId(id))
                .map(userMapper());

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userRepository.find("email", email).firstResultOptional()
                .map(this.userMapper());
    }

    @Override
    public User update(User user) {
        final var entity = this.mapUserToEntity(user);
        this.userRepository.update(entity);
        return userMapper().apply(entity);
    }

    @Override
    public User persist(User user) {
        final var entity = this.mapUserToEntity(user);
        this.userRepository.persist(entity);
        return userMapper().apply(entity);
    }

    @Override
    public void delete(String id) {
        this.userRepository.deleteById(new ObjectId(id));
    }

    private Function<UserEntity, User> userMapper() {
        return entity -> new UserBuilder()
                .setId(entity.getId() == null ? null : entity.getId().toString())
                .setEmail(entity.getEmail())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setLastUpdate(entity.getLastUpdate())
                .createUser();
    }

    private UserEntity mapUserToEntity(User user) {
        return new UserEntityBuilder()
                .setId(user.getId() == null ? null : new ObjectId(user.getId()))
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setLastUpdate(user.getLastUpdate())
                .createUserEntity();
    }
}
