package com.fb_challenge.api.user.application.usecase;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.domain.repository.UserRepository;
import com.fb_challenge.api.user.domain.usecase.UseCase;

@Service
public class FindUserByIdUseCase implements UseCase<UUID, Optional<User>> {

    private final UserRepository userRepository;
    
    public FindUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	@Override
	public Optional<User> execute(UUID input) {
		Optional<User> user = this.userRepository.findById(input);
		
		return user;
	}
}
