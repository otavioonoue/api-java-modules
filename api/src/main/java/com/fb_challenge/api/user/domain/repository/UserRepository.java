package com.fb_challenge.api.user.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fb_challenge.api.user.domain.entity.User;

public interface UserRepository {
    List<User> getAll();
    User save(User user);
    Optional<User> findById(UUID id);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    void delete(UUID id);
}
