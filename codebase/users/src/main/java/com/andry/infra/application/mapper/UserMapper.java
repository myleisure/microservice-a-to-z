package com.andry.infra.application.mapper;

import com.andry.common.model.User;
import com.andry.common.model.UserBuilder;
import com.andry.infra.application.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {
    }

    public static User map(UserEntity entity) {
        if (Objects.isNull(entity)) return null;
        final var user = new UserBuilder().createUser();
        if (Objects.nonNull(entity.getId())) {
            user.setId(entity.getId().toString());
        }
        user.setEmail(entity.getEmail());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setBirthDate(entity.getBirthDate());
        user.setLastUpdate(entity.getLastUpdate());

        return user;
    }

    public static List<User> map(List<UserEntity> userEntities) {
        if (Objects.isNull(userEntities) || userEntities.isEmpty()) return new ArrayList<>();
        return userEntities.stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }
}
