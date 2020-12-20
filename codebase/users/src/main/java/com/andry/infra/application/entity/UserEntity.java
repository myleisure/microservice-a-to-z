package com.andry.infra.application.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.util.Date;

@MongoEntity(collection = "user")
public class UserEntity {

    private ObjectId id;
    private String email;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public UserEntity() {
    }

    public UserEntity(ObjectId id,
                      String email,
                      String firstName,
                      String lastName,
                      Date lastUpdate) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public ObjectId getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}
