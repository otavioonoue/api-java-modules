package com.fb_challenge.api.user.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fb_challenge.api.shared.infrastructure.database.jpa.UserJPA;
import com.fb_challenge.api.shared.infrastructure.database.repository.JpaUserRepository;
import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.domain.repository.UserRepository;
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
        UserJPA userJPA = this.jpaUserRepository.saveAndFlush(InfrastructureMapper.toJpa(user));
        return InfrastructureMapper.toDomain(userJPA);
    }

	@Override
	public Optional<User> findById(UUID id) {
		return this.jpaUserRepository.findById(id).map(InfrastructureMapper::toDomain);
	}

	@Override
	public boolean existsByEmail(String email) {
		return this.jpaUserRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByCpf(String cpf) {
	    return this.jpaUserRepository.existsByCpf(cpf);
	}

	@Override
	public void delete(UUID id) {
		this.jpaUserRepository.deleteById(id);
	}
    
}
