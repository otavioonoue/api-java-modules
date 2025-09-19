package com.fb_challenge.api.shared.infrastructure.database.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fb_challenge.api.shared.infrastructure.database.jpa.UserJPA;

public interface JpaUserRepository extends JpaRepository<UserJPA, UUID> {
     boolean existsByEmail(String email);
     boolean existsByCpf(String cpf);
}
