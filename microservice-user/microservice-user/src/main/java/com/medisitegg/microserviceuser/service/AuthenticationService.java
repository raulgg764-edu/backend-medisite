package com.medisitegg.microserviceuser.service;

import com.medisitegg.microserviceuser.models.UserModel;
import com.medisitegg.microserviceuser.repository.Entity.User;

public interface AuthenticationService {

    public User signup(UserModel input);

    public User authenticate(UserModel input);
}