package com.fb_challenge.api.user.application.usecase;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fb_challenge.api.user.application.exception.UserNotExistsException;
import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.domain.repository.UserRepository;
import com.fb_challenge.api.user.domain.usecase.UseCase;

@Service
public class DeleteUserUseCase implements UseCase<UUID, Void> {

    private final UserRepository userRepository;
    
    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	@Override
	public Void execute(UUID input) {
	   Optional<User> user = this.userRepository.findById(input);
		
		if (user.isEmpty()) {
		    throw new UserNotExistsException("User not found!");
		}
	
		this.userRepository.delete(input);
		return null;
	}
}
