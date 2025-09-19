package com.fb_challenge.api.user.application.usecase;

import org.springframework.stereotype.Service;
import com.fb_challenge.api.user.application.exception.DuplicatedKeyException;
import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.domain.repository.UserRepository;
import com.fb_challenge.api.user.domain.usecase.UseCase;

@Service
public class CreateUserUseCase implements UseCase<User, User> {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }

    @Override
    public User execute(User input) {
        boolean isCpfExists = this.userRepository.existsByCpf(input.getCpf());
        boolean isEmailExists = this.userRepository.existsByEmail(input.getEmail());
        
        if (isCpfExists || isEmailExists) {
            throw new DuplicatedKeyException("The email or cpf already exists");
        }
        
        return this.userRepository.save(input);
    }

}
