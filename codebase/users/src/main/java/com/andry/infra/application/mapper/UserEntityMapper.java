package com.andry.infra.application.mapper;

import com.andry.common.model.User;
import com.andry.infra.application.entity.UserEntity;
import org.bson.types.ObjectId;

import java.util.Objects;

public class UserEntityMapper {
    private UserEntityMapper() {
    }

    public static UserEntity map(User user) {
        if (Objects.isNull(user)) return null;

        final var entity = new UserEntity();

        if (Objects.nonNull(user.getId())) {
            entity.setId(new ObjectId(user.getId()));
        }

        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setBirthDate(user.getBirthDate());
        entity.setEmail(user.getEmail());
        entity.setLastUpdate(user.getLastUpdate());
        return entity;
    }
}
