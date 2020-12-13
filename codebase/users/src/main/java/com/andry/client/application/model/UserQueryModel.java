package com.andry.client.application.model;

import javax.ws.rs.FormParam;

public class UserQueryModel {
    @FormParam("id")
    private String id;

    @FormParam("email")
    private String email;

    @FormParam("firstname")
    private String firstName;

    @FormParam("lastname")
    private String lastName;

    @FormParam("birthdate")
    private String birthDate;

    public UserQueryModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
