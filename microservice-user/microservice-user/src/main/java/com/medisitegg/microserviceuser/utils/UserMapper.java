package com.medisitegg.microserviceuser.utils;

import com.medisitegg.microserviceuser.models.UserModel;
import com.medisitegg.microserviceuser.repository.Entity.User;


public class UserMapper {

    public static UserModel userEntityToUserModel(User user){
        UserModel model = new UserModel();
        model.setEmail(user.getEmail());
        model.setContrasena(user.getContrasena());
        model.setRol(user.getRol());

        return model;
    }

    public static User userModelToUserEntity(UserModel user){
        User entity = new User();
        entity.setEmail(user.getEmail());
        entity.setContrasena(user.getContrasena());
        entity.setRol(user.getRol());

        return entity;
    }
}
