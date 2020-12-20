package com.andry.infra.application.entity;

import org.bson.types.ObjectId;

import java.util.Date;

public class UserEntityBuilder {
    private ObjectId id;
    private String email;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public UserEntityBuilder setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public UserEntityBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntityBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntityBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntityBuilder setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public UserEntity createUserEntity() {
        final var user = new UserEntity();
        user.setId(id);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLastUpdate(lastUpdate);
        return user;
    }
}