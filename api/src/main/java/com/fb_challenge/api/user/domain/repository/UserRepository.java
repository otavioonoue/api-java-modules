package com.fb_challenge.api.user.domain.repository;

import java.util.List;

import com.fb_challenge.api.user.domain.entity.User;

public interface UserRepository {
    List<User> getAll();
    User save(User user);
}
