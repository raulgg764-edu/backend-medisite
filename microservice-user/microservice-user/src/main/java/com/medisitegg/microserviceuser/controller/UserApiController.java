package com.medisitegg.microserviceuser.controller;


import com.medisitegg.microserviceuser.models.UserModel;
import com.medisitegg.microserviceuser.responses.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/auth")
public interface UserApiController {

    @PostMapping("/signup")
    public ResponseEntity<UserModel> register(@RequestBody UserModel userNuevo);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authUser(@RequestBody UserModel userCredentials);


}
