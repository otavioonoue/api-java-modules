package com.fb_challenge.api.user.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb_challenge.api.user.domain.entity.User;
import com.fb_challenge.api.user.domain.repository.UserRepository;
import com.fb_challenge.api.user.domain.usecase.UseCase;

@Service
public class GetAllUsersUseCase implements UseCase<Void, List<User>> {

    private final UserRepository userRepository;

    public GetAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> execute(Void input) {
        return this.userRepository.getAll();
    }
}
