package com.fb_challenge.api.user.infrastructure.mapper;

import com.fb_challenge.api.shared.infrastructure.database.jpa.UserJPA;
import com.fb_challenge.api.user.domain.entity.User;

public class InfrastructureMapper {
    public static User toDomain(UserJPA userJPA) {
        User user = new User(
            userJPA.getId(), 
            userJPA.getName(),
            userJPA.getEmail(), 
            userJPA.getCpf(), 
            userJPA.getPassword()
        );

        return user;
    }

    public static UserJPA toJpa(User user) {
        UserJPA userJPA = new UserJPA();
        userJPA.setId(user.getId());
        userJPA.setName(user.getName());
        userJPA.setEmail(user.getEmail());
        userJPA.setCPf(user.getCpf());
        userJPA.setPassword(user.getPassword());

        return userJPA;
    }
}
