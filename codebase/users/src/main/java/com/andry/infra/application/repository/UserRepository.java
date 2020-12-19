package com.andry.infra.application.repository;

import com.andry.infra.application.entity.UserEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity> {
}
