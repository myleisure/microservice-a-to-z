package com.andry.domain.application.service;

import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceImplTest {

    @Test
    public void testAnnotation(){
        assertTrue(UserServiceImpl.class.isAnnotationPresent(ApplicationScoped.class));
    }

    @Test
    public void getAllUsers() {

    }

}