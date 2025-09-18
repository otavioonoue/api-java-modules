package com.fb_challenge.api.user.application.usecase;

import org.springframework.stereotype.Service;

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
        return this.userRepository.save(input);
    }

}
