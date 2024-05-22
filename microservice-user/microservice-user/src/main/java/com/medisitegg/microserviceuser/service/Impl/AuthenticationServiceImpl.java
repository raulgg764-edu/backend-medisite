package com.medisitegg.microserviceuser.service.Impl;


import com.medisitegg.microserviceuser.models.UserModel;
import com.medisitegg.microserviceuser.repository.Entity.User;
import com.medisitegg.microserviceuser.repository.UserRepository;
import com.medisitegg.microserviceuser.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(UserModel input) {
        User newUser = new User();
        newUser.setEmail(input.getEmail());
        newUser.setContrasena(passwordEncoder.encode(input.getContrasena()));
        newUser.setRol(input.getRol());

        return userRepository.save(newUser);
    }

    public User authenticate(UserModel input) {
        System.out.println(input.getContrasena());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getContrasena()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}