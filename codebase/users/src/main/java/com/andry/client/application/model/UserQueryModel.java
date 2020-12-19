package com.andry.client.application.model;

import javax.ws.rs.FormParam;

public class UserQueryModel {

    @FormParam("email")
    private String email;
    @FormParam("firstname")
    private String firstname;
    @FormParam("lastname")
    private String lastname;

    @Override
    public String toString() {
        return "UserQueryModel{" +
                "email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
