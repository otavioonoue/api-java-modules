package com.fb_challenge.api.user.infrastructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fb_challenge.api.shared.infrastructure.database.jpa.UserJPA;
import com.fb_challenge.api.shared.infrastructure.database.repository.JpaUserRepository;
import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.domain.repository.UserRepository;
import com.fb_challenge.api.user.infrastructure.exception.InfrastructureException;
import com.fb_challenge.api.user.infrastructure.mapper.InfrastructureMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public List<User> getAll() {
        return this.jpaUserRepository.findAll().stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        try {
            UserJPA userJPA = this.jpaUserRepository.saveAndFlush(InfrastructureMapper.toJpa(user));
            return InfrastructureMapper.toDomain(userJPA);
        } catch(Exception e) {
            throw new InfrastructureException("Fail to save the user", e);
        }
    }
    
}
