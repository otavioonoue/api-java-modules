package com.fb_challenge.api.user.presentation.mapper;

import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.presentation.dto.CreateUser;
import com.fb_challenge.api.user.presentation.dto.SafeUser;

public class PresentationMapper {
    public static SafeUser toSafe(User user) {
        SafeUser safeUser = new SafeUser(
            user.getId(),
            user.getName(),
            user.getEmail()
        );

        return safeUser;
    }

    public static User toDomain(CreateUser user) {
        User userDomain = new User(
            null,
            user.getName(),
            user.getEmail(),
            user.getCpf(),
            user.getPassword()
        );

        return userDomain;
    }
}
