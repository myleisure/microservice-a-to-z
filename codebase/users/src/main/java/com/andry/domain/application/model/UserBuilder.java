package com.andry.domain.application.model;

import java.util.Date;

public class UserBuilder {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date lastUpdate;

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBuilder setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public User createUser() {
        return new User(id, email, firstName, lastName, birthDate, lastUpdate);
    }
}