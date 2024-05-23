package com.medisitegg.microserviceuser.controller.Impl;


import com.medisitegg.microserviceuser.controller.UserApiController;
import com.medisitegg.microserviceuser.models.UserModel;
import com.medisitegg.microserviceuser.repository.Entity.User;
import com.medisitegg.microserviceuser.utils.UserMapper;
import com.medisitegg.microserviceuser.responses.LoginResponse;
import com.medisitegg.microserviceuser.service.AuthenticationService;
import com.medisitegg.microserviceuser.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiControllerImpl implements UserApiController {
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationService authenticationService;

    @Override
    public ResponseEntity<UserModel> register(UserModel userNuevo) {
        UserModel registeredUser = UserMapper.userEntityToUserModel(authenticationService.signup(userNuevo));

        return ResponseEntity.ok(registeredUser);
    }

    @Override
    public ResponseEntity<LoginResponse> authUser(UserModel userCredentials) {
        User authenticatedUser = authenticationService.authenticate(userCredentials);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
